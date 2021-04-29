package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryPage {

    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement historyTable;
    WebElement symbolLastUpdateValue;
    WebElement quantityLastUpdateValue;

    public HistoryPage(WebDriver driver){
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver, 5);
    }

    public void validateHistoryPage(){
        try{
            historyTable = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));

            System.out.println("History elements are visualize correctly");

        }catch (TimeoutException te){
            System.out.println("History elements are not visualize correctly");
        }
    }

    public void checkHistoryUpdate(String symbol, String quantity){
        String tmpSymbol, tmpQuantity;

        try {
            symbolLastUpdateValue = driver.findElement(By.xpath("//tr[last()]/td[1]"));
            quantityLastUpdateValue = driver.findElement(By.xpath("//tr[last()]/td[2]"));

            tmpSymbol = symbolLastUpdateValue.getText();
            tmpQuantity = quantityLastUpdateValue.getText();

            if(symbol.equals(tmpSymbol) && quantity.equals(tmpQuantity)){
                System.out.println("The update was successfull");
            }
            else{
                System.out.println("The update was not successfull");
            }
            System.out.println("The elements you try to find are here");
        }catch (Exception e){
            System.out.println("The elements you try to find are missing");
        }
    }
}
