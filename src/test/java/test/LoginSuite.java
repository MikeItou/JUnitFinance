package test;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginSuite extends BaseTest{
    @Test
    @FileParameters("./data/HappyLogin.csv")
    public void happyPathLogin(String browser, String url, String username, String password){
        accessPage(browser, url);
        validateLoginPage();
        fillLoginFields(username,password);
    }

    @Test
    @FileParameters("./data/InvalidLogin.csv")
    public void invalidLogin(String browser, String url, String invalidUser, String invalidPassword){
        accessPage(browser,url);
        validateLoginPage();
        fillLoginFields(invalidUser, invalidPassword);
        validateLoginErrorImage();
    }

    @Test
    public void emptyFieldLogin(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("","");
        validateEmptyLoginErrorImage();
    }
}
