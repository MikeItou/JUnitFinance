package test;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.RegisterPage;

@RunWith(JUnitParamsRunner.class)
public class RegisterSuite extends BaseTest {

    @Test
    @FileParameters("./data/HappyPathRegister.csv")
    public void happyPathRegister(String browser, String url, String firstName, String lastName, String username, String email, String password, String repeatPassword, String phone, String birthDate, String creditCard, String expirationDate, String cvv){
        setup(browser,url);
        login.validateLoginPage();
        login.clickRegisterLink();
        register.validateRegisterPage();
        register.fillRegisterFields(firstName,lastName,username,email,password,repeatPassword,phone,birthDate,creditCard,expirationDate,cvv);
    }

    @Test
    @FileParameters("./data/NoMatchPasswordRegister.csv")
    public void noMatchPasswordsRegister(String browser, String url, String firstName, String lastName, String username, String email, String password, String wrongRepeatPassword, String phone, String birthDate, String creditCard, String expirationDate, String cvv){
        setup(browser,url);
        login.validateLoginPage();
        login.clickRegisterLink();
        register.validateRegisterPage();
        register.fillRegisterFields(firstName,lastName,username,email,password,wrongRepeatPassword,phone,birthDate,creditCard,expirationDate,cvv);
        error.validateNoMatchPasswordImage();
    }
}
