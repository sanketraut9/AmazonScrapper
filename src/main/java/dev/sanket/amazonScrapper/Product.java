package dev.sanket.amazonScrapper;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter
    @Setter

    private String skuId;
    private String productName;
    private String productTitle;
    private String description;
    private String category;
    private double mrp;
    private double sellingPrice;
    private int discount;
    private double weight;
    private String brandName;
    private String imageUrl;
    private String laptopSpecification;

    // Add other fields, getters, and setters as needed

    public String toNDJSONString() {
        // Convert the product data to NDJSON format
        // Example:
        return "{ \"skuId\": \"" + skuId + "\", \"productName\": \"" + productName + "\", ... }";
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLaptopSpecification() {
        return laptopSpecification;
    }

    public void setLaptopSpecification(String laptopSpecification) {
        this.laptopSpecification = laptopSpecification;
    }
}

