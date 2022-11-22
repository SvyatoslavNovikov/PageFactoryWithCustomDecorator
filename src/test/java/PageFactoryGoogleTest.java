import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.SearchPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageFactoryGoogleTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get("https://google.com");
    }

    @Test
    public void getList() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchField.sendKeys("Automation step by step");
        searchPage.searchButton.click();
        Assert.assertEquals(searchPage.searchResult.size(), 8);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
