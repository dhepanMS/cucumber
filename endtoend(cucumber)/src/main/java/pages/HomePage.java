package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By confirmationText = By.className("complete-header");
    By backBtn = By.id("back-to-products");
    By menuBtn = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationText).getText().contains("Thank you");
    }

    public void clickBackHome() {
        driver.findElement(backBtn).click();
    }

    public void logout() throws InterruptedException {
       
            Thread.sleep(1000); // wait for homepage to settle
        

        driver.findElement(menuBtn).click();

       
            Thread.sleep(1000); // wait for sidebar animation
       
        driver.findElement(logoutLink).click();
    }
}
