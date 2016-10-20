package org.omg.techtest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by don on 20/10/2016.
 */
public class Shopping {
    enum Item {
        APPLE(0.60), ORANGE(0.25);

        Item(double price) {
            this.price = price;
        }

        private double price;
    }

    private final List<Item> Basket = new ArrayList<>();
    private volatile double total = 0;
    private final Logger LOGGER = Logger.getLogger("Shopping.class");


    public double getTotal() {
        return total;
    }


    /**
     * getCart
     * @return Shopping Cart which contains the List of Items
     */
    List<Item> getCart() {
        return Basket;
    }

    /**
     * addItem
     * @param item which can be an Apple or an Orange
     * @return True if the Item is valid and was added to the list
     */

    boolean addItem(Item item) {
        return Basket.add(item);
    }

    /**
     * calculateTotal
     * @return the total amount of all the items added to the cart.
     */

    double calculateTotal() {
        total = 0;
        for (Item item : Basket) {
            total = total + item.price;
        }
        LOGGER.info(Basket + " => £" + total);
        return total;
    }

    /**
     * getQuantity method
     * @param item
     * @return total Number of Item of that type added to the cart
     */

    int getQuantity(Item item){
        int quantity = 0;
        for(Item fruit:Basket){
            if(fruit==item){
                quantity++;
            }
        }
        return quantity;
    }

    /**
     * applyAppleOffer method
     * @return total after applying apple offer
     */
    double applyAppleOffer(){
        if(total==0){
            total = calculateTotal();
        }
        total = total-(Item.APPLE.price*((getQuantity(Item.APPLE))/2));
        System.out.printf("New Total after applying Apple Offer=> £%.2f", total);
        System.out.println();
        return total;
    }

    /**
     * applyOrangeOffer
     * @return total after applying orange offer
     */

    double applyOrangeOffer(){
        if(total==0){
            total = calculateTotal();
        }
        total = total - (Item.ORANGE.price*(getQuantity(Item.ORANGE)/3));
        System.out.printf("New Total after applying Orange Offer=> £%.2f", total);
        System.out.println();
        return total;

    }

}
