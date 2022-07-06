package com.springernature.cafe.strategy;

import com.springernature.cafe.model.BillDetails;
import com.springernature.cafe.model.Item;

import java.util.List;

public class ItemDiscountCalculation implements BillCalculation {
    @Override
    public BillDetails calculate(List<Item> items) {
        double total = 0;
        double latteTotal = 0;
        double latteDiscount = 0;
        double latteTotalPostDiscount = 0;
        for (Item item : items) {
            if (item.getCode().equals("CL") && item.getQuantity() >= 2) {
                latteTotal += item.getPrice() * item.getQuantity();
                latteDiscount = latteTotal * 0.25;
                latteTotalPostDiscount = latteTotal - latteDiscount;
            } else {
                total += item.getPrice() * item.getQuantity();
            }
        }
        return new BillDetails(items, latteDiscount, total + latteTotal, total + latteTotalPostDiscount);
    }
}
