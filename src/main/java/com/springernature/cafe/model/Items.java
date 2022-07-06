package com.springernature.cafe.model;

import java.util.HashMap;
import java.util.Map;

public class Items {
    private final Map<String, Item> menuItems = new HashMap<>();

    public Items() {
        this.initMenuItems();
    }

    private void initMenuItems() {
        menuItems.put("TM", new Item("TM", "Masala Tea", 10));
        menuItems.put("TI", new Item("TM", "Ice Tea", 15));
        menuItems.put("TL", new Item("TM", "Lemon Tea", 15));
        menuItems.put("CC", new Item("CC", "Cold Coffee", 15));
        menuItems.put("CL", new Item("CL", "Latte Coffee", 30));
        menuItems.put("CM", new Item("CM", "Mocha Coffee", 40));
        menuItems.put("CDC", new Item("CDC", "Coke", 20));
        menuItems.put("CDP", new Item("CDP", "Pepsi", 20));
        menuItems.put("CDS", new Item("CDS", "Sprite", 15));

    }

    public Map<String, Item> getMenuItems() {
        return this.menuItems;
    }

}
