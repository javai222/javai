public class ObjectDetailsPrinter {
    public static void main(String[] args) {
        // This is the object instance created from the Student class
        // Object using default constructor
        Student s1 = new Student();

        // Object using parameterized constructor
        Student s2 = new Student("Maria", 20, "BSCS");

        // Object using overloaded constructor
        Student s3 = new Student("Carlos", "BSIT");

        // Print attributes and trigger behaviors
        s1.introduce();
        s2.introduce();

        // Method with parameter
        s2.updateCourse("BS Data Science");

        // Static method
        Student.displayTotalStudents();


        //Object created (Cantela), Class created (Saan)
        // This is the object instance created from the Studentinfo class
        System.out.println("=====================================");
        System.out.println("      Student Information System");
        System.out.println("=====================================\n");

        //Default Constructor
        Studentinfo student1 = new Studentinfo();
        student1.display();
        student1.StudentVerify();
        System.out.println();

        //Parameterized Constructor (Name, Number, Grade)
        Studentinfo student2 = new Studentinfo("Maria Santos", 1001, 10);
        student2.display();
        student2.StudentVerify();
        System.out.println();

        // Test 3: Overloaded Constructor (Name, Number)
        Studentinfo student3 = new Studentinfo("Juan Dela Cruz", 1002);
        student3.display();
        student3.StudentVerify();
        System.out.println();

        // Display total number of students created
        System.out.println("Display Total Students");
        Studentinfo.showTotal();
    }
}

// javac classes-and-objects-lab/Student.java classes-and-objects-lab/ObjectDetailsPrinter.java
// java -cp classes-and-objects-lab ObjectDetailsPrinter
