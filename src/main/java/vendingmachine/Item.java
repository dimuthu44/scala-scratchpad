package vendingmachine;

import java.math.BigDecimal;

public abstract class Item {
    String name = null;
    BigDecimal price = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
