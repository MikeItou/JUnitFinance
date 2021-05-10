package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement registerLink; //css=""[href='/register']""
    WebElement loginLink; //css=""[href=""/login""]""
    WebElement usernameField; // css = [name = ""username""]
    WebElement passwordField; // css = [name=""password""]
    WebElement loginButton; // css =.btn"

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver, 5);
    }

    //Uso posible a futuro sino debe borrarse
    public void setupWebPage(String browser, String url){
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

    public void validateLoginPage() {
        try {
            usernameField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
            passwordField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
            loginButton = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));
            registerLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/register']")));
            loginLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/login']")));

            System.out.println("Login elements visualize correctly");
        }catch (TimeoutException te){
            System.out.println("Login elements not visualize correctly");
        }
    }

    public void fillLoginFields(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickRegisterLink() {

        registerLink.click();
    }
    public void clickLoinLink(){
        loginLink.click();
    }
}