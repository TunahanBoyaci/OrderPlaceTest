package Day13;

import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest01 extends ParameterDriver {
    @Test
    @Parameters({"keyword"})
    public void test1(String keyword){
        login();

        WebElement searchInbox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchInbox.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        WebElement addButton = driver.findElement(By.xpath("(//div[@class=\"button-group\"]//button)[1]"));
        addButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        cartButton.click();

        WebElement checkButton = driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkButton.click();

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();

        WebElement conButton2 = driver.findElement(By.cssSelector("input[value=\"Continue\"][id=\"button-shipping-address\"]"));
        conButton2.click();

        WebElement conButton3 = driver.findElement(By.cssSelector("input[value=\"Continue\"][id=\"button-shipping-method\"]"));
        conButton3.click();

        WebElement conButton4 = driver.findElement(By.cssSelector("input[value=\"1\"]"));
        conButton4.click();

        WebElement conButton5 = driver.findElement(By.cssSelector("input[value=\"Continue\"][id=\"button-payment-method\"]"));
        conButton5.click();

        WebElement conButton6 = driver.findElement(By.cssSelector("input[id=\"button-confirm\"]"));
        conButton6.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='content']//p)[1]")));
        WebElement successMessage = driver.findElement(By.xpath("(//div[@id='content']//p)[1]"));
        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }
}
