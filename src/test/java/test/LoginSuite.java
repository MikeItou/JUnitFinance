package test;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.HomePage;
import pages.LoginPage;

@RunWith(JUnitParamsRunner.class)
public class LoginSuite extends BaseTest{
    @Test
    @FileParameters("./data/HappyLogin.csv")
    public void happyPathLogin(String browser, String url, String username, String password){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
    }

    @Test
    @FileParameters("./data/InvalidLogin.csv")
    public void invalidLogin(String browser, String url, String invalidUser, String invalidPassword){
        setup(browser,url);
        login.validateLoginPage();
        login.fillLoginFields(invalidUser, invalidPassword);
        error.validateLoginErrorMessage();
    }

    @Test
    @FileParameters("./data/EmptyFieldLogin.csv")
    public void emptyFieldLogin(String browser, String url, String emptyUsername, String emptyPassword){
        setup(browser,url);
        login.validateLoginPage();
        login.fillLoginFields(emptyUsername,emptyPassword);
        error.validateEmptyLoginErrorImage();
    }
}
