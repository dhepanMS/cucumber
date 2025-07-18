package stepdefinition;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class SauceSteps {

	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	HomePage homePage;

	@Given("the user is on the SauceDemo login page")
	public void the_user_is_on_the_sauce_demo_login_page() {
		loginPage = new LoginPage(BaseClass.driver);
	}

	@When("the user logs in with username {string} and password {string}")
	public void the_user_logs_in_with_username_and_password(String username, String password) {
		loginPage.login(username, password);

		try {
			WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));
			WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
			okBtn.click();
		} catch (Exception e) {
			System.out.println("No popup found, continuing...");
		}
	}

	@When("the user adds two products to the cart")
	public void the_user_adds_two_products_to_the_cart() {
		productsPage = new ProductsPage(BaseClass.driver);
		productsPage.addFirstTwoProductsToCart();
	}

	@When("the user clicks the cart and proceeds to checkout")
	public void the_user_clicks_cart_and_proceeds_to_checkout() {
		cartPage = new CartPage(BaseClass.driver);
		cartPage.clickCartAndCheckout();
	}

	@When("the user fills first name {string}, last name {string} and postal code {string}")
	public void the_user_fills_personal_details(String fname, String lname, String zip) {
		checkoutPage = new CheckoutPage(BaseClass.driver);
		checkoutPage.enterDetails(fname, lname, zip);
	}

	@When("the user continues and finishes the order")
	public void the_user_continues_and_finishes_the_order() {
		checkoutPage.clickContinueAndFinish();
	}

	@Then("the user should return to the homepage and logout")
	public void the_user_should_return_to_homepage_and_logout() throws InterruptedException {
		homePage = new HomePage(BaseClass.driver);
		Assert.assertTrue("Confirmation not found", homePage.isOrderConfirmed());
		homePage.clickBackHome();

		Thread.sleep(1000);

		homePage.logout(); // perform menu → logout
	}
}
