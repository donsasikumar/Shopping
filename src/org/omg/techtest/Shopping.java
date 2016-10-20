package org.omg.techtest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by don on 20/10/2016.
 */
public class Shopping {
    private enum Item {
        APPLE(0.60), ORANGE(0.25);

        Item(double price) {
            this.price = price;
        }

        private double price;
    }

    private final List<Item> Basket = new ArrayList<>();
    private final Logger LOGGER = Logger.getLogger("Shopping.class");

    /**
     * getCart
     * @return Shopping Cart which contains the List of Items
     */
    List<Item> getCart() {
        return Basket;
    }

    /**
     * addItemTo
     * @param item which can be an Apple or an Orange
     * @return True if the Item is valid and was added to the list
     */

    boolean addItemTo(Item item) {
        return Basket.add(item);
    }

    /**
     * getTotal
     * @return the total amount of all the items added to the cart.
     */

    double getTotal() {
        double total = 0;
        for (Item item : Basket) {
            total = total + item.price;
        }
        LOGGER.info(Basket + " => £" + total);
        return total;
    }

}
