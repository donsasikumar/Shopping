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
        Assert.assertTrue(instance.addItemTo(Shopping.Item.APPLE));
        Assert.assertTrue(instance.addItemTo(Shopping.Item.ORANGE));
        Assert.assertTrue(instance.getCart().size()==2);
        Assert.assertTrue(instance.addItemTo(Shopping.Item.APPLE));
        Assert.assertTrue(instance.addItemTo(Shopping.Item.ORANGE));
        Assert.assertTrue(instance.getCart().size()==4);
    }

    @Test
    public void test_getTotal(){
        Shopping instance = new Shopping();
        instance.addItemTo(Shopping.Item.APPLE);
        instance.addItemTo(Shopping.Item.ORANGE);
        instance.addItemTo(Shopping.Item.APPLE);
        instance.addItemTo(Shopping.Item.APPLE);
        Assert.assertTrue(instance.getTotal()==2.05);
        }

    }



