package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.saucedemo.com/");

    }

    @Test
    public void userCanLogout(){
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", i, 0);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            loginPage.enterUsername(validUsername);
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();
            burgerMenuPage.burgerMenuButton.click();
            burgerMenuPage.logoutButton.click();
            Assert.assertTrue(loginPage.loginButton.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        }
    }
}
