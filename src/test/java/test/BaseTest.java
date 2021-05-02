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
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage home;
    protected LoginPage login;
    protected ErrorPage error;
    protected RegisterPage register;
    protected BuyPage buy;
    protected HistoryPage history;
    protected SellPage sell;

    /*@Before
    public void before(){
       driver = new ChromeDriver();
    }*/

    @After
    public void after(){
        //driver.quit();
    }

    protected void setup(String browser,String url) {
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
        login = new LoginPage(driver);
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        error = new ErrorPage(driver);
        buy = new BuyPage(driver);
        history = new HistoryPage(driver);
        sell = new SellPage(driver);
    }
}
