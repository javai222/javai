/*
*This class is created by Cantela, Chris Nelson B.

What abstract class did you create?
- PaymentMethod abstract class
What interface did you create?
- Discountable interface
What methods did you override?
- useCellphone(), chargeCellphone(), getPhoneColor,
displayCellphoneInfo(), outdated(), and updatePhone(), in both Iphone and AndroidPhone classes
What methods did you overload?
- sendMessage() in both Iphone and AndroidPhone classes
Where does dynamic binding occur in your code?
- When creating Cellphone objects at runtime (Iphone or AndroidPhone)
Which part shows polymorphism?
- The use of the Cellphone reference to call overridden methods
How does your design achieve low coupling?
- By using interfaces and abstract classes to define contracts without specifying implementation details
How does your design achieve high cohesion?
- Each class has a single responsibility and related methods grouped together
*/

package demo;
import abstraction.Cellphone;
import interfacePkg.UpdateOS;
import java.util.Scanner;

import Implementation1.AndroidPhone;
import Implementation1.Iphone;


public class AbstractionPolyDemo_Cantela {
    public static void main(String[] args) {
        //Attributes needed
        Scanner in = new Scanner(System.in);
        Cellphone cellphone;
        int choice = 0;
        String model;
        String color;
        double version;
        String message;
        String recipient;
        String time;

        //asks user which brand to use
        System.out.print("WELCOME"
                +    "\nWhat Brand do you want to use (1 - Iphone 2 - Android)? ");
        choice = in.nextInt();

        //if user chooses iphone
        if (choice == 1) {
            in.nextLine();
            System.out.print("\nEnter Iphone Model (e.g Iphone 15): ");
            model = in.nextLine();

            System.out.print("Enter color: ");
            color = in.nextLine();

            System.out.print("Enter Iphone Version (e.g 26.4): ");
            version = in.nextDouble();

            //create iphone object at runtime, represents dynamic binding
            cellphone = new Iphone("Iphone", model, color, version);

            System.out.println();
            cellphone.useCellphone();           //Call overridden methods then show info
            cellphone.chargeCellphone();
            cellphone.displayCellphoneInfo();

            UpdateOS os = new Iphone("Iphone", model, color, version);
            System.out.println();
            os.outdated();
            os.updatePhone();

            in.nextLine();
            System.out.print("\nEnter message you want to send: ");
            message = in.nextLine();

            System.out.print("Enter recipient: ");
            recipient = in.nextLine();

            System.out.print("Enter time stamp: ");
            time = in.nextLine();

            //use of overloaded sendMessage methods
            Iphone iphone = new Iphone("Iphone", model, color, version);
            iphone.sendMessage(recipient, message);
            iphone.sendMessage(recipient, message, time);

        } else if (choice == 2) {  //if user chooses Android
            in.nextLine();
            System.out.print("\nEnter Android Model (e.g Samsung S25): ");
            model = in.nextLine();

            System.out.print("Enter color: ");
            color = in.nextLine();

            System.out.print("Enter Android Version (e.g 16): ");
            version = in.nextDouble();

            //create Android object at runtime, represents dynamic binding
            cellphone = new AndroidPhone("Android", model, color, version);

            System.out.println();
            cellphone.useCellphone();           //Call overridden methods then show info
            cellphone.chargeCellphone();
            cellphone.displayCellphoneInfo();

            UpdateOS os = new AndroidPhone("Android", model, color, version);
            System.out.println();
            os.outdated();
            os.updatePhone();


            in.nextLine();
            System.out.print("\nEnter message you want to send: ");
            message = in.nextLine();

            System.out.print("Enter recipient: ");
            recipient = in.nextLine();

            System.out.print("Enter time stamp: ");
            time = in.nextLine();

            //use of overloaded sendMessage methods
            AndroidPhone android = new AndroidPhone("Android", model, color, version);
            android.sendMessage(recipient, message);
            android.sendMessage(recipient, message, time);
        }
    }
}
