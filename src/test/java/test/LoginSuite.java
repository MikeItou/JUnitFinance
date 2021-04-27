package test;

import org.junit.Test;

public class LoginSuite extends BaseTest{
    @Test
    public void happyPathLogin(){
        accessPage("http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
    }

    @Test
    public void invalidLogin(){
        accessPage("http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana2","Testing1234");
        validateLoginErrorImage();
    }

    @Test
    public void emptyFieldLogin(){
        accessPage("http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("","");
        validateEmptyLoginErrorImage();
    }
}
