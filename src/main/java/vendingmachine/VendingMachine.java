package vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * design a vending machine which has different products in various slots and can except 10, 20, 50 and 100 notes.
 * It also except wallet payment, each product has certain quantity and it will decrease once you take out that product from vending machine.
 * 1. accepting cash and wallet payments
 * 2. select slot, price and pay
 * 3. vend the product, cancel transaction
 * 4. admin -> loads the product in vending machine (once a day)
 */
public class VendingMachine {
    private static final VendingMachine vendingMachine = new VendingMachine();
    private List<Item> itemList = new ArrayList<>();

    private VendingMachine() {
    }

    public static VendingMachine getVendingMachineInstance() {
        return vendingMachine;
    }

    public boolean load(List<Item> itemsToLoad) {
        this.itemList.addAll(itemsToLoad);
        printItems();
        return true; // todo: handle errors
    }

    public BigDecimal showPrice(Item item) {
        BigDecimal price = item.price;
        System.out.println("Item price : " + item);
        return price;
    }

    public List<Item> buyItems(List<Item> itemsToBuy, BigDecimal amount) {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itemList) {
            itemList.remove(item);
            total = total.add(item.price);
        }

        System.out.println("Total cost is : " + total);
        printItems();

        return itemsToBuy;
    }

    private void printItems() {
        System.out.print("Remaining items in vending machine are: ");
        for (Item item : itemList) {
            System.out.print(item + ","); // performance hit
        }
        System.out.println("");
    }

}
