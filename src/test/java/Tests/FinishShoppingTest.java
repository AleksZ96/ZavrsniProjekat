package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinishShoppingTest extends BaseTest {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        homePage.addAllItemsToCart();
        homePage.clickOnShoppingCartIcon();
    }
    @Test
    public void checkoutAndFinishShopping(){
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Milos");
        checkoutPage.inputLastName("Milosevic");
        checkoutPage.inputPostalCode("11000");
        checkoutPage.clickOnContinueButton();
        finishShoppingPage.clickOnFinishButton();
        Assert.assertTrue(finishedShoppingPage.checkoutCompleteMessage.isDisplayed());
        Assert.assertEquals(finishedShoppingPage.checkoutCompleteMessage.getText(), "Checkout: Complete!");
        Assert.assertTrue(finishedShoppingPage.orderDispatchedMessage.isDisplayed());
        Assert.assertTrue(finishedShoppingPage.backHomeButton.isDisplayed());
        finishedShoppingPage.clickOnBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
