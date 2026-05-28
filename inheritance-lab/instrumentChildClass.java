/*
* Child class created by Dolormente, parent class created by De Leon
*/

class Guitar extends instrument {                                                             // This line of code shows the IS-A relationship because guitar is an instrument
                                                                   
  public Guitar(String name, String type, String material) {                                  // Getting needed attributes
      super(name, type, material);                          
  }

  public static void playChord() {                                                            // New behavior created
      System.out.println("Strumming a chord on the guitar.");                                 
}
  
  @Override                                                                                   // This method was overriden
  public void sound() { 
      System.out.println("This electric guitar is the best sounding one out of the ones i've tried.");
  }
}

class Violin extends instrument {                                                             // This line of code shows the IS-A relationship because violin is an instrument

  public Violin(String name, String type, String material) {                                  // Getting needed attributes
      super(name, type, material);
  }

  public static void useBow() {                                                               // New behavior created
      System.out.println("Using the bow to play the violin smoothly.");
}
  
  @Override                                                                                   // This method was overriden
  public void sound() {
      System.out.println("This violin produces exquisite tones unlike other violins.");
  }
}
