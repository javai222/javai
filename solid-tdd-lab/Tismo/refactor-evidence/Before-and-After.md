## Before

ProductService handles {createProduct(), getAllProducts(), updateProduct(), deleteProduct(), and checkout()} but checkout is a different responsibilty

![before1.png](before1.png)

therefore it violated the SRP SOLID principle

## After

created PaymentService which handles the payment-related operations
![after1.png](after1.png)
![after4.png](after4.png)

<hr>

## Before

Exception messages are hardcoded.

![before2.png](before2.png)

## After

created ErrorMessage constant
![add2.png](add2.png)
now it follows DRY principle - Reusable error message constants
![after2.png](after2.png)

<hr>

## Before

manually creating mocks

![before3.png](before3.png)

## After

a cleaner and more professional usage of mockito
![after3.png](after3.png)

<hr>

## Before

no immutable object

## After

created receipt which cannot be modified
![after5.png](after5.png)

<hr>

more features were added specially unit testings
