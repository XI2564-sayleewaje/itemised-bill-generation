package com.springernature.cafe.strategy;

import com.springernature.cafe.model.BillDetails;
import com.springernature.cafe.model.Item;

import java.util.List;

/**
 * This class calculates the total bill amount by applying discount
 */
public class RangeDiscountCalculation implements BillCalculation {

    @Override
    public BillDetails calculate(List<Item> items) {
        int amount = 0;
        double discount = 0.0;
        for (Item item : items) {
            amount += item.getPrice() * item.getQuantity();
        }
        //discount calculation
        if (amount >= 200) {
            discount = (200 * 0.1) + (amount - 200) * 0.2;
        } else if (amount >= 100) {
            discount = amount * 0.1;
        }

        return new BillDetails(items, discount, amount, amount - discount);
    }
}
