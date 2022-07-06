package com.springernature.cafe.model;

public class Item {
    private final String code;
    private final String description;
    private final float price;
    private int quantity;

    public Item(String code, String description, float price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{code=" + code + ", description=" + description + ", price=" + price + "}";
    }
}
