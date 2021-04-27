package test;

import org.junit.Test;

public class RegisterSuite extends BaseTest {

    @Test
    public void happyPathRegister(){
      accessPage("http://vamonos-finance.herokuapp.com/login");
      validateLoginPage();
      clickRegisterLink();
      validateRegisterPage();
      fillRegisterFields("Miguel","Angel","Juanito.Banana","juanito.banana93@gmail.com","Testing1234","Testing1234","5576319288","27061993","1234567887654321","12/40","555");
    }

    @Test
    public void noMatchPasswordsRegister(){
        accessPage("http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        clickRegisterLink();
        validateRegisterPage();
        fillRegisterFields("Miguel","Angel","Juanito.Banana","juanito.banana93@gmail.com","Testing9999","Testing1234","5576319288","27061993","1234567887654321","12/40","555");
        validateNoMatchPasswordImage();
    }
}
