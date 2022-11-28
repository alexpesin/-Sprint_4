package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormWizardStepOnePage{
    private WebDriver driver;
    private By orderContentForm = By.className("Order_Content__bmtHS");
    private By surNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By nameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.className("select-search__input");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderNextButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text()='Далее']");
    private By headerLogoScooterLink = By.className("Header_LogoScooter__3lsAR");


    public OrderFormWizardStepOnePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHeaderLogoScooterLink(){
        WebElement element = driver.findElement(headerLogoScooterLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_FourPart__1uthg")));
    }

    public void clickOrderNextButton(){
        WebElement element = driver.findElement(orderNextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Buttons__1xGrp")));
    }


    public void setSurNameField(String surName){
        WebElement element = driver.findElement(surNameField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        element.sendKeys(surName);
    }

    public void setNameField(String name){
        WebElement element = driver.findElement(nameField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        element.sendKeys(name);
    }

    public void setAddressField(String address){
        if (address !=null) {
            WebElement element = driver.findElement(addressField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.clear();
            element.sendKeys(address);
        }
    }

    public void setMetroStationField(String metroStation){
        WebElement element = driver.findElement(metroStationField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String metroValue = String.format(metroOptionTemplate, metroStation);
        element.sendKeys(metroStation);
        driver.findElement(By.xpath(metroValue)).click();
    }

    public void setPhoneField(String phone){
        WebElement element = driver.findElement(phoneField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        element.sendKeys(phone);
    }

}
