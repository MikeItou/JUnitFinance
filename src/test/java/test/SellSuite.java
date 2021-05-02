package test;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SellSuite extends BaseTest{

    @Test
    @FileParameters("./data/NormalSell.csv")
    public void normalSell(String browser, String url, String username, String password, String symbol, String quantity, String symbolHistory, String quantityHistory){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username,password);
        home.validateHomePage();
        home.clickSellLink();
        sell.validateSellPage();
        sell.sellProduct(symbol,quantity);
        home.validateHomePage();
        home.clickHistoryLink();
        history.checkHistoryUpdate(symbolHistory,quantityHistory);

    }

    @Test
    @FileParameters("./data/NothingToSell.csv")

    public void nothingToSell(String browser,String url,String username, String password){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username,password);
        home.validateHomePage();
        home.clickSellLink();
        sell.validNothingToSellLegend();
    }

    @Test
    @FileParameters("./data/OverSell.csv")
    public void overSell(String browser, String url, String username, String password, String symbol, String quantity){
        setup(browser, url);
        login.validateLoginPage();
        login.fillLoginFields(username,password);
        home.validateHomePage();
        home.clickSellLink();
        sell.validateSellPage();
        sell.sellProduct(symbol,quantity);
        error.validOverSellQuantityImageError();
    }
}
