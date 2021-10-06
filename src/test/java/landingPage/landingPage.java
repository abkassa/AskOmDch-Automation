package landingPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class landingPage {
    //This method will run once before all the tests in our class
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    // This will check if the landing page loads correctly
    @Test
    public void openSite() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().setSize(new Dimension(1382, 752));
        Thread.sleep(3000);
        driver.quit();
    }
}
