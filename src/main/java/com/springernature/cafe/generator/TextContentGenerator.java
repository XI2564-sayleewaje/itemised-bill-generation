package com.springernature.cafe.generator;

import com.springernature.cafe.model.BillDetails;
import com.springernature.cafe.model.Item;

/**
 * Class to generate bill in a .txt file
 */
public class TextContentGenerator {

    public String generate(BillDetails billDetails) {
        StringBuilder sb = new StringBuilder("Item Name\t\tCount\t\tPrice (INR)\n");
        for (Item item : billDetails.getItems()) {
            sb.append(item.getDescription() + "\t\t" + item.getQuantity() + "\t\t" + (item.getQuantity() * item.getPrice()) + "\n");
        }
        sb.append("Total\t\t\t\t\t\t" + billDetails.getAmount() + "\n");
        sb.append("Discount\t\t\t\t\t" + billDetails.getDiscount() + "\n");
        sb.append("Final Amount\t\t\t\t" + billDetails.getFinalAmount() + "\n");
        return sb.toString();
    }
}
