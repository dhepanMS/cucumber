package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAccountInfo(String username, String password, String repeatPassword) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("repeatedPassword")).sendKeys(repeatPassword);
    }

    public void enterPersonalInfo(String fn, String ln, String email, String phone, String addr1, String addr2, String city, String state, String zip, String country) {
        driver.findElement(By.name("account.firstName")).sendKeys(fn);
        driver.findElement(By.name("account.lastName")).sendKeys(ln);
        driver.findElement(By.name("account.email")).sendKeys(email);
        driver.findElement(By.name("account.phone")).sendKeys(phone);
        driver.findElement(By.name("account.address1")).sendKeys(addr1);
        driver.findElement(By.name("account.address2")).sendKeys(addr2);
        driver.findElement(By.name("account.city")).sendKeys(city);
        driver.findElement(By.name("account.state")).sendKeys(state);
        driver.findElement(By.name("account.zip")).sendKeys(zip);
        driver.findElement(By.name("account.country")).sendKeys(country);
    }

    public void enterProfileInfo(String lang, String cat, boolean listOpt, boolean bannerOpt) {
        driver.findElement(By.name("account.languagePreference")).sendKeys(lang);
        driver.findElement(By.name("account.favouriteCategoryId")).sendKeys(cat);
        if (listOpt) driver.findElement(By.name("account.listOption")).click();
        if (bannerOpt) driver.findElement(By.name("account.bannerOption")).click();
    }

    public void submitForm() {
        driver.findElement(By.name("newAccount")).click();
    }
}
