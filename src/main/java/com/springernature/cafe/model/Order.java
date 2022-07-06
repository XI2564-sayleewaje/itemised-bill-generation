package com.springernature.cafe.model;

import com.springernature.cafe.generator.BillGenerator;
import com.springernature.cafe.strategy.BillCalculation;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> orderedItems;
    private final Items items;

    public Order() {
        orderedItems = new ArrayList<>();
        items = new Items();
    }

    public void addItem(String code, int quantity) {
        Item item = items.getMenuItems().get(code);
        item.setQuantity(quantity);
        orderedItems.add(item);
    }

    public double calculateTotal(BillCalculation billCalculation, BillGenerator.BillType billType) {
        if (orderedItems.isEmpty()) {
            return 0.0;
        }
        BillDetails billDetails = billCalculation.calculate(orderedItems);
        BillGenerator.generate(billType, billDetails, this.getClass().getResource("/").getPath());
        return billDetails.getFinalAmount();
    }

    @Override
    public String toString() {
        return "Order{items = " + items + '}';
    }
}
