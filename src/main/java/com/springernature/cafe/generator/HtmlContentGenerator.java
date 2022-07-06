package com.springernature.cafe.generator;

import com.springernature.cafe.model.BillDetails;
import com.springernature.cafe.model.Item;

/**
 * Class to generate bill in html format
 */
public class HtmlContentGenerator {

    public String generate(BillDetails billDetails) {
        StringBuilder sb = new StringBuilder("<html><head><title>Bill</title></head>");
        sb.append("<body>Item NameCountPrice (INR)</br>");
        final String breakTag = "</br>";
        for (Item item : billDetails.getItems()) {
            sb.append(item.getDescription() + "" + item.getQuantity() + ""
                    + (item.getQuantity() * item.getPrice()) + breakTag);
        }
        sb.append("Total" + billDetails.getAmount() + breakTag);
        sb.append("Discount " + billDetails.getDiscount() + breakTag);
        sb.append("Final Amount" + billDetails.getFinalAmount() + breakTag);
        sb.append("</body></html>");
        return sb.toString();
    }
}
