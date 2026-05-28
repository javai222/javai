public class marketplaceNotifications {
    /*
    * This class manages notifications for NU Marketplace app, 
    * tracking the recipient, the content, and the read status.
    * class created by Quimpan
    */

    // Attributes
    String recipientUser;
    String message;
    String type; // "Order Update", "Promotion", "Message"
    boolean isRead;

    // Static attribute to track no. of notifications sent by the app
    static int totalNotificationsSent = 0;

    // Default constructor ( for new users)
    marketplaceNotifications() {
        this.recipientUser = "New user";
        this.message = "Welcome to the Marketplace!";
        this.type = "System";
        this.isRead = false;
        totalNotificationsSent++;
    }

    // Parameterized constructor ( for full control)
    marketplaceNotifications(String recipientUser, String message, String type) {
        this.recipientUser = recipientUser;
        this.message = message;
        this.type = type;
        this.isRead = false;
        totalNotificationsSent++;
    }

    // Overloaded constructor ( for all users) 
    marketplaceNotifications(String message) {
        this.recipientUser = "All Users";
        this.message = message;
        this.type = "Broadcast";
        this.isRead = false;
        totalNotificationsSent++;
    }

    // Getters
    public String getRecipient() {
        return this.recipientUser;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getReadStatus() {
        return this.isRead;
    }

    // Behavior without parameters ( Displays notification details)
    void viewNotification() {
        String status = isRead ? "[Read]" : "[Unread]";
        System.out.println(status + " To: " + recipientUser);
        System.out.println("Category: " + type);
        System.out.println("Message: " + message);
    }

    // Behavior with parameters ( Updates the notification content)
    void updateMessage(String newMessage) {
        this.message = newMessage;
        System.out.println("Notification content has been updated.");
    }

    void markAsRead() {
        this.isRead = true;
        System.out.println("Notification for " + recipientUser + " marked as read.");
    }

    // Static method ( Shows how many notifications the system has sent)
    static void displayTotalNotificationsSent() {
        System.out.println("Total notifications sent by system: " + totalNotificationsSent);
    }
}
