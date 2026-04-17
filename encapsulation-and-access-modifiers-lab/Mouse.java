public class Mouse {

    private String brand;
    private String color;
    private String type;

    private static int mouseSales = 0;

    public Mouse() {
        this.brand = "razer";
        this.color = "black";
        this.type = "wireless";
        mouseSales++;
    }

    public Mouse(String brand, String color, String type) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            this.brand = "razer";
        }

        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            this.color = "black";
        }

        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            this.type = "wireless";
        }

        mouseSales++;
    }

    public Mouse(String color, String type) {
        this.brand = "razer";

        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            this.color = "black";
        }

        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            this.type = "wireless";
        }

        mouseSales++;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("Invalid brand.");
        }
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            System.out.println("Invalid color.");
        }
    }

    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            this.type = type;
        } else {
            System.out.println("Invalid type.");
        }
    }

    public void displayItems() {
        System.out.println("Mouse Brand: " + brand);
        System.out.println("Mouse Color: " + color);
        System.out.println("Mouse Type: " + type);
    }

    public static void displayTotalSales() {
        System.out.println("Total Items Sold: " + mouseSales);
    }
}
