package test;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BuySuite extends BaseTest {
    @Test
    @FileParameters("./data/BuyOneShare.csv")
    public void buyOneShare(String browser, String url, String username, String password, String symbol, String quantity, String symbolHistory, String quantityHistory){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
        home.clickBuyLink();
        buy.validateBuyPage();
        buy.fillBuyFields(symbol,quantity);
        home.validateHomePage();
        home.clickHistoryLink();
        history.validateHistoryPage();
        history.checkHistoryUpdate(symbolHistory,quantityHistory);
    }

    @Test
    @FileParameters("./data/BuyUserHasNoMoreMoney.csv")
    public void buyUserHasNoMoreMoney(String browser, String url, String username, String password, String symbol, String elevateQuantity){
        setup(browser,url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
        home.clickBuyLink();
        buy.validateBuyPage();
        buy.fillBuyFields(symbol,elevateQuantity);
        error.validateShortTransactionImageError();
    }

    @Test
    @FileParameters("./data/BuyWithoutSymbol.csv")
    public void buyWithoutSymbol(String browser, String url, String username, String password, String noSymbol, String quantity){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
        home.clickBuyLink();
        buy.validateBuyPage();
        buy.fillBuyFields(noSymbol,quantity);
        error.validateSymbolImageError();
    }

    @Test
    @FileParameters("./data/BuyWithWrongSymbol.csv")
    public void buyWithWrongSymbol(String browser, String url, String username, String password, String wrongSymbol, String quantity){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
        home.clickBuyLink();
        buy.validateBuyPage();
        buy.fillBuyFields(wrongSymbol,quantity);
        error.validateCorectSymbolImageError();
    }

    @Test
    @FileParameters("./data/BuyWithoutQuantity.csv")
    public void  buyWithoutQuantity(String browser, String url, String username, String password, String symbol, String noQuantity){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username, password);
        home.validateHomePage();
        home.clickBuyLink();
        buy.validateBuyPage();
        buy.fillBuyFields(symbol,noQuantity);
        error.validateQuantityImageError();
    }
}
