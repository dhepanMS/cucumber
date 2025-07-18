package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By product2 = By.id("add-to-cart-sauce-labs-bike-light");
    By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstTwoProductsToCart() {
        driver.findElement(product1).click();
        driver.findElement(product2).click();
    }

    public int getCartCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
