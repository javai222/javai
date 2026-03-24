public class HDLotion {

  private String lotionBrand;
  private String lotionName;
  private String lotionType;
  private String lotionModel;
  private String lotionScent;
  private int lotionPrice;
  private int moistureLevel;
  private double lotionML;
  
public HDLotion() {
  this.lotionBrand = "Unknown";
  this.lotionName = "Unknown";
  this.lotionType = "Unknown";
  this.lotionModel = "Unknown";
  this.lotionScent = "Unknown";
  this.lotionPrice = 0;
  this.moistureLevel = 0;
  this.lotionML = 0; 
}

public HDLotion(String lotionBrand, String lotionName, String lotionType, String lotionModel, String lotionScent, int lotionPrice, int moistureLevel, double lotionML) {
  this.lotionBrand = lotionBrand;
  this.lotionName = lotionName;
  this.lotionType = lotionType;
  this.lotionModel = lotionModel;
  this.lotionScent = lotionScent;
  this.lotionPrice = lotionPrice;
  this.moistureLevel = moistureLevel;
  this.lotionML = lotionML;
}

public String getLotionBrand() {
  return lotionBrand;
}

public String getLotionName() {
  return lotionName;
}

public String getLotionType() {
  return lotionType;
}

public String getLotionModel() {
  return lotionModel;
}

public String getLotionScent() {
  return lotionScent;
}

public int getLotionPrice() {
  return lotionPrice;
}

public int getMoistureLevel() {
  return moistureLevel;
}
  
public double getLotionML() {
  return lotionML;
}

public void displayLotion() {
  System.out.println("= = = = = = = Lotion Details = = = = = = =\n"
                    + "\Brand: " + lotionBrand
                    + "\nName: " + lotionName
                    + "\nType: " + lotionType
                    + "\nModel: " + lotionModel
                    + "\nScent: " + lotionScent
                    + "\nPrice: " + lotionPrice
                    + "\nMoisture Level: " + moistureLevel
                    + "\nAmount: " + lotionML
                    + "\n= = = = = = = = = = = = = = = = = = = =");
}

public void lotionOpen() {
  System.out.println("The lotion is opened.");
}
  
public void lotionClose() {
  System.out.println("The lotion is closed.");
}
  
}
