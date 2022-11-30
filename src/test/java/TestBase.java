
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase{
    private static WebDriver driver;
    private final String baseURL = "https://qa-scooter.praktikum-services.ru/";

    public String getBaseURL(){
        return baseURL;
    }
//@BeforeClass
    // создали драйвер для браузера Chrome
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();*/
    }

    /*@BeforeClass
    public static void openAppPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        waitForLoadHomePage();
    }*/

    public static WebDriver getDriver(){
        return driver;
    }


    public static void waitForLoadHomePage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Header__214zg")));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']")));

    }

    /*@AfterClass
    public static void tearDown(){
        // Закрой браузер
        driver.quit();
        driver = null;
    }*/

    boolean isElementPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

}
