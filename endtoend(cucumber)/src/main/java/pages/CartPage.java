package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage {
    WebDriver driver;
    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCartAndCheckout() {
        driver.findElement(cartIcon).click();
        try {
            Thread.sleep(1000); // wait 1 second before clicking Checkout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(checkoutBtn).click();
    }
}