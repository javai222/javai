/*
* Child class created by Dolormente, parent class created by De Leon
*/

class Guitar extends instrument {

  // Getting needed attributes
  public Guitar(String name, String type, String material) {
      super("ZVX Electric Guitar", "Electric guitar", "Hardwood");
  }

  // This method was overwritten
  @Override
  public void sound() {
      System.out.println("This electric guitar is the best out of the ones i've tried.");
  }
}

class Violin extends instrument {

  public Violin(String name, String type, String material) {
      super("Vean Vio", "Modern Acoustic", "Tonewoods");
  }

  public void sound() {
      System.out.println("This violin produces exquisite tones unlike other violins.");
  }
}


