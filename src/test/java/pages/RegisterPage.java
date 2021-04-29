package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait explicitWait;
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement usernameRegisterField;
    WebElement emailField;
    WebElement passwordRegisterField;
    WebElement repeatPasswordField;
    WebElement phoneNumberField;
    WebElement birthDateField;
    WebElement credtitCardField;
    WebElement expDateCCField;
    WebElement cvvField;
    WebElement registerButton;


    public RegisterPage(WebDriver driver){
        this.driver = driver;
        explicitWait = new WebDriverWait(this.driver, 5);
    }

    public void validateRegisterPage(){
        try {
            firstNameField = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='first_name']")));
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

    public void fillRegisterFields(String firstName, String lastName, String username, String email, String password, String repeatPassword, String phone, String birthdate, String creditCard, String expirationDate, String cvv){
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

}
