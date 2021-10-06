package productAddToCart;

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

//Adding annotation to the class to instruct it that the tests will run using parameters
@RunWith(JUnitParamsRunner.class)
public class productAddToCartTest {

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

    //  pass the data provider class to let the test know where the parameters come from
    @Test
    @Parameters(source = productAddToCartDataProvider.class)
    public void searchProductAndAddToCart(String Search) {
        driver.findElement(By.xpath("//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//a[.='Store']")).click();
        driver.findElement(By.name("s")).sendKeys(Search);
        driver.findElement(By.xpath("//button[.='Search']")).click();
        driver.findElement(By.name("add-to-cart")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".product_title")).isDisplayed());
    }
    @Test
    public void viewMyCart() {
        driver.findElement(By.xpath("//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//span[@class='count']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".has-text-align-center")).isDisplayed());
    }
}
