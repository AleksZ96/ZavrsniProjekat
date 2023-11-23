package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartIcon;
    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;
    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> listOfAddToCartButtons;
    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement>listOfRemoveButtons;
    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemNames;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    //-------------------------------

    public void addAllItemsToCart(){
        for (WebElement button : listOfAddToCartButtons) {
            button.click();
        }
    }
    public void removeAllItemsFromCart(){
        for (WebElement button : listOfRemoveButtons) {
            button.click();
        }
    }
    public void clickOnShoppingCartIcon(){
        shoppingCartIcon.click();
    }

    public void clickOnOptionAToZFromDropdown(){
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("az");
    }

    public void clickOnOptionZToAFromDropdown(){
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("za");
    }

    public ArrayList<String> getItemNames(){
        ArrayList<String> items = new ArrayList<>();
        for (WebElement webElement : itemNames){
            items.add(webElement.getText());
        }
        return items;
    }

    public ArrayList<String> getSortedList(ArrayList<String> list){
        Collections.sort(list);
        return list;
    }

    public ArrayList<String> getReverseList(ArrayList<String> list){
        list.sort(Collections.reverseOrder());
        return list;
    }

    public void clickOnOptionLoHiFromDropdown(){
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("lohi");
    }
    public void clickOnOptionHiLoFromDropdown(){
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue("hilo");
    }
    public ArrayList<Double> getItemPrices(){
        ArrayList<Double> items = new ArrayList<>();
        for (WebElement webElement : itemPrices){
            String text = webElement.getText();
            String cenaString = text.substring(1);
            items.add(Double.parseDouble(cenaString));
        }
        return items;
    }

    public ArrayList<Double> getSortedPriceList(ArrayList<Double> list){
        Collections.sort(list);
        return list;
    }
    public ArrayList<Double> getReversePriceList(ArrayList<Double> list){
        list.sort(Collections.reverseOrder());
        return list;
    }
}
