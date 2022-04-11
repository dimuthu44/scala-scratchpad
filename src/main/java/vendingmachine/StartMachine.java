package vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StartMachine {

    public static void main(String[] args) throws Exception {
        Coke coke = new Coke();
        Soda soda = new Soda();
        List<Item> itemsToLoad = new ArrayList<>();
        itemsToLoad.add(coke);
        itemsToLoad.add(soda);

        VendingMachine vendingMachine = VendingMachine.getVendingMachineInstance();

        vendingMachine.load(itemsToLoad);
        vendingMachine.showPrice(coke);

        // todo : merge into customer object probably with amount and payment method
        BigDecimal balance = vendingMachine.buyItems(List.of(coke), new BigDecimal(30), new Cash());
        System.out.println("Balance rmaining is " + balance);

    }
}


