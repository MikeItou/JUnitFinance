package test;

import org.junit.Test;

public class BuySuite extends BaseTest {
    @Test
    public void buyOneShare(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields("MX","5");
        validateMainPage();
        clickHistoryLink();
        validateHistoryPage();
        checkHistoryUpdate("MX","5");
    }

    @Test
    public void buyUserHasNoMoreMoney(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields("MX","9999");
        validateShortTransactionImageError();
    }

    @Test
    public void buyWithoutSymbol(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields("","9999");
        validateSymbolImageError();
    }

    @Test
    public void buyWithWrongSymbol(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields("XX","1");
        validateCorectSymbolImageError();
    }

    @Test
    public void  buyWithoutQuantity(){
        accessPage("chrome","http://vamonos-finance.herokuapp.com/login");
        validateLoginPage();
        fillLoginFields("Juanito.Banana","Testing1234");
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields("MX","");
        validateQuantityImageError();
    }
}
