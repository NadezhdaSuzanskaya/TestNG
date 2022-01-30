package saucedemotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import steps.PurchaseSteps;
import web.pages.*;


public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected PurchaseSteps purchaseSteps;

    protected SoftAssert softAssert = new SoftAssert();
//    public static final String USERNAME = "standard_user";
 //   public static final String PASSWORD = "secret_sauce";

       public static String USERNAME;
      public static String PASSWORD ;

    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String ZIP_CODE = "111";

@BeforeSuite ( groups = "smoke")
@Parameters({"user","passcode"})
public void setupParamSuit(String user, String passcode)
{
    USERNAME= user;
    PASSWORD= passcode;
}
    @BeforeClass (alwaysRun=true, groups = "smoke")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        purchaseSteps = new PurchaseSteps(cartPage);
        purchaseSteps.setSoftAssert(softAssert);

    }



    @AfterClass(alwaysRun=true)
    public void teardown() {
        driver.close();
        driver.quit();


    }

}
