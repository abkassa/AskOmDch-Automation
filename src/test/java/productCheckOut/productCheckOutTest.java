package productCheckOut;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import userSignup.UserSignupDataProvider;

// Add an annotation to the class to instruct it that the tests will run using parameters
@RunWith(JUnitParamsRunner.class)
public class productCheckOutTest {

    WebDriver driver;

    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().setSize(new Dimension(1382, 752));
    }

    @After
    public void tearDown() {driver.quit();}

    // pass the data provider class to let the test know where the parameters come from
    @Test
    @Parameters(source = checkOutDataProvider.class)
    public void checkOut(String userName,  String password, String search, String fName, String lName, String company,
                         String address,String zipCode, String city, String phone) {
        // first login
        driver.findElement(By.xpath("//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//a[.='Account']")).click();
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        // Search for the item from store and add to cart
        driver.findElement(By.xpath("//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//a[.='Store']")).click();
        driver.findElement(By.name("s")).sendKeys(search);
        driver.findElement(By.xpath("//button[.='Search']")).click();
        driver.findElement(By.name("add-to-cart")).click();

        // View cart
        driver.findElement(By.xpath("//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//span[@class='count']")).click();

        // Proceed to check out
        driver.findElement(By.cssSelector(".checkout-button")).click();

        // Fill belling information
        driver.findElement(By.id("billing_first_name")).sendKeys(fName);
        driver.findElement(By.id("billing_last_name")).sendKeys(lName);
        driver.findElement(By.id("billing_company")).sendKeys(company);
        driver.findElement(By.id("select2-billing_country-container")).click();
        driver.findElement(By.id("billing_address_1")).sendKeys(address);
        driver.findElement(By.id("billing_postcode")).sendKeys(zipCode);
        driver.findElement(By.id("billing_city")).sendKeys(city);
        driver.findElement(By.id("billing_phone")).sendKeys(phone);

        //  Place Order
        driver.findElement(By.id("place_order")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".has-text-align-center")).isDisplayed());
    }







}
