package vendingmachine;

import java.math.BigDecimal;

public class Coke extends Item {
    public Coke() {
        price = new BigDecimal(20);
        this.name = "COKE";
    }
}
