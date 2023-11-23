package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameBox;
    @FindBy(id = "last-name")
    public WebElement lastNameBox;
    @FindBy(id = "postal-code")
    public WebElement postalCodeBox;
    @FindBy(id = "continue")
    public WebElement continueButton;

    //--------------------------------------------

    public void inputFirstName(String name){
        firstNameBox.sendKeys(name);
    }
    public void inputLastName(String lastName){
        lastNameBox.sendKeys(lastName);
    }
    public void inputPostalCode(String postalCode){
        postalCodeBox.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
