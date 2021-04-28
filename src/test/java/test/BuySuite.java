package test;

import junitparams.FileParameters;
import org.junit.Test;

public class BuySuite extends BaseTest {
    @Test
    @FileParameters("./data/BuyOneShare.csv")
    public void buyOneShare(String browser, String url, String username, String password, String symbol, String quantity, String symbolHistory, String quantityHistory){
        accessPage(browser, url);
        validateLoginPage();
        fillLoginFields(username, password);
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields(symbol,quantity);
        validateMainPage();
        clickHistoryLink();
        validateHistoryPage();
        checkHistoryUpdate(symbolHistory,quantityHistory);
    }

    @Test
    @FileParameters("./data/BuyUserHasNoMoreMoney.csv")
    public void buyUserHasNoMoreMoney(String browser, String url, String username, String password, String symbol, String elevateQuantity){
        accessPage(browser,url);
        validateLoginPage();
        fillLoginFields(username,password);
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields(symbol,elevateQuantity);
        validateShortTransactionImageError();
    }

    @Test
    @FileParameters("./data/BuyWithoutSymbol.csv")
    public void buyWithoutSymbol(String browser, String url, String username, String password, String noSymbol, String quantity){
        accessPage(browser, url);
        validateLoginPage();
        fillLoginFields(username,password);
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields(noSymbol,quantity);
        validateSymbolImageError();
    }

    @Test
    @FileParameters("./data/BuyWithWrongSymbol.csv")
    public void buyWithWrongSymbol(String browser, String url, String username, String password, String wrongSymbol, String quantity){
        accessPage(browser, url);
        validateLoginPage();
        fillLoginFields(username,password);
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields(wrongSymbol,quantity);
        validateCorectSymbolImageError();
    }

    @Test
    @FileParameters("./data/BuyWithoutQuantity.csv")
    public void  buyWithoutQuantity(String browser, String url, String username, String password, String symbol, String noQuantity){
        accessPage(browser, url);
        validateLoginPage();
        fillLoginFields(username,password);
        validateMainPage();
        clickBuyLink();
        validateBuyPage();
        fillBuyFields(symbol,noQuantity);
        validateQuantityImageError();
    }
}
