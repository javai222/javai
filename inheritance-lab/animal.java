public class animal {
    private String name;
    private String classification;
    private String type;

    animal(String name, String classification, String type) {
        this.name = name;
        this.classification = classification;
        this.type = type;
    }

    void play() {
        System.out.print(name +" is playing.")
    }
    void growl() {
        System.out.print(name +" is growling.")
    }
    void sick() {
        System.out.print("Animal not feeling well.")
    }
}