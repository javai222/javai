// Created by Cantela, Chris Nelson B. 3/24/26
// COmposed class for a brain. Example uses, Person HAS A Brain, Dog HAS A Brain

package composition_lab;

public class Brain {

    //4 attributes for the brain class
    private int cortisolLevel;
    private int iq;
    private int sleepHours;
    private static int count;

//default constructors
    public Brain () {
        cortisolLevel = 0;
        iq = 0;
        sleepHours = 0;
        count++;
    }

//Parameterized constructors
    public Brain (int cortisolLevel, int iq, int sleepHours) {
        this.cortisolLevel = cortisolLevel;
        this.iq = iq;
        this.sleepHours = sleepHours;
    count++;
    }

//Getter methods for cortisol, iq, and sleep hr
    public int getCortisolLevel () {
        return cortisolLevel;
    }

public int getIQ () {
        return iq;
    }    

    public int getSleepHours () {
        return sleepHours;
    }

//Setter for cortisol, sleep hours, and iq with Validation
    public void setCortisolLevel(int cortisolLevel) {
    if (cortisolLevel < 0) {
        System.out.println("Cortisol level cannot be negative");
    } else if (cortisolLevel > 100) {
        System.out.println("Cortisol level cannot exceed 100");
    } else {
        this.cortisolLevel = cortisolLevel;
    }
}

    
    public void setSleepHours (int sleepHours) {
        if (sleepHours < 0) 
            System.out.println("Sleep hours cannot be negative.");
        else if (sleepHours > 24) 
            System.out.println("Sleep hours cannot exceed 24 hr.");
            else 
            this.sleepHours = sleepHours;
        
        
    }

public void setIQ (int iq) {
    if (iq < 0)
    System.out.println("IQ cannot be negative.");
    else
    this.iq = iq;
}


//Behavioral methods for the brain class and can be overridden
    public void showPerson () {
        System.out.println("There are " + count + " person created.");
    }


//Can be overridden
public void think () {
    System.out.println("I have " + iq);
    cortisolLevel += 10;
} 

//Can be overridden
public void panicMode () {
    System.out.println("PANIC MODEEEEE!! U+1F600");
    cortisolLevel += 50;
    sleepHours -= 2;
}

public void showCortisol () {
    if (cortisolLevel > 60) 
        System.out.println("You have high Cortisol level U+1F600");
     else if (cortisolLevel <= 60) 
        System.out.println("You have low Cortisol level  U+1F600");
    
}

}

