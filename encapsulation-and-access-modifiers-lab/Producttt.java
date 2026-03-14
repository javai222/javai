

public class Producttt {

    // product details (encapsulated fields)
    private String name;
    private String category;
    private double price;
    private int stock;

    // tracks how many Product instances have been created
    public static int totalProducts = 0;

    // default product when no values are provided
    Producttt() {
        this.name = "Unknown";
        this.category = "Unknown";
        this.price = 0;
        this.stock = 0;
        totalProducts++;
    }

    // product with initial values (validations applied)
    Producttt(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        totalProducts++;

        if(price < 0){
            System.out.println("Price cannot be negative. Setting price to 0.");
            this.price = 0;
        } else {
            this.price = price;
        }

        if(stock < 0){
            System.out.println("Stock cannot be negative. Setting stock to 0.");
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    // getters for read-only access
    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    // allow price updates with validation
    public void setPrice(double price){
        if(price >= 0){
            this.price = price;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    public void addStock(int amount){
        if(amount > 0){
            stock += amount;
        }
    }

    public void sellProduct(int amount){
        if(amount > 0 && amount <= stock){
            stock -= amount;
        } else {
            System.out.println("Not enough stock.");
        }
    }
}
