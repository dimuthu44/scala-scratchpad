package vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StartMachine {

    public static void main(String[] args) {
        Coke coke = new Coke();
        Soda soda = new Soda();
        List<Item> itemsToLoad = new ArrayList<>();
        itemsToLoad.add(coke);
        itemsToLoad.add(coke);

        VendingMachine vendingMachine = VendingMachine.getVendingMachineInstance();

        vendingMachine.load(itemsToLoad);
        vendingMachine.showPrice(coke);


        vendingMachine.buyItems(List.of(coke), new BigDecimal(30));

    }
}


