package com.app.src.dto;

// DTO: What the API RECEIVES from the user (input)
public class ClothingItemRequestDTO {

    private String name;
    private String category;
    private String size;
    private String color;
    private double price;
    private String imageUrl;
    private String notes;

    public String getName()                  { return name; }
    public void setName(String name)         { this.name = name; }
    public String getCategory()              { return category; }
    public void setCategory(String c)        { this.category = c; }
    public String getSize()                  { return size; }
    public void setSize(String size)         { this.size = size; }
    public String getColor()                 { return color; }
    public void setColor(String color)       { this.color = color; }
    public double getPrice()                 { return price; }
    public void setPrice(double price)       { this.price = price; }
    public String getImageUrl()              { return imageUrl; }
    public void setImageUrl(String url)      { this.imageUrl = url; }
    public String getNotes()                 { return notes; }
    public void setNotes(String notes)       { this.notes = notes; }
}