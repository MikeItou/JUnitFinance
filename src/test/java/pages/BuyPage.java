package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyPage {

    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement symbolField;
    WebElement quantityField;
    WebElement buyButton;


    public BuyPage(WebDriver driver){
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver, 5);
    }

    public void validateBuyPage(){
        try {
            symbolField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='symbol']")));
            quantityField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='qty']")));
            buyButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));

            System.out.println("Buy elements are visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Buy elements are not visualize correctly");
        }
    }

    public void fillBuyFields(String symbol, String quantity){
        symbolField.sendKeys(symbol);
        quantityField.sendKeys(quantity);
        buyButton.click();
    }
}
