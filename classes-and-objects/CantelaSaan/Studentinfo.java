// Author: Saan
// Created by Saan
public class Studentinfo { 
String studentName;           //Instance Variables
int studentnum; 
int Gradelevel;                 
boolean level;   // Flag to check if the student is verified


public static int totalStudents = 0;         //Static Variable

public Studentinfo(){ 
    this.studentName = "unknown"; 
    this.studentnum = 0; 
    this.Gradelevel = 0;           //Default Constructor: Initializes a student with placeholder data.
    this.level = false;
     totalStudents++;

}

    public Studentinfo(String studentName, int studentnum, int Gradelevel) { //Parameterized Constructor: Sets name, number, and grade.
        this.studentName = studentName;
        this.studentnum = studentnum;
        this.Gradelevel = Gradelevel;
        this.level = false; 
        totalStudents++;
    }

         public Studentinfo(String studentName, int studentnum) { //Overloaded Constructor: Sets name and number, defaults grade to 1.
        this.studentName = studentName;
        this.studentnum = studentnum;
        this.Gradelevel = 1; // default grade level 
        this.level = true; 
        totalStudents++;
    }
    
 public static void showTotal() { //Static Method: Displays the total enrollment count across the system.
        System.out.println("Current Enrollment Count: " + totalStudents);

    } 

    public void StudentVerify() { //Checks the verification status based on the 'level' boolean.
         if(level) { 
            System.out.println("You are a Student");
         } else { 
            System.out.println("You are not a Student");
         }
        
    } 

   public void display() { //Prints the student's details to the console.
    System.out.println("Student Name = " + studentName + "\n Student number: " + studentnum + "\n Gradelevel: " + Gradelevel  );
   }

}

//end of Saan object instance

