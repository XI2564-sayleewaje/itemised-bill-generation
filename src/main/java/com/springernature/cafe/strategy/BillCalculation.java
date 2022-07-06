package com.springernature.cafe.strategy;

import com.springernature.cafe.model.BillDetails;
import com.springernature.cafe.model.Item;

import java.util.List;

public interface BillCalculation {
    BillDetails calculate(List<Item> items);
}
