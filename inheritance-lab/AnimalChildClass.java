/*
*two child classes of the parent class animal. Cat and GermanShepherd class.
*created by Cantela, Chris Nelson B. 3/21/26
*/
 
 
 class Cat extends animal {
    private String breed;  //new attributes for Cat class

    public String getBreed () {         //get the breed
        return this.breed;
    }

    public Cat () {   //default constructor for cat class
        super();
    }

    //Parameterized constructor for cat class
public Cat (String name, String breed) {
        super(name, "Mammal", "Domestic Animal");
        this.breed = breed;
  }

  //New method
  public void knead () {
      System.out.println(getName() + " is kneading the pillow");
  }

  //Overrided methods: play and sick method
  @Override
    public void play() {
      System.out.println(getName() + " is playing with a yarn ball");
  }

  @Override
    public void sick() {
      System.out.println(getName() + " is sick but stays nonchalant\uD83D\uDE38\uD83D\uDD76\uFE0F");
  }
}

class GermanShepherd extends animal{
    private String breed;       //exclusive attributes for this class

    public String getBreed () {         //get the breed
        return this.breed;
    }

    public GermanShepherd (String name) {           //Parameterized constructor
        super(name, "Mammal", "Domestic Animal");
        this.breed = "German Shepherd";
    }

    public GermanShepherd () {          //default constructor
        super();
    }

    //New method
    public void guard() {
        System.out.println(getName() + " is guarding its owner with alertness");
    }

    //Overrided methods: growl, play, and sick
    @Override
    public void growl () {
        System.out.println(getName() + " is growling with intent to kill");
    }

    @Override
    public void play () {
        System.out.println(getName() + " is playing with a grenade");
    }

    @Override
    public void sick () {
        System.out.println("German Shepherd don't get sick\uD83D\uDCAA");
    }

}
