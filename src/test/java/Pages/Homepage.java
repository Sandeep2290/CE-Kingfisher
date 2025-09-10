package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Utils.driver;

public class Homepage {

    public WebElement productName(String prodname)
    {
        WebElement prod=driver.findElement(By.xpath(String.format("//h4[contains(text(),'%s')]",prodname)));
        return prod;

    }
}
