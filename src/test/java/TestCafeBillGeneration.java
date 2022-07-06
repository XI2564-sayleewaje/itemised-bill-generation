import com.springernature.cafe.strategy.ItemDiscountCalculation;
import com.springernature.cafe.model.Order;
import com.springernature.cafe.generator.BillGenerator;
import com.springernature.cafe.strategy.RangeDiscountCalculation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCafeBillGeneration {

    private Order order;

    @Before
    public void before() {
        order = new Order();
    }

    @Test
    public void testBillAmountNoItems() {
        assertEquals(0.0, order.calculateTotal(new RangeDiscountCalculation(), BillGenerator.BillType.TEXT), 0.0);
    }

    @Test
    public void testBillAmountLessThan100() {
        order.addItem("TM", 3);
        order.addItem("TI", 4);
        assertEquals(90.0, order.calculateTotal(new RangeDiscountCalculation(), BillGenerator.BillType.HTML), 0.0);
    }

    @Test
    public void testBillAmountBetween100And200() {
        order.addItem("CL", 1);
        order.addItem("TI", 3);
        order.addItem("CDP", 2);
        assertEquals(103.5, order.calculateTotal(new RangeDiscountCalculation(), BillGenerator.BillType.TEXT), 0.0);
    }

    @Test
    public void testBillAmountBetweenMoreThan200() {
        order.addItem("CM", 4);
        order.addItem("TL", 5);
        order.addItem("CDC", 2);
        assertEquals(240.0, order.calculateTotal(new RangeDiscountCalculation(), BillGenerator.BillType.TEXT), 0.0);
    }

    @Test
    public void testItemDiscountForTwoLatte() {
        order.addItem("CL",2);
        assertEquals(45.0, order.calculateTotal(new ItemDiscountCalculation(), BillGenerator.BillType.TEXT), 0.0);
    }

    @Test
    public void testItemDiscountForMoreThanTwoLatteAndTea() {
        order.addItem("CL",3);
        order.addItem("TI", 1);
        assertEquals(82.5, order.calculateTotal(new ItemDiscountCalculation(), BillGenerator.BillType.TEXT), 0.0);
    }

    @After
    public void after() {
        order = null;
    }
}
