package bg.uni.fmi.lab02.streams.entity;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
