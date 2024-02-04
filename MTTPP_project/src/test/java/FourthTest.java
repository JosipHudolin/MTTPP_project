import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class FourthTest {
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.youtube.com/watch?v=_F7i5CizK2I";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//Create a new ChromeDriver
        driver = new ChromeDriver();
//Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement playPauseButton = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[36]/div[2]/div[1]/button"));
        WebElement volumeButton = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[36]/div[2]/div[1]/span/button"));

        playPauseButton.click();
        Thread.sleep(3000);
        playPauseButton.click();
        Thread.sleep(3000);
        volumeButton.click();
        Thread.sleep(3000);
        volumeButton.click();
        Assert.assertTrue(playPauseButton.isDisplayed() && volumeButton.isDisplayed(), "Buttons aren't working");
    }




    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
