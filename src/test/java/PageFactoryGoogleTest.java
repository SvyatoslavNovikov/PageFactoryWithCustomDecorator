import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.SearchPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class PageFactoryGoogleTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://google.com");
    }

    @Test
    public void getListElements() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField.sendKeys("Automation step by step");
        searchPage.searchButton.click();
        Assert.assertEquals(searchPage.searchResultContainers.size(), 8);
    }

    @Test
    public void getListContainers() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField.sendKeys("Automation step by step");
        searchPage.searchButton.click();
        Assert.assertEquals(searchPage.searchResult.size(), 8);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
