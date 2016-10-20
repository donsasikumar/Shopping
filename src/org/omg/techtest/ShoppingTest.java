package org.omg.techtest;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by don on 20/10/2016.
 */
public class ShoppingTest {

    @Test
    public void test_instance(){
        Shopping instance = new Shopping();
        Assert.assertNotNull(instance);
    }

    @Test
    public void test_Items(){
        Assert.assertTrue(Shopping.Item.values().length==2);
    }

    @Test
    public void test_Cart(){
        Shopping instance = new Shopping();
        Assert.assertNotNull(instance.getCart());
        Assert.assertTrue(instance.getCart().isEmpty());
    }

    @Test
    public void test_AddItems(){
        Shopping instance = new Shopping();
        Assert.assertTrue(instance.addItem(Shopping.Item.APPLE));
        Assert.assertTrue(instance.addItem(Shopping.Item.ORANGE));
        Assert.assertTrue(instance.getCart().size()==2);
        Assert.assertTrue(instance.addItem(Shopping.Item.APPLE));
        Assert.assertTrue(instance.addItem(Shopping.Item.ORANGE));
        Assert.assertTrue(instance.getCart().size()==4);
    }

    @Test
    public void test_getTotal(){
        Shopping instance = new Shopping();
        instance.addItem(Shopping.Item.APPLE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.APPLE);
        instance.addItem(Shopping.Item.APPLE);
        Assert.assertTrue(instance.calculateTotal()==2.05);
        }

        @Test
        public void test_GetQuantity(){
            Shopping instance = new Shopping();
            Assert.assertTrue(instance.getQuantity(Shopping.Item.APPLE)==0);
            Assert.assertTrue(instance.getQuantity(Shopping.Item.ORANGE)==0);
            Assert.assertTrue(instance.addItem(Shopping.Item.APPLE));
            Assert.assertTrue(instance.addItem(Shopping.Item.ORANGE));
            Assert.assertTrue(instance.getQuantity(Shopping.Item.APPLE)==1);
            Assert.assertTrue(instance.getQuantity(Shopping.Item.ORANGE)==1);
            Assert.assertTrue(instance.addItem(Shopping.Item.APPLE));
            Assert.assertTrue(instance.getQuantity(Shopping.Item.APPLE)==2);
            Assert.assertTrue(instance.getQuantity(Shopping.Item.ORANGE)==1);
        }

        @Test
        public void test_AppleOffer(){
            Shopping instance = new Shopping();
            instance.addItem(Shopping.Item.APPLE);
            instance.addItem(Shopping.Item.ORANGE);
            instance.addItem(Shopping.Item.APPLE);
            Assert.assertTrue(instance.calculateTotal()==1.45);
            Assert.assertTrue(instance.applyAppleOffer()==0.85);
        }

    @Test
    public void test_OrangeOffer1(){
        Shopping instance = new Shopping();
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        Assert.assertTrue(instance.calculateTotal()==0.75);
        Assert.assertTrue(instance.applyOrangeOffer()==0.50);
    }

    @Test
    public void test_OrangeOffer2(){
        Shopping instance = new Shopping();
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.ORANGE);
        Assert.assertTrue(instance.applyOrangeOffer()==1.0);
    }

    @Test
    public void test_AppleOrangeOffers(){
        Shopping instance = new Shopping();
        instance.addItem(Shopping.Item.APPLE);
        instance.addItem(Shopping.Item.ORANGE);
        instance.addItem(Shopping.Item.APPLE);
        instance.addItem(Shopping.Item.APPLE);
        instance.calculateTotal();
        instance.applyAppleOffer();
        instance.applyOrangeOffer();
        Assert.assertTrue(instance.getTotal()<1.46);
    }

    }



