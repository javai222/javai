package com.app.src.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

// GRASP: Information Expert - ClothingItem knows its own data, so it handles its own logic
@Entity
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;
    private String size;
    private String color;

    @Column(nullable = false)
    private double price;

    private String imageUrl;
    private String notes;

    @Column(updatable = false)
    private LocalDate createdAt = LocalDate.now();

    // GRASP: Information Expert - ClothingItem knows its price, so it checks affordability
    public boolean isAffordable(double budget) {
        return this.price <= budget;
    }

    // GRASP: Information Expert - ClothingItem knows its own fields, so it matches its own filters
    public boolean matchesFilter(String filterCategory, String filterSize, String filterColor) {
        boolean categoryMatch = filterCategory == null || filterCategory.isEmpty()
                || this.category.equalsIgnoreCase(filterCategory);
        boolean sizeMatch     = filterSize == null || filterSize.isEmpty()
                || this.size.equalsIgnoreCase(filterSize);
        boolean colorMatch    = filterColor == null || filterColor.isEmpty()
                || this.color.equalsIgnoreCase(filterColor);
        return categoryMatch && sizeMatch && colorMatch;
    }

    // GRASP: Information Expert - ClothingItem knows its price, so it formats it for display
    public String getDisplayPrice() {
        return String.format("₱%,.2f", this.price);
    }

    // GRASP: Information Expert - ClothingItem knows its imageUrl, so it checks if one exists
    public boolean hasImage() {
        return this.imageUrl != null && !this.imageUrl.trim().isEmpty();
    }

    // GRASP: Information Expert - ClothingItem knows its required fields, so it validates itself
    public boolean isValid() {
        return this.name != null && !this.name.trim().isEmpty() && this.price >= 0;
    }

    // GRASP: Information Expert - ClothingItem owns all its data, so it builds its own summary
    public String toSummary() {
        return String.format("[%s] %s — %s | Size: %s | Color: %s",
                this.category, this.name, getDisplayPrice(), this.size, this.color);
    }

    // Getters & Setters
    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public String getName()              { return name; }
    public void setName(String name)     { this.name = name; }

    public String getCategory()          { return category; }
    public void setCategory(String c)    { this.category = c; }

    public String getSize()              { return size; }
    public void setSize(String size)     { this.size = size; }

    public String getColor()             { return color; }
    public void setColor(String color)   { this.color = color; }

    public double getPrice()             { return price; }
    public void setPrice(double price)   { this.price = price; }

    public String getImageUrl()          { return imageUrl; }
    public void setImageUrl(String url)  { this.imageUrl = url; }

    public String getNotes()             { return notes; }
    public void setNotes(String notes)   { this.notes = notes; }

    public LocalDate getCreatedAt()      { return createdAt; }
}

