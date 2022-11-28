package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeFAQPage{

    private final WebDriver driver;
    private final By home_FourPart = By.className("Home_FourPart__1uthg");
    private final By accordionItem0 = By.id("accordion__heading-0");
    private final By accordionItem1 = By.id("accordion__heading-1");
    private final By accordionItem2 = By.id("accordion__heading-2");
    private final By accordionItem3 = By.id("accordion__heading-3");
    private final By accordionItem4 = By.id("accordion__heading-4");
    private final By accordionItem5 = By.id("accordion__heading-5");
    private final By accordionItem6 = By.id("accordion__heading-6");
    private final By accordionItem7 = By.id("accordion__heading-7");


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

    // метод для раскрытия первого вопроса в разделе «Вопросы о важном»
    public void clickAccordionItem0(){
        driver.findElement(accordionItem0).click();
    }

    public void clickAccordionItem1(){
        driver.findElement(accordionItem1).click();
    }

    public void clickAccordionItem2(){
        driver.findElement(accordionItem2).click();
    }

    public void clickAccordionItem3(){
        driver.findElement(accordionItem3).click();
    }

    public void clickAccordionItem4(){
        driver.findElement(accordionItem4).click();
    }

    public void clickAccordionItem5(){
        driver.findElement(accordionItem5).click();
    }

    public void clickAccordionItem6(){
        driver.findElement(accordionItem6).click();
    }

    public void clickAccordionItem7(){
        driver.findElement(accordionItem7).click();
    }


    public String getAccordionItemText(int index){
        String itemHeadingID = getAccordionItemID(index);
        clickFAQItem(itemHeadingID);
        String itemPanelID = "accordion__panel-" + index;
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(itemPanelID)));
        return driver.findElement(By.id(itemPanelID)).getText();
    }

    // метод для получения текста элемента в заголовке
    public String getAccordionItem0Text(){
        clickAccordionItem0();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-0")));
        return driver.findElement(By.id("accordion__panel-0")).getText();
    }

    public String getAccordionItem1Text(){
        clickAccordionItem1();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-1")));
        return driver.findElement(By.id("accordion__panel-1")).getText();
    }

    public String getAccordionItem2Text(){
        clickAccordionItem2();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-2")));
        return driver.findElement(By.id("accordion__panel-2")).getText();
    }

    public String getAccordionItem3Text(){
        clickAccordionItem3();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-3")));
        return driver.findElement(By.id("accordion__panel-3")).getText();
    }

    public String getAccordionItem4Text(){
        clickAccordionItem4();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-4")));
        return driver.findElement(By.id("accordion__panel-4")).getText();
    }

    public String getAccordionItem5Text(){
        clickAccordionItem5();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-5")));
        return driver.findElement(By.id("accordion__panel-5")).getText();
    }

    public String getAccordionItem6Text(){
        clickAccordionItem6();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-6")));
        return driver.findElement(By.id("accordion__panel-6")).getText();
    }

    public String getAccordionItem7Text(){
        clickAccordionItem7();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-7")));
        return driver.findElement(By.id("accordion__panel-7")).getText();
    }

}
