package bg.uni.fmi.lab02.streams.entity;

import java.math.BigDecimal;

public class Item {

    private String description;
    private BigDecimal price;

    public Item(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
