package vendingmachine;

import java.math.BigDecimal;

public class Soda extends Item {
    public Soda() {
        this.price = new BigDecimal(10);
        this.name = "SODA";
    }
}
