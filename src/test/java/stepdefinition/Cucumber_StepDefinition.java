package stepdefinition;

import Pages.Homepage;
import Utils.Utils;
import config.CoreConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utils.Utils;


import static Utils.Utils.driver;

public class Cucumber_StepDefinition {

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {

        driver.get(CoreConfig.baseURL);
        driver.manage().window().maximize();

    }

    @When("I add {string}, {string}, {string}, {string}, {string} to cart")
    public void i_add_to_cart(String item1, String item2, String item3, String item4, String item5) {
        driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]",item1))).click();
driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]",item2))).click();
    driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]",item3))).click();
    driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item4))).click();
    driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item5))).click();


    }

    @Then("cart should have {int} items")
    public void cart_should_have_items(int int1) {


    }

    @Then("total price should match calculated sum")
    public void total_price_should_match_calculated_sum() {

    }

    @When("I proceed to checkout and apply promo {string}")
    public void i_proceed_to_checkout_and_apply_promo(String string) {

    }

    @Then("discount should be applied and order placed successfully")
    public void discount_should_be_applied_and_order_placed_successfully() {

    }
}
