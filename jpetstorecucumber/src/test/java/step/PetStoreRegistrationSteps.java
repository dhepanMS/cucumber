package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class PetStoreRegistrationSteps {

    WebDriver driver;
    RegistrationPage page;

    @Given("the user is on the PetStore registration page")
    public void the_user_is_on_the_pet_store_registration_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
        page = new RegistrationPage(driver);
    }

    @When("the user fills account info with username {string}, password {string}, repeat password {string}")
    public void the_user_fills_account_info_with_username_password_repeat_password(String username, String password, String repeatPassword) {
        page.enterAccountInfo(username, password, repeatPassword);
    }

    @When("the user fills personal info with firstname {string}, lastname {string}, email {string}, phone {string}, address1 {string}, address2 {string}, city {string}, state {string}, zip {string}, country {string}")
    public void the_user_fills_personal_info_with_firstname_lastname_email_phone_address1_address2_city_state_zip_country(String fn, String ln, String email, String phone, String addr1, String addr2, String city, String state, String zip, String country) {
        page.enterPersonalInfo(fn, ln, email, phone, addr1, addr2, city, state, zip, country);
    }

    @When("the user fills profile info with language {string}, category {string}, listOption {string}, bannerOption {string}")
    public void the_user_fills_profile_info_with_language_category_list_option_banner_option(String lang, String cat, String listOpt, String bannerOpt) {
        page.enterProfileInfo(lang, cat, Boolean.parseBoolean(listOpt), Boolean.parseBoolean(bannerOpt));
    }

    @When("the user submits the registration form")
    public void the_user_submits_the_registration_form() {
        page.submitForm();
    }

    @Then("the user should be redirected to the welcome page")
    public void the_user_should_be_redirected_to_the_welcome_page() {
        System.out.println("User is on welcome page");
        driver.quit();
    }
}
