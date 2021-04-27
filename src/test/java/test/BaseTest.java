package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected WebElement usernameField;
    protected WebElement passwordField;
    protected WebElement loginButton;
    protected WebElement registerLink;
    protected WebElement loginLink;
    protected WebElement firstNameField;
    protected WebElement lastNameField;
    protected WebElement usernameRegisterField;
    protected WebElement emailField;
    protected WebElement passwordRegisterField;
    protected WebElement repeatPasswordField;
    protected WebElement phoneNumberField;
    protected WebElement birthDateField;
    protected WebElement credtitCardField;
    protected WebElement expDateCCField;
    protected WebElement cvvField;
    protected WebElement registerButton;
    protected WebElement errorLoginImage;
    protected WebElement errorEmptyLoginImage;
    protected WebElement errorNoMatchPasswordImage;
    protected WebElement quoteLink;
    protected WebElement buylink;
    protected WebElement sellLink;
    protected WebElement historyLink;
    protected WebElement logoutLink;
    protected WebElement cashSymbolValueTable;
    protected WebElement symbolField;
    protected WebElement quantityField;
    protected WebElement buyButton;
    protected WebElement symbolLastUpdateValue;
    protected WebElement quantityLastUpdateValue;
    protected WebElement historyTable;
    protected WebElement errorShortOfMoneyImage;
    protected WebElement errorSymbolImage;
    protected WebElement errorQuantityImage;
    protected WebElement errorCorrectSymbolImage;


    //@Before
    //public void before(){
     //  driver = new ChromeDriver();
    //}

    @After
    public void after(){
        driver.quit();
    }

    protected void accessPage(String browser,String url) {
        switch (browser){
            case"chrome":
                driver = new ChromeDriver();
                break;
            case"firefox":
                driver = new FirefoxDriver();
                break;
            case"safari":
                driver = new SafariDriver();
                break;
            case"opera":
                driver = new OperaDriver();
                break;
            case"edge":
                driver = new EdgeDriver();
                break;
        }
        driver.get(url);
    }

    protected void validateRegisterPage() {
        try {
            firstNameField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='first_name']")));
            explicitWait.until(ExpectedConditions.attributeContains(firstNameField,"placeholder","First Name"));
            lastNameField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='last_name']")));
            usernameRegisterField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
            emailField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='email']")));
            passwordRegisterField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
            repeatPasswordField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='repeat_password']")));
            phoneNumberField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='phone']")));
            birthDateField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='birthdate']")));
            credtitCardField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cc']")));
            expDateCCField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='expiration']")));
            cvvField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cvv']")));
            registerButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));

            System.out.println("Register elements visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Register elements not visualize correctly");
        }
    }

    protected void fillRegisterFields(String firstName, String lastName, String username, String email, String password, String repeatPassword, String phone, String birthdate, String creditCard, String expirationDate, String cvv) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        usernameRegisterField.sendKeys(username);
        emailField.sendKeys(email);
        passwordRegisterField.sendKeys(password);
        repeatPasswordField.sendKeys(repeatPassword);
        phoneNumberField.sendKeys(phone);
        birthDateField.sendKeys(birthdate);
        credtitCardField.sendKeys(creditCard);
        expDateCCField.sendKeys(expirationDate);
        cvvField.sendKeys(cvv);
        registerButton.click();
    }

    protected void validateLoginPage() {
        explicitWait = new WebDriverWait(driver,5);

        try {
            usernameField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
            explicitWait.until(ExpectedConditions.attributeContains(usernameField,"placeholder","Username"));
            passwordField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
            loginButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));
            registerLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/register']")));
            loginLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/login']")));

            System.out.println("Login elements visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Login elements not visualize correctly");
        }
    }

    protected void clickRegisterLink() {
        registerLink.click();
    }

    protected void fillLoginFields(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    protected void validateLoginErrorImage() {
        try{
            errorLoginImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorLoginImage,"src","invalid-username"));

            System.out.println("Login error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Login error message is not visualize");
        }
    }

    protected void validateEmptyLoginErrorImage() {
        try{
            errorEmptyLoginImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorEmptyLoginImage,"src","must-provide-username"));

            System.out.println("Empty login error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Empty login error message is not visualize");
        }
    }

    protected void validateNoMatchPasswordImage() {
        try{
            errorNoMatchPasswordImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorNoMatchPasswordImage,"src","Passwords-do-not-match"));
            System.out.println("No match Password error message is visualize");

        }catch (TimeoutException te){
            System.out.println("No match Password error message is not visualize");
        }
    }

    protected void clickBuyLink() {
        buylink.click();
    }

    protected void validateBuyPage() {
        try {
            symbolField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='symbol']")));
            explicitWait.until(ExpectedConditions.attributeContains(symbolField,"placeholder","Symbol"));
            quantityField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='qty']")));
            buyButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));

            System.out.println("Buy elements are visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Buy elements are not visualize correctly");
        }
    }

    protected void fillBuyFields(String symbol, String quantity) {
        symbolField.sendKeys(symbol);
        quantityField.sendKeys(quantity);
        buyButton.click();
    }

    protected void validateMainPage() {
        try{
            quoteLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/quote']")));
            explicitWait.until(ExpectedConditions.attributeContains(quoteLink,"href","quote"));
            buylink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/buy']")));
            sellLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/sell']")));
            historyLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/history']")));
            logoutLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/logout']")));
            cashSymbolValueTable = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(.,'CASH')]")));

            System.out.println("Main elements are visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Main elements are not visualize correctly");
        }
    }

    protected void clickHistoryLink() {
        historyLink.click();
    }

    protected void validateHistoryPage() {
        try{
            historyTable = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));
            //explicitWait.until(ExpectedConditions.attributeContains(historyTable,"th","Symbol"));

            System.out.println("History elements are visualize correctly");

        }catch (TimeoutException te){
            System.out.println("History elements are not visualize correctly");

        }
    }

    protected void checkHistoryUpdate(String symbol, String quantity) {
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

    protected void validateShortTransactionImageError() {
        try {
            errorShortOfMoneyImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorShortOfMoneyImage,"src","short-for-this-transaction"));

            System.out.println("Short for this transaction error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Short for this transaction error message is not visualize");
        }
    }

    protected void validateSymbolImageError() {
        try {
            errorSymbolImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorSymbolImage,"src","You-must-enter-a-symbol"));

            System.out.println("Symbol error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Symbol error message is not visualize");
        }
    }

    protected void validateQuantityImageError() {
        try {
            errorQuantityImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorQuantityImage,"src", "You-must-enter-a-number-greater-than-0"));

            System.out.println("Quantity error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Quantity error message is not visualize");
        }
    }

    protected void validateCorectSymbolImageError(){
        try {
            errorCorrectSymbolImage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(errorCorrectSymbolImage,"src", "is-not-valid"));

            System.out.println("Incorrect Symbol error message is visualize");
        }catch (TimeoutException te){
            System.out.println("Incorrect Symbol error message is not visualize");
        }
    }
}
