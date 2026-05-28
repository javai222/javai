/*
*This class represents book records with title, author, genre, and pages
*Created by Lord Ulrick A. De Leon
*/

public class Book {
    
    // Private Attributes of the Book
    private String title;
    private String author;
    private String genre;
    private int pages;

    // Static Attribute
    private static int totalBooks = 0;

    // Default Constructor
    public Book() {
        title = "Unknown";
        author = "Unknown";
        genre = "Unknown";
        pages = 50;
        totalBooks++;
    }
    //----------------------------------------------------------
    // Parameterized Constructor
    public Book(String title, String author, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        totalBooks++;
    }
    //----------------------------------------------------------
    // Overloaded Constructor
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = 50; // defaut pages
        totalBooks++;
    }
    //----------------------------------------------------------
    // Getter methods
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getGenre(){
        return this.genre;
    }

    public int getPages(){
        return this.pages;
    }
    //----------------------------------------------------------
    // Behavior with Parameters and Validation
    public void setTitle(String title){
        // Validation
        if(title != "")
            this.title = title;
    }

    public void setAuthor(String author){
        // Validation
        if(author != "")
            this.author = author;
    }

    public void setGenre(String genre){
        // Validation
        if(genre != "")
            this.genre = genre;
    }

    public void setPages(int newPages){
        // Object Invariant: Pages must be between 50 and 1000
        if(newPages >= 50 && newPages <= 1000){
            this.pages = newPages;
        }
        else
            System.out.println("Invalid Input.");
    }
    //----------------------------------------------------------
    // Behavior with Validation
    public void borrowBook(){
        System.out.println("Book borrowed.");
    }

    public void returnBook(){
        System.out.println("Book returned.");
    }

    // Static Behavior
    public static void displayTotalBooks(){
        if(totalBooks != 0)
            System.out.println("Total books recorded: " + totalBooks);
        else
            System.out.println("No books recorded yet.");
    }
}