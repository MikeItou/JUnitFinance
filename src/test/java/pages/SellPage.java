package pages;

import okhttp3.internal.connection.RouteSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellPage {
    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement symbolField;
    Select symbolDropDownList;
    WebElement quantityField;
    WebElement sellButton;
    WebElement nothingToSellAlert;

    public SellPage(WebDriver driver){
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver, 5);
    }

    public void validateSellPage(){
        try {
            symbolField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='symbol']")));
            quantityField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='qty']")));
            sellButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));
            System.out.println("Sell elements are visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Sell elements are not visualize correctly");

        }
    }
    public void sellProduct(String symbol, String quantity){
        symbolDropDownList = new Select(driver.findElement(By.cssSelector("[name='symbol']")));
        symbolDropDownList.selectByVisibleText(symbol);
        quantityField.sendKeys(quantity);
        sellButton.click();
    }

    public void validNothingToSellLegend(){
        try{
            nothingToSellAlert = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container")));
            explicitWait.until(ExpectedConditions.textToBePresentInElement(nothingToSellAlert,"You have nothing to sell"));
            System.out.println("The legend 'You have nothing to Sell' in sell page is present.");
        }catch (TimeoutException te){
            System.out.println("The legend 'You have nothing to Sell' in sell page is not present.");
        }
    }
}
