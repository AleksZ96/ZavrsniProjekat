package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public HomePage homePage;
    public BurgerMenuPage burgerMenuPage;
    public ItemPage itemPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public FinishShoppingPage finishShoppingPage;
    public FinishedShoppingPage finishedShoppingPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage = new LoginPage();
        excelReader = new ExcelReader("src/test/java/AutomatskiDeoProjekta.xlsx");
        homePage = new HomePage();
        burgerMenuPage = new BurgerMenuPage();
        itemPage = new ItemPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        finishShoppingPage = new FinishShoppingPage();
        finishedShoppingPage = new FinishedShoppingPage();
    }


    @AfterClass
    public void tearDown(){
       // driver.quit();
    }

}
