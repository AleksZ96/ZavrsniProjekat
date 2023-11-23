package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtoCartAndRemoveFromCartTest extends BaseTest {


    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test (priority = 10)
    public void addItemsToCart(){
        homePage.addAllItemsToCart();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)", "");
        int numberOfItemsInCart = Integer.parseInt(homePage.shoppingCartBadge.getText());
        Assert.assertEquals(homePage.listOfRemoveButtons.size(), numberOfItemsInCart);
    }

    @Test(priority = 20)
    public void removeItemsFromCart(){
        homePage.addAllItemsToCart();
        homePage.removeAllItemsFromCart();
        Assert.assertEquals(homePage.listOfRemoveButtons.size(), 0);
    }

    @Test(priority = 30)
    public void addItemToCartFromItemPage(){
        for (WebElement item : homePage.itemNames){
            if(item.getText().equals("Sauce Labs Backpack")){
                item.click();
                itemPage.clickOnAddToCartButton();
                driver.navigate().back();
                break;
            }
        }
        int numberOfItemsInCart = Integer.parseInt(homePage.shoppingCartBadge.getText());
        Assert.assertEquals(homePage.listOfRemoveButtons.size(), numberOfItemsInCart);
    }

    @Test(priority = 40)
    public void removeItemFromCartFromItemPage(){
        homePage.addAllItemsToCart();
        for (WebElement item : homePage.itemNames){
            if(item.getText().equals("Sauce Labs Backpack")){
                item.click();
                itemPage.clickOnRemoveFromCartButton();
                driver.navigate().back();
                break;
            }
        }
        int numberOfItemsInCart = Integer.parseInt(homePage.shoppingCartBadge.getText());
        Assert.assertEquals(homePage.listOfRemoveButtons.size(), numberOfItemsInCart);
    }





}
