package com.springernature.cafe.model;

import java.util.List;

public class BillDetails {
    private List<Item> items;
    private double discount;
    private double amount;
    private double finalAmount;

    public BillDetails(List<Item> items, double discount, double amount, double finalAmount) {
        this.items = items;
        this.discount = discount;
        this.amount = amount;
        this.finalAmount = finalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
