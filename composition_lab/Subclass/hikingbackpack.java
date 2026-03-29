package composition_lab;
//subclass of backpack created by Kenneth Saan and component creatd by Balanon 
class HikingBackpack extends Backpack {
    
    // Additional attributes for HikingBackpack
    private boolean hasHydrationSystem;
    private String material;

    // Constructor
    public HikingBackpack(double capacity, int compartments, boolean hasHydrationSystem, String material) {
        super(capacity, compartments); // Call the constructor of the Backpack class
        this.hasHydrationSystem = hasHydrationSystem;
        this.material = material;  
    }

    // Getter for hydration system
    public boolean hasHydrationSystem() {
        return hasHydrationSystem;
    }

    // Setter for hydration system
    public void setHydrationSystem(boolean hasHydrationSystem) {
        this.hasHydrationSystem = hasHydrationSystem;
    }

    // Getter for material
    public String getMaterial() {
        return material;
    }

    // Setter for material
    public void setMaterial(String material) {
        this.material = material;

        public void addItem(double weight) {
            double newLoad = getLoad() + weight;
            if (newLoad <= getCapacity()) {
                setLoad(newLoad);
                System.out.println("Item added. Current load: " + getLoad());
            } else {
                System.out.println("Cannot add item. bag might be full.");
            }
            public void removeItem(double weight) {
                double newLoad = getLoad() - weight;
                if (newLoad >= 0) {
                    setLoad(newLoad);
                    System.out.println("Item removed. Current load: " + getLoad());
                } else {
                    System.out.println("Cannot remove item. the item is not inside the bag.");
                }
            }
        }
    }
}