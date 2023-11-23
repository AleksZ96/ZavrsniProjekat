package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerMenuPage extends BaseTest {
    public BurgerMenuPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //---------------------------------------
    public void clickOnBurgerMenuButton(){
        burgerMenuButton.click();
    }

    public void clickOnLogoutButton(){
        logoutButton.click();
    }
}
