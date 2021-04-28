package test;

import junitparams.FileParameters;
import org.junit.Test;

public class RegisterSuite extends BaseTest {

    @Test
    @FileParameters("./data/HappyPathRegister.csv")
    public void happyPathRegister(String browser, String url, String firstName, String lastName, String username, String email, String password, String repeatPassword, String phone, String birthDate, String creditCard, String expirationDate, String cvv){
      accessPage(browser,url);
      validateLoginPage();
      clickRegisterLink();
      validateRegisterPage();
      fillRegisterFields(firstName,lastName,username,email,password,repeatPassword,phone,birthDate,creditCard,expirationDate,cvv);

    }

    @Test
    @FileParameters("./data/NoMatchPasswordRegister.csv")
    public void noMatchPasswordsRegister(String browser, String url, String firstName, String lastName, String username, String email, String password, String wrongRepeatPassword, String phone, String birthDate, String creditCard, String expirationDate, String cvv){
        accessPage(browser,url);
        validateLoginPage();
        clickRegisterLink();
        validateRegisterPage();
        fillRegisterFields(firstName,lastName,username,email,password,wrongRepeatPassword,phone,birthDate,creditCard,expirationDate,cvv);
        validateNoMatchPasswordImage();
    }
}
