package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait explicitWait;

    WebElement SellTable;//css="".table""
    WebElement quoteLink; // css = "[href='/quote']"
    WebElement buylink;// css = "[href='/buy']"
    WebElement sellLink;// css = "[href='/sell']"
    WebElement historyLink;// css = "[href='/history']"
    WebElement logoutLink;// css = "[href='/logout']"
    WebElement symbolTableValue;
    WebElement totalTableValue;

    public HomePage(WebDriver driver){
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver,5);
    }

    public void validateHomePage(){
        try{
            quoteLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/quote']")));
            buylink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/buy']")));
            sellLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/sell']")));
            historyLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/history']")));
            logoutLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/logout']")));
            SellTable = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));

            System.out.println("Home elements are visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Home elements are not visualize correctly");
        }
    }
    public void verifyNoSellsTable(){
        String tmpSymbol="CASH";
        String tmpTotal="10000.00";
        
        symbolTableValue = driver.findElement(By.xpath("//tr[contains(.,'CASH')]/td[1]"));
        totalTableValue = driver.findElement(By.xpath("//tr[contains(.,'CASH')]/td[5]"));

        if (tmpSymbol.equals(symbolTableValue.getText()) && tmpTotal.equals(totalTableValue.getText())){
            System.out.println("There are no sales made it by the user.");
        }
        else {
            System.out.println("The user has made a couple of sales.");
        }
    }
    public void clickBuyLink(){
        buylink.click();
    }
    public void clickHistoryLink(){
        historyLink.click();
    }
    public void clickSellLink() {
    sellLink.click();
    }
    public void clickLogoutLink(){
        logoutLink.click();
    }
    public void clickQuoteLink(){
        quoteLink.click();
    }
}
