import subprocess
import json
import concurrent.futures
from datetime import datetime

def gh_api(path):
    result = subprocess.run(['gh', 'api', path], capture_output=True, text=True)
    if result.returncode != 0:
        return []
    try:
        return json.loads(result.stdout)
    except:
        return []

def check_pr(pr_num):
    # Fetch all data in parallel
    with concurrent.futures.ThreadPoolExecutor(max_workers=4) as ex:
        f_pr = ex.submit(gh_api, f'repos/javai222/javai/pulls/{pr_num}')
        f_reviews = ex.submit(gh_api, f'repos/javai222/javai/pulls/{pr_num}/reviews')
        f_comments = ex.submit(gh_api, f'repos/javai222/javai/issues/{pr_num}/comments')
        f_rc = ex.submit(gh_api, f'repos/javai222/javai/pulls/{pr_num}/comments')
    
    pr_data = f_pr.result()
    reviews = f_reviews.result()
    comments = f_comments.result()
    review_comments = f_rc.result()
    
    if not isinstance(pr_data, dict):
        return None
    
    title = pr_data.get('title', '')
    created_at = pr_data.get('created_at', '')
    date = created_at[:10] if created_at else ''
    
    approvals = 0
    change_requests = 0
    comment_count = 0
    
    # Count reviews
    if isinstance(reviews, list):
        for r in reviews:
            if r.get('user', {}).get('login') == 'grimrex-dev':
                state = r.get('state', '')
                if state == 'APPROVED':
                    approvals += 1
                elif state == 'CHANGES_REQUESTED':
                    change_requests += 1
                elif state == 'COMMENTED':
                    comment_count += 1
    
    # Count issue comments
    if isinstance(comments, list):
        for c in comments:
            if c.get('user', {}).get('login') == 'grimrex-dev':
                comment_count += 1
    
    # Count review comments
    if isinstance(review_comments, list):
        for rc in review_comments:
            if rc.get('user', {}).get('login') == 'grimrex-dev':
                comment_count += 1
    
    points = approvals + comment_count + (change_requests * 2)
    
    if points > 0:
        return {
            'pr': pr_num,
            'date': date,
            'title': title,
            'approvals': approvals,
            'comments': comment_count,
            'change_requests': change_requests,
            'points': points
        }
    return None

pr_numbers = [389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654]

results = []
print(f"Processing {len(pr_numbers)} PRs...")

with concurrent.futures.ThreadPoolExecutor(max_workers=8) as executor:
    future_to_pr = {executor.submit(check_pr, pr): pr for pr in pr_numbers}
    done = 0
    for future in concurrent.futures.as_completed(future_to_pr):
        done += 1
        if done % 20 == 0:
            print(f"  Progress: {done}/{len(pr_numbers)}")
        result = future.result()
        if result:
            results.append(result)

results.sort(key=lambda x: x['pr'])

output_path = '/home/runner/work/javai/javai/grimrex_results.json'
with open(output_path, 'w') as f:
    json.dump(results, f, indent=2)

print(f"\nSaved {len(results)} PRs with grimrex-dev activity to {output_path}")
print(f"\nTotal points: {sum(r['points'] for r in results)}")
print(f"\nFull table:")
print(f"{'PR':<6} {'Date':<12} {'A':>3} {'C':>3} {'CR':>3} {'Pts':>4}  Title")
print("-" * 80)
for r in results:
    print(f"PR#{r['pr']:<4} {r['date']:<12} {r['approvals']:>3} {r['comments']:>3} {r['change_requests']:>3} {r['points']:>4}  {r['title'][:45]}")

total_approvals = sum(r['approvals'] for r in results)
total_comments = sum(r['comments'] for r in results)
total_cr = sum(r['change_requests'] for r in results)
total_pts = sum(r['points'] for r in results)
print(f"\nTotals: Approvals={total_approvals}, Comments={total_comments}, Change Requests={total_cr}, Points={total_pts}")
