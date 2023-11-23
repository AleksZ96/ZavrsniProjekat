package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class PutInOrderTest extends BaseTest {


    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }
    @Test
    public void putInZAOrder(){
        ArrayList<String> reversedList = homePage.getReverseList(homePage.getItemNames());
        homePage.clickOnOptionZToAFromDropdown();
        Assert.assertEquals(homePage.getItemNames(), reversedList);

    }

    @Test
    public void putInAZOrder(){
        ArrayList<String> listInOrder = homePage.getSortedList(homePage.getItemNames());
        homePage.clickOnOptionAToZFromDropdown();
        Assert.assertEquals(homePage.getItemNames(), listInOrder);
    }

    @Test
    public void putInLoHiOrder(){
        ArrayList<Double> listInOrder = homePage.getSortedPriceList(homePage.getItemPrices());
        homePage.clickOnOptionLoHiFromDropdown();
        Assert.assertEquals(homePage.getItemPrices(), listInOrder);
    }
    @Test
    public void putInHiLoOrder(){
        ArrayList<Double> listInRevrseOrder = homePage.getReversePriceList(homePage.getItemPrices());
        homePage.clickOnOptionHiLoFromDropdown();
        Assert.assertEquals(homePage.getItemPrices(), listInRevrseOrder);
    }

}
