package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import pages.LoginPage;
import pages.ProductsPage;
import shared.BaseTest;

public class ProductsAddToCartTest extends BaseTest {
    private ProductsPage productsPage;

    @BeforeEach
    public void setupProducts() {
        productsPage = new LoginPage(driver).successfullyLogin();
    }

    @Test 
    public void addingProductToCartShowsCartBadgeWithCorrectNumber(){
        productsPage.addBackPackToCart();
        assertEquals(1, productsPage.getCartBadgeCount());
    }

    // My Test attempt
    // add one then delete one and make sure the badge disappeared
//    @Test 
//     public void addingProductToCartThenRemovingShowsBadgeWithNoNumber(){
//         productsPage.addBackPackToCart();
//         productsPage.removeBackPackFromCart();
//         assertEquals(0, productsPage.getCartBadgeCount());
//     }
    //Martyna's version
    @Test 
    public void addingAndRemovingProductShowsAndHidesBadge(){
        productsPage.addBackPackToCart();
        assertTrue(productsPage.isBadgeVisible());
        productsPage.removeBackPackFromCart();
        assertFalse(productsPage.isBadgeVisible());
    }

    @Test 
    public void addingMultipleProductsToCartShowsCartBadgeWithCorrectNumber(){
        List<WebElement> allProductCards = productsPage.getAllProductCards();
        productsPage.addToCart(allProductCards.get(0));
        productsPage.addToCart(allProductCards.get(1));
        productsPage.addToCart(allProductCards.get(2));
        assertEquals(3, productsPage.getCartBadgeCount());
    }

    // My Test attempt
    //add and remove but not all
    //     @Test 
    // public void addingMultipleProductsToCartThenRemovingOneShowsCartBadgeWithCorrectNumber(){
    //     List<WebElement> allProductCards = productsPage.getAllProductCards();
    //     productsPage.addToCart(allProductCards.get(0));
    //     productsPage.addToCart(allProductCards.get(1));
    //     productsPage.addToCart(allProductCards.get(2));
    //     productsPage.removeFromCart(allProductCards.get(0));
    //     assertEquals(2, productsPage.getCartBadgeCount());
    // }

    // My Test attempt
    //add and remove all - make sure the badge is gone
    //      @Test 
    // public void addingMultipleProductsToCartThenRemovingAllShowsCartBadgeWithNoNumber(){
    //     List<WebElement> allProductCards = productsPage.getAllProductCards();
    //     productsPage.addToCart(allProductCards.get(0));
    //     productsPage.addToCart(allProductCards.get(1));
    //     productsPage.addToCart(allProductCards.get(2));
    //     productsPage.removeFromCart(allProductCards.get(0));
    //     productsPage.removeFromCart(allProductCards.get(1));
    //     productsPage.removeFromCart(allProductCards.get(2));
    //     assertEquals(0, productsPage.getCartBadgeCount());
    //}
}
