package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishedShoppingPage extends BaseTest {
    public FinishedShoppingPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "title")
    public WebElement checkoutCompleteMessage;
    @FindBy(className = "complete-text")
    public WebElement orderDispatchedMessage;
    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;
    //------------------------------------------------
    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }
}
