package StepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.AdidasUI;
import utilities.base;

import java.util.concurrent.TimeUnit;


public class Adidas extends base {
    public WebDriver driver;
    String amount;
    String[] str1;
    AdidasUI adidasUI;

    private static final Logger LOGGER = LoggerFactory.getLogger(Adidas.class);

    @Test
    @Given("^User hit the Web FE URL$")
    public void user_hit_the_Web_Fe_URL() {


        driver = base.driver;
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("^User navigation through product categories: Phones, Laptops and Monitors and select Sony Laptop and Accept Pop up Confirmation$")
    public void user_navigation_through_product_categories_Phones_laptop_monitors() {

        adidasUI = new AdidasUI(driver);
        adidasUI.listCategory().click();
        adidasUI.sonyLaptop().click();
        adidasUI.addToCart().click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

    @Then("^User Navigate to Laptop then Dell i7 8gb and click on Add to cart. Accept pop up confirmation$")
    public void user_navigate_to_laptop_then_Dell_i7_and_click_on_Add_to_cart_Accept_pop_up() {

        driver = base.driver;
        driver.navigate().to("https://www.demoblaze.com/index.html#");
        adidasUI.listGroupCategory().click();
        adidasUI.dellLaptop().click();
        adidasUI.addToCart().click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Then("^Navigate to Cart and Delete Dell i7 8gb from cart.$")
    public void navigate_to_cart_and_delete_Dell_i7_from_cart() {

        adidasUI.cartButton().click();
        adidasUI.deleteLaptop().click();
        amount= adidasUI.laptopAmount().getText();

    }

    @Then("^Click on Place order.$")
    public void click_on_place_order() throws Exception {
        Thread.sleep(3000);
        adidasUI.placeOder().click();

    }


    @Then("^Fill in all web form fields and click on purchase$")
    public void fill_in_all_web_forms_details() throws Exception {

        driver.switchTo().activeElement();
        adidasUI.Name().sendKeys("Ankita");
        adidasUI.Country().sendKeys("India");
        adidasUI.City().sendKeys("Gurgoan");
        adidasUI.Card().sendKeys("123456777");
        adidasUI.Month().sendKeys("October");
        adidasUI.Year().sendKeys("2020");
        adidasUI.Purchase().click();


    }

    @Then("^Capture and log purchase Id and Amount.$")
    public void capture_and_log_purchase() {

        String str = adidasUI.captureIdandAmount().getText();
        str1 = str.split("\n");
        LOGGER.info(str1[0]);
        LOGGER.info(str1[1]);
    }

    @Then("^Assert purchase amount equals expected.$")
    public void assert_purchase_amount_equals() {
        Assert.assertTrue(str1[1].contains(amount));
    }

    @Then("^Click on OK.$")
    public void click_on_Ok() {

        adidasUI.Ok().click();
    }


}
