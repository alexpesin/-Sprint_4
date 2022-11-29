package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeFAQPage {

    private final WebDriver driver;
    private final By home_FourPart = By.className("Home_FourPart__1uthg");

    public HomeFAQPage(WebDriver driver){
        this.driver = driver;
    }

    // метод ожидания загрузки страницы
    public void waitForLoadHomeFAQ(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(home_FourPart));
    }

    public void scrollHomeFourPart(){
        WebElement homeFourPart = driver.findElement(home_FourPart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", homeFourPart);
    }

    public void openFAQPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        waitForLoadHomeFAQ();
        scrollHomeFourPart();
    }

    public String getAccordionItemID(int index){
        return "accordion__heading-" + index;
    }

    public void clickFAQItem(String locator){
        WebElement item = driver.findElement(By.id(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", item);
        item.click();
    }

    public String getAccordionItemText(int index){
        String itemHeadingID = getAccordionItemID(index);
        clickFAQItem(itemHeadingID);
        String itemPanelID = "accordion__panel-" + index;
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(itemPanelID)));
        return driver.findElement(By.id(itemPanelID)).getText();
    }


}
