package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BaseTest {
    public ItemPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public WebElement addToCartButton;

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public WebElement removeButton;

    //------------------------------------------------------------------
    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }
    public void clickOnRemoveFromCartButton(){
        removeButton.click();
    }
}
