package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorPage {

    WebDriver driver;
    WebDriverWait explicitWait;

    WebElement errorLoginImage;
    WebElement errorEmptyLoginImage;
    WebElement errorNoMatchPasswordImage;
    WebElement errorShortOfMoneyImage;
    WebElement errorSymbolImage;
    WebElement errorQuantityImage;
    WebElement errorCorrectSymbolImage;


    WebElement imageError;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver,5);
    }

    public void validateLoginErrorMessage() {
        try {
            errorLoginImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorLoginImage,"src", "invalid-username-and"));

            System.out.println("Incorrect Symbol error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Incorrect Symbol error message is not visualize");
        }
    }

    public void validateEmptyLoginErrorImage(){
        try{
            errorEmptyLoginImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorEmptyLoginImage,"src","must-provide-username"));

            System.out.println("Empty login error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Empty login error message is not visualize");
        }
    }
    public void validateNoMatchPasswordImage(){
        try{
            errorNoMatchPasswordImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorNoMatchPasswordImage,"src","Passwords-do-not-match"));
            System.out.println("No match Password error message is visualize");

        }catch (TimeoutException te){
            System.out.println("No match Password error message is not visualize");
        }
    }

    public void validateShortTransactionImageError(){
        try {
            errorShortOfMoneyImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorShortOfMoneyImage,"src","short-for-this-transaction"));

            System.out.println("Short for this transaction error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Short for this transaction error message is not visualize");
        }
    }

    public void validateSymbolImageError(){
        try {
            errorSymbolImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorSymbolImage,"src","You-must-enter-a-symbol"));

            System.out.println("Symbol error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Symbol error message is not visualize");
        }
    }

    public void validateCorectSymbolImageError(){
        try {
            errorCorrectSymbolImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorCorrectSymbolImage,"src", "is-not-valid"));

            System.out.println("Incorrect Symbol error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Incorrect Symbol error message is not visualize");
        }
    }

    public void validateQuantityImageError(){
        try {
            errorQuantityImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorQuantityImage,"src", "You-must-enter-a-number-greater-than-0"));

            System.out.println("Quantity error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Quantity error message is not visualize");
        }
    }
}
