package services;

import models.Order;
import models.OrderItem;

import java.math.BigDecimal;

public class OrderService {

    public static void calculateTax(Order order, OrderItem orderItem, BigDecimal taxPercentage) {
        int quantity = orderItem.getQuantity();
        BigDecimal netPrice = orderItem.getNetPrice();

        BigDecimal taxRate = taxPercentage.divide(BigDecimal.valueOf(100),4, BigDecimal.ROUND_HALF_UP);
        BigDecimal netTotal = netPrice.multiply(BigDecimal.valueOf(quantity));
        BigDecimal taxAmount = netTotal.multiply(taxRate);
        BigDecimal total = netTotal.add(taxAmount);

        orderItem.setNetTotal(netTotal);
        orderItem.setTotal(total);

        order.addToNetTotal(netTotal);
        order.addToTax(taxAmount);
        order.addToTotal(total);

    }
}
