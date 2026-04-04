package interfacePkg;

public interface Mogger {

    //Abstract method
    void showcaseMog(int auraLevel);

    // default method
    default void mewing (){
        System.out.println("🤫🧏‍♂️, Sharp jawline executed");
    }
}