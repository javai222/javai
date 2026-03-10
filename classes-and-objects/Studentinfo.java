public class Studentinfo { 
String studentName; 
int studentnum; 
int Gradelevel; 
boolean level;


public static int totalStudents = 0;

public Studentinfo(){ 
    this.studentName = "unknown"; 
    this.studentnum = 0; 
    this.Gradelevel = 0; 
    this.level = false;
     totalStudents++;

}

    public Studentinfo(String studentName, int studentnum, int Gradelevel) {
        this.studentName = studentName;
        this.studentnum = studentnum;
        this.Gradelevel = Gradelevel;
        this.level = false; 
        totalStudents++;
    }

         public Studentinfo(String studentName, int studentnum) {
        this.studentName = studentName;
        this.studentnum = studentnum;
        this.Gradelevel = 1; // default grade level 
        this.level = true; 
        totalStudents++;
    }
    
 public static void showTotal() {
        System.out.println("Current Enrollment Count: " + totalStudents);

    } 

    public void StudentVerify() { 
         if(level) { 
            System.out.println("You are a Student");
         } else { 
            System.out.println("You are not a Student");
         }
        
    } 

   public void display() { 
    System.out.println("Student Name = " + studentName + "\n Student number: " + studentnum + "\n Gradelevel: " + Gradelevel  );
   }

}
