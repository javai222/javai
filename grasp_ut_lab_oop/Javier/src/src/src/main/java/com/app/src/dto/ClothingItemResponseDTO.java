package com.app.src.dto;

import com.app.src.entity.ClothingItem;
import java.time.LocalDate;

public class ClothingItemResponseDTO {

    private Long id;
    private String name;
    private String category;
    private String size;
    private String color;
    private double price;
    private String displayPrice;
    private String imageUrl;
    private String notes;
    private LocalDate createdAt;

    public static ClothingItemResponseDTO fromEntity(ClothingItem item) {
        ClothingItemResponseDTO dto = new ClothingItemResponseDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setCategory(item.getCategory());
        dto.setSize(item.getSize());
        dto.setColor(item.getColor());
        dto.setPrice(item.getPrice());
        dto.setDisplayPrice(item.getDisplayPrice());
        dto.setImageUrl(item.getImageUrl());
        dto.setNotes(item.getNotes());
        dto.setCreatedAt(item.getCreatedAt());
        return dto;
    }

    public Long getId()                        { return id; }
    public void setId(Long id)                 { this.id = id; }
    public String getName()                    { return name; }
    public void setName(String name)           { this.name = name; }
    public String getCategory()                { return category; }
    public void setCategory(String c)          { this.category = c; }
    public String getSize()                    { return size; }
    public void setSize(String size)           { this.size = size; }
    public String getColor()                   { return color; }
    public void setColor(String color)         { this.color = color; }
    public double getPrice()                   { return price; }
    public void setPrice(double price)         { this.price = price; }
    public String getDisplayPrice()            { return displayPrice; }
    public void setDisplayPrice(String dp)     { this.displayPrice = dp; }
    public String getImageUrl()                { return imageUrl; }
    public void setImageUrl(String url)        { this.imageUrl = url; }
    public String getNotes()                   { return notes; }
    public void setNotes(String notes)         { this.notes = notes; }
    public LocalDate getCreatedAt()            { return createdAt; }
    public void setCreatedAt(LocalDate date)   { this.createdAt = date; }
}
