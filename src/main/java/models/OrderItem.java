package models;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class OrderItem {
    private UUID orderItemId;
    private UUID orderId;
    private BigDecimal netPrice;
    private int quantity;
    private BigDecimal netTotal;
    private BigDecimal total;

    public OrderItem(BigDecimal netPrice, int quantity) {
        this.orderItemId = UUID.randomUUID();
        this.netPrice = netPrice;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getNetPrice() {
        return Optional.ofNullable(netPrice)
                .map(netPrice -> netPrice.setScale(2, BigDecimal.ROUND_HALF_UP))
                .orElse(new BigDecimal("0.00"));
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getNetTotal() {
        return Optional.ofNullable(netTotal)
                .map(netTotal -> netTotal.setScale(2, BigDecimal.ROUND_HALF_UP))
                .orElse(new BigDecimal("0.00"));
    }

    public void setNetTotal(BigDecimal netTotal) {
        this.netTotal = netTotal;
    }

    public BigDecimal getTotal() {
        return Optional.ofNullable(total)
                .map(total -> total.setScale(2, BigDecimal.ROUND_HALF_UP))
                .orElse(new BigDecimal("0.00"));
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
