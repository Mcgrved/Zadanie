package models;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private BigDecimal netTotal;
    private BigDecimal tax;
    private BigDecimal total;

    public Order() {
        this.orderId = UUID.randomUUID();
        this.netTotal = BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.tax = BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.total = BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void addToNetTotal(BigDecimal amount) {
        if (this.netTotal == null) {
            this.netTotal = BigDecimal.ZERO;
        }
        this.netTotal = this.netTotal.add(amount);
    }

    public void addToTax(BigDecimal amount) {
        if (this.tax == null) {
            this.tax = BigDecimal.ZERO;
        }
        this.tax = this.tax.add(amount);
    }
    public void addToTotal(BigDecimal amount) {
        if (this.total == null) {
            this.total = BigDecimal.ZERO;
        }
        this.total = this.total.add(amount);
    }

    public UUID getOrderId() {
        return orderId;
    }

    public BigDecimal getNetTotal() {
        return Optional.ofNullable(netTotal)
                .map(netTotal -> netTotal.setScale(2, BigDecimal.ROUND_HALF_UP))
                .orElse(new BigDecimal("0.00"));
    }

    public void setNetTotal(BigDecimal netTotal) {
        this.netTotal = netTotal;
    }

    public BigDecimal getTax() {
        return Optional.ofNullable(tax)
                .map(tax -> tax.setScale(2, BigDecimal.ROUND_HALF_UP))
                .orElse(new BigDecimal("0.00"));
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
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
