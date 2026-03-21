import java.util.*;

/*
*This class includes the main method that runs animal, Cat, and GermanShepherd class
*Created by Cantela, Chris Nelson B. 3/21/26
*/
public class Main_Cantela {
    public static void main(String[] args) {

        //Variables needed for the program
Scanner in = new Scanner(System.in);
animal animal;
int choice;
String name;
String breed;
String answer;
boolean changeName;
boolean changePet;
boolean exit = true;  //boolean for the loop

        /*
        What happens during dynamic binding?
        *it means the class or methods that gets executed is determined at runtime.
        *parent class reference (animal animal) can point to a child object, in thsi case Cat or GermanShepherd
        *when the user call overriden methods java decides which version to run at runtime
        *if the object is a cat, the cat's play and sich method runs.
        *if the GermanShepherd, the GermanShepherd's play and sick methods run.
         */

//main loop
while (exit) {
    System.out.print("\nWhat animal do you prefer 1.Cat or 2.German Shepherd? ");
    choice = in.nextInt();

    //Handles the events
    switch (choice) {
        case 1 : {         //If user choose cat
            in.nextLine();

            System.out.println("\n===== CAT ======");
            System.out.print("What is your preferred name? ");
            name = in.nextLine();

            System.out.print("What is your preferred cat Breed? ");
            breed = in.nextLine();
            animal = new Cat(name, breed);      /*"What IS-A relationship in your program?"
                                                 ANSWER: This code shows the is-a relationship because a Cat is an animal*/

            /*
           What methods were inherited from the parent class??
            Answer:  These methods were inherited from the parent class except the getBreed Method
             */
            System.out.println("\nName: " + animal.getName()    //shows info of the cat
                    +  "\nBreed: " + ((Cat) animal).getBreed()   //typecasting
                    +  "\nClassification: " + animal.getClassification()
                    +  "\nType: " + animal.getType());


            //This part prints all the methods including the inherited and new behavior
            System.out.println();

            //What new behavior did the subclass introduce? Answer: This method is a new bahavior from the class cat
            ((Cat) animal).knead();     //typecasting

         // Which method was overridden? Answer: These two methods was overridden
            animal.sick();
            animal.play();

            System.out.print("\nDo you wish to change the name of the Cat? (yes/no) ");
            answer = in.nextLine();

            changeName = answer.equalsIgnoreCase("Yes");   //if yes then the boolean is true

            if (changeName) {    //if the user wants to change name
                System.out.print("\nInput new name: ");
                name = in.nextLine();
                animal.setName(name);

                System.out.println("New Name: " + animal.getName());
            } else System.out.println("Have fun with the name!");        //if no prompt this

            System.out.print("\nWanna change pets? (yes/no) ");         //Ask the user to change pets
            answer = in.nextLine();

            changePet = answer.equalsIgnoreCase("yes");

            if (!changePet)         //if No the program will end, if yes the program will repeat or continue
                exit = false;


            break;
        }

        case 2 : {
            in.nextLine();    //If user choose the dog

            System.out.println("\n===== GERMAN SHEPHERD ======");
            System.out.print("What is your preferred name? ");
            name = in.nextLine();

            animal = new GermanShepherd(name);   /*"What IS-A relationship in your program?"
                                                 ANSWER: This code shows the is-a relationship because a German Shepherd is an animal*/

            /*
            What methods were inherited from the parent class??
            Answer:  These methods were inherited from the parent class except the getBreed Method
             */
            System.out.println("\nName: " + animal.getName()       //Shows the info of the dog
                    +  "\nBreed: " + ((GermanShepherd) animal).getBreed()       //typecasting
                    +  "\nClassification: " + animal.getClassification()
                    +  "\nType: " + animal.getType());


            //This part prints all the methods including the inherited and new behavior
            System.out.println();

    //What new behavior did the subclass introduce? Answer: This method is a new bahavior from the class GermanShepherd
            ((GermanShepherd) animal).guard();      //typecasting

            // Which method was overridden? Answer: These two methods was overridden
            animal.growl();
            animal.play();
            animal.sick();

            System.out.print("\nDo you wish to change the name of your Dog? (yes/no) ");
            answer = in.nextLine();

            changeName = answer.equalsIgnoreCase("Yes");        //if yes then the boolean is true

            if (changeName) {                       //if the user wants to change name
                System.out.print("\nInput new name: ");
                name = in.nextLine();
                animal.setName(name);

                System.out.println("New Name: " + animal.getName());
            } else System.out.println("Have fun with the name!");        //if no prompt this

            System.out.print("\nWanna change pets? (yes/no) ");         //Ask the user to change pets
            answer = in.nextLine();

            changePet = answer.equalsIgnoreCase("yes");         //if No the program will end, if yes the program will repeat or continue

            if (!changePet)
                exit = false;

                break;
        }

        default : System.out.println("Dude really? How did you got that wrong. Try again.");     //try again message
    }

}

        System.out.println("\nGoodbye mah boi!");  //Goodbye/exit message

    }
}