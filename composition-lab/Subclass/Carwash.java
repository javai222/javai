/*
* This class represents composed class - CARWASH SERVICE
* Created by Plantilla, Jophel Mark P.
* I used Libag Class by Sir Capunpon, Soap Class by Silva, and Brush Class by De Leon
*/
package composition_lab;

public class Carwash {

    // Attributes 
    private Soap soap;
    private Brush brush;
    private Libag libag;

    // Constructor Injection
    public Carwash(Soap soap, Brush brush, Libag libag) {
        this.soap = soap;
        this.brush = brush;
        this.libag = libag;
    }

    // Setter methods
    public void setSoap(Soap soap) {
        this.soap = soap;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public void setLibag(Libag libag) {
        this.libag = libag;
    }

    // Behaviors 
    public void displayDetails() {
        System.out.println("===== D E T A I L S =====");
        soap.showDetails();        
        brush.describe();          
        libag.describe();          
    }

    public void startWashing() {
        System.out.println("The washing process begins!");
        soap.useSoap();                     
        libag.soak();  
        libag.kuskos();             
    }

    public void finishWash() {
        System.out.println("Finishing the wash...");
        brush.wearOut();
        brush.replace();
        libag.kuskos();     //final scrub     
        System.out.println("Rinsing with water...");
        System.out.println("Washing is done!");
    }
}