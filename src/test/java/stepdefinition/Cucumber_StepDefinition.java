package stepdefinition;

import Pages.Homepage;
import Utils.Utils;
import config.CoreConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Utils.Utils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

//import static Utils.Utils.wait;
import static Utils.Utils.driver;
import static Utils.Utils.wait;

public class Cucumber_StepDefinition {

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {

        driver.get(CoreConfig.baseURL);
        driver.manage().window().maximize();

    }

    @When("I add {string}, {string}, {string}, {string}, {string} to cart")
    public void i_add_to_cart(String item1, String item2, String item3, String item4, String item5) {
        driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item1))).click();
        WebElement element1 = driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item2)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

        element1.click();
        WebElement element2 = driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item3)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);

        element2.click();
        WebElement element3 = driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item4)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
        element3.click();
        WebElement element4 = driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]//ancestor::div[@class='product']//button[contains(text(),'ADD TO CART')]", item5)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);

        element4.click();


    }

    @Then("cart should have {string} items")
    public void cart_should_have_items(String itemCount) {
        String items = driver.findElement(By.xpath(String.format("//span[@class='cart-count']"))).getText();

        Assert.assertEquals(items, itemCount, "Count match");
    }

    @Then("total price should match calculated sum")
    public void total_price_should_match_calculated_sum() {
int Totalprice=Integer.parseInt(driver.findElement(By.xpath("//div[@class='cart-info']//td[contains(text(),'Price')]//ancestor::tr//strong")).getText());
driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

int item1=Integer.parseInt(driver.findElement(By.xpath("(//p[@class='amount'])[1]")).getText());
int item2=Integer.parseInt(driver.findElement(By.xpath("(//p[@class='amount'])[2]")).getText());
int item3=Integer.parseInt(driver.findElement(By.xpath("(//p[@class='amount'])[3]")).getText());
int item4=Integer.parseInt(driver.findElement(By.xpath("(//p[@class='amount'])[4]")).getText());
int item5=Integer.parseInt(driver.findElement(By.xpath("(//p[@class='amount'])[5]")).getText());
int actualPrice = item1+item2+item3+item4+item5;
if (Totalprice==actualPrice)
{Assert.assertTrue();}
else Assert.assertFalse();

    }

    @When("I proceed to checkout and apply promo {string}")
    public void i_proceed_to_checkout_and_apply_promo(String string) {
driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
driver.findElement(By.xpath("//button[@class='promoBtn']")).click();


    }

    @Then("discount should be applied and order placed successfully")
    public void discount_should_be_applied_and_order_placed_successfully() {
        String disc=driver.findElement(By.xpath("//span[@class='discountPerc']")).getText();
        Assert.assertEquals(disc, "10%", "Discount should be 10%");

    }
}
