package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLoginWithValidUsernameAndValidPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            loginPage.enterUsername(validUsername);
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(homePage.shoppingCartIcon.isDisplayed());
            Assert.assertTrue(burgerMenuPage.burgerMenuButton.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            driver.navigate().back();
        }
    }
    @Test
    public void LockedOutUserCantLoginWithValidUsernameAndValidPassword(){
            String lockedOutUsername = excelReader.getStringData("Login1", 1, 0);
            String lockedOutPassword = excelReader.getStringData("Login1", 1, 1);
            loginPage.enterUsername(lockedOutUsername);
            loginPage.enterPassword(lockedOutPassword);
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage.getText(),"Epic sadface: Sorry, this user has been locked out.");
            Assert.assertTrue(loginPage.loginButton.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @Test
    public void userCantLoginWithEmptyUsernameAndEmptyPassword(){
        loginPage.userNameBox.clear();
        loginPage.passwordBox.clear();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals("Epic sadface: Username is required", loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void userCantLoginWithValidUsernameAndInvalidPassword(){
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            loginPage.enterUsername(validUsername);
            loginPage.enterPassword("invalidPassword");
            loginPage.clickOnLoginButton();
            Assert.assertTrue(loginPage.loginButton.isDisplayed());
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        }
    }
    @Test
    public void userCantLoginWithInvalidUsernameAndValidPassword(){
        String invalidUsername = "username123";
        String validPassword = "secret_sauce";
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
    @Test
    public void userCantLoginWithInvalidUsernameAndInvalidPassword(){
        String invalidUsername = "username123";
        String invalidPassword = "secret_sauce123";
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }


}
