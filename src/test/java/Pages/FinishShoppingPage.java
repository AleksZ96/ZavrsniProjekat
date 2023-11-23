package Pages;

import Base.BaseTest;
import Tests.FinishShoppingTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishShoppingPage extends BaseTest {
    public FinishShoppingPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    //---------------------------------------------------------------------
    public void clickOnFinishButton(){
        finishButton.click();
    }
}
