public class ValorantAccount {
    private String userName;
    private String valorantID;
    private String passWord;
    private int valorantPoints;
    private int level;
    private String rank;
    private boolean isActive;

    // Static variable to keep track of the total number of accounts created
    private static int accountCount;

    // Default constructor
    public ValorantAccount() {
        this.userName = "Unknown";
        this.valorantID = "Unknown";
        this.passWord = "Unknown";
        this.valorantPoints = 0;
        this.level = 1;
        this.rank = "Unranked";
        this.isActive = true;
        accountCount++;
    }

    // Parameterized constructor
    public ValorantAccount(String userName, String valorantID, String passWord, int valorantPoints, int level, String rank, boolean isActive) {
        setUserName(userName);
        setValorantID(valorantID);
        setPassWord(passWord);
        setValorantPoints(valorantPoints);

        if (level >= 1) {
            this.level = level;
        } else {
            System.out.println("Invalid level. It must be at least 1.");
            this.level = 1;
        }

        this.rank = rank;
        this.isActive = isActive;
        accountCount++;
    }


    // Getters and setters
    public String getUserName() {
        return userName;
    }

    // Setter for userName with validation
    public void setUserName(String userName) {
        if (userName != null && !userName.trim().isEmpty()) {
            this.userName = userName;
        } else {
            System.out.println("Invalid username. It cannot be empty.");
        }
    }

    // Getter and setter for valorantID
    public String getValorantID() {
        return valorantID;
    }

    
    public void setValorantID(String valorantID) {
        if (valorantID != null && !valorantID.trim().isEmpty()) {
            this.valorantID = valorantID;
        } else {
            System.out.println("Invalid Valorant ID. It cannot be empty.");
        }
    }

    // Getter for valorantID
    public int getValorantPoints() {
        return valorantPoints;
    }

    // Getter for valorantPoints
    public void setValorantPoints(int valorantPoints) {
        if (valorantPoints >= 0) {
            this.valorantPoints = valorantPoints;
        } else {
            System.out.println("Invalid Valorant points. It cannot be negative.");
        }
    }

    // Getter and setter for passWord
    public String getPassWord() {
        return passWord;
    }

   // Setter for passWord with validation
    public void setPassWord(String passWord) {
        if (passWord != null && passWord.length() >= 6) {
            this.passWord = passWord;
        } else {
            System.out.println("Invalid password. It must be at least 6 characters long.");
        }
    }

    // Static method to get the total number of accounts created
    public static int getAccountCount() {
        return accountCount;
    }
}
