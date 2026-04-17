package abstraction;

// This Class is made by Torrefranca :)))

public abstract class AnimeChar {

    // attributes
    private String name;
    private String anime;
    private int powerLevel;

    // default constructor
    public AnimeCharacter() {
        this.name = "Unknown";
        this.anime = "Unknown";
        this.powerLevel = 0;
    }

    // parameterized constructor
    public AnimeCharacter(String name, String anime, int powerLevel) {
        setName(name);
        setAnime(anime);
        setPowerLevel(powerLevel);
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAnime() {
        return anime;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    // setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setAnime(String anime) {
        if (anime != null && !anime.trim().isEmpty()) {
            this.anime = anime;
        } else {
            this.anime = "Unknown";
        }
    }

    public void setPowerLevel(int powerLevel) {
        if (powerLevel >= 0) {
            this.powerLevel = powerLevel;
        } else {
            this.powerLevel = 0;
        }
    }

    // abstract method
    public abstract void usePower();

    // concrete method
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Anime: " + anime);
        System.out.println("Power Level: " + powerLevel);
    }

    // concrete method
    public void train() {
        powerLevel += 100;
        System.out.println(name + " trained! Power is now " + powerLevel);
    }
}
