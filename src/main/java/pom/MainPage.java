package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage{
        private WebDriver driver;
        private By headerRegisterButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
        private By homeFinishRegisterButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
        private By orderStatusLink = By.xpath(".//button[@class='Header_Link__1TAG7'][text()='Статус заказа']");
        private By searchButton = By.xpath(".//div[@class='Header_SearchInput__3YRIQ']//button[text()='Go!']");
        private By headerSearchOrderNumberInput = By.xpath(".//div[@class='Header_SearchInput__3YRIQ']//input[@placeholder ='Введите номер заказа']");

    public By getHome_FourPart(){
        return home_FourPart;
    }

    private By home_FourPart = By.className("Home_FourPart__1uthg");
        private By rccConfirmButton = By.id("rcc-confirm-button");



        public MainPage(WebDriver driver){
            this.driver = driver;
        }
        //закрыть куки

        boolean isElementPresent(By locator){
            try{
                driver.findElement(locator);
                return true;
            }catch(NoSuchElementException e){
                return false;
            }
        }
        public void clickCookieConfirmButton(){
            if (isElementPresent(rccConfirmButton)) {
                WebElement rccConfirm = driver.findElement(rccConfirmButton);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", rccConfirm);
                rccConfirm.click();
            }
        }

    public void clickOrderStatusButton(){
        WebElement orderStatus = driver.findElement(orderStatusLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderStatus);
        orderStatus.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.xpath(".//input[@placeholder ='Введите номер заказа']")));
    }
    public void setOrderNumber(int orderNumber){
        WebElement headerSearchOrderInputBox = driver.findElement(headerSearchOrderNumberInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", headerSearchOrderInputBox);
        headerSearchOrderInputBox.sendKeys(Integer.toString(orderNumber));
    }
    public void clickGoButton(){
        WebElement goButton = driver.findElement(searchButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", goButton);
        goButton.click();

    }

    public void clickHeaderRegisterButton(){
        WebElement element = driver.findElement(headerRegisterButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(headerRegisterButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.className("Order_NextButton__1_rCA")));
    }

    public WebElement getStartFormRegisterButton (String buttonName){
        WebElement startFormRegisterButton;
            if (buttonName.equals("top")){
                startFormRegisterButton =  driver.findElement(headerRegisterButton);
            }
            else if (buttonName.equals("bottom")){
                startFormRegisterButton = driver.findElement(homeFinishRegisterButton);
            }
            else {
                startFormRegisterButton =  driver.findElement(headerRegisterButton);
            }
        return startFormRegisterButton;
    }

    public void clickStartFormRegisterButton(WebElement startFormRegisterButton){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", startFormRegisterButton);
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(startFormRegisterButton));
        startFormRegisterButton.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.className("Order_NextButton__1_rCA")));
    }

    // методы для проверки текста (блок часто спрашиваемых вопросов)

    public void scrollHomeFourPart(){
        WebElement homeFourPart = driver.findElement(home_FourPart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", homeFourPart);
    }

    public String getQuestionID(int index){
        return "accordion__heading-" + index;
    }

    public void clickFAQItem(String locator){
        WebElement item = driver.findElement(By.id(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", item);
        item.click();
    }

    public String getQuestionText(int index){
        String itemHeadingID = getQuestionID(index);
        clickFAQItem(itemHeadingID);
        String itemPanelID = "accordion__panel-" + index;
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(visibilityOfElementLocated(By.id(itemPanelID)));
        return driver.findElement(By.id(itemPanelID)).getText();
    }


}
