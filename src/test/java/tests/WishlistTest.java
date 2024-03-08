package tests;

import Component.Wishlist;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest{
    Wishlist wishlist;

    @Test
    public void testWishlist() throws InterruptedException {
        wishlist = new Wishlist(driver);
        wishlist.addRandomProducts();
        wishlist.goToWishlist();
        wishlist.compareWishlistProducts();
    }
}
