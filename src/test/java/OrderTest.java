import models.Order;
import models.OrderItem;
import org.junit.jupiter.api.Test;
import services.OrderService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {

    @Test
    public void testTaxCalculation1() {
        BigDecimal taxPercentage = BigDecimal.valueOf(10.00);
        Order order = new Order();
        List<OrderItem> orderItemsList = createTestOrderItems1();

        for (OrderItem orderItem : orderItemsList) {
            OrderService.calculateTax(order, orderItem, taxPercentage);
        }

        assertEquals(new BigDecimal("1122.00"), order.getTotal());
        assertEquals(new BigDecimal("102.00"), order.getTax());

    }

    @Test
    public void testTaxCalculation2() {
        BigDecimal taxPercentage = BigDecimal.valueOf(23.55);
        Order order = new Order();
        List<OrderItem> orderItemsList = createTestOrderItems2();

        for (OrderItem orderItem : orderItemsList) {
            OrderService.calculateTax(order, orderItem, taxPercentage);
        }

        assertEquals(new BigDecimal("45470.42"), order.getTotal());
        assertEquals(new BigDecimal("8667.17"), order.getTax());

    }

    private List<OrderItem> createTestOrderItems1() {
        List<OrderItem> orderItemsList = new ArrayList<>();

        OrderItem orderItem1 = new OrderItem(new BigDecimal("10.00"), 100); //1000 + 100 = 1100
        OrderItem orderItem2 = new OrderItem(new BigDecimal("1.0"), 10); //10 + 1 = 11
        OrderItem orderItem3 = new OrderItem(new BigDecimal("5.0"), 2); //10 + 1 = 11  ==== 1122


        orderItemsList.add(orderItem1);
        orderItemsList.add(orderItem2);
        orderItemsList.add(orderItem3);

        return orderItemsList;
    }

    private List<OrderItem> createTestOrderItems2() {
        List<OrderItem> orderItemsList = new ArrayList<>();

        OrderItem orderItem1 = new OrderItem(new BigDecimal("49.65"), 689); //34 208,85 + 8 056,18 = 42 265,03
        OrderItem orderItem2 = new OrderItem(new BigDecimal("213.7"), 12); //2564,4 + 603,92 = 3168,32
        OrderItem orderItem3 = new OrderItem(new BigDecimal("5.0"), 6); // 30,0 + 7,07 = 37,07

        orderItemsList.add(orderItem1);
        orderItemsList.add(orderItem2);
        orderItemsList.add(orderItem3);

        return orderItemsList;
    }


}
