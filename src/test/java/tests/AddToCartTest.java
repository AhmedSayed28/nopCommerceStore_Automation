package tests;

import Component.AddToCart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    AddToCart cart;

    @Test
    public void testCart() throws InterruptedException {
        cart = new AddToCart(driver);
        cart.addProductsToCart();
        cart.updateQty(3);
        cart.updateQty(2);
        cart.printProductTotalPrice();
        System.out.println("Total Cart Price: " + cart.calcTotalPrice());
        System.out.println("Dom Total Price: " + cart.getTotalPrice());
        Assert.assertEquals(cart.calcTotalPrice(), cart.getTotalPrice(),"Total Cart Price: " + cart.calcTotalPrice() + "Calculated Successfully " );
    }
}
