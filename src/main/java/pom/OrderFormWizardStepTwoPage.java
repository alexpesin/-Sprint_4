package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormWizardStepTwoPage{
    private WebDriver driver;

    private By orderContentForm = By.className("Order_Content__bmtHS");
    private By dayPickerToDayButton = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    private By datePickerField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By datePickerPopper = By.className("react-datepicker-popper");
    private By dropDownСontrol = By.className("Dropdown-control");
    private By orderCheckboxBlack = By.id("black");
    private By orderCheckboxGrey = By.id("grey");
    private By inputContainer = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    private By registerButtonMiddle = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderConfirmButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    private By statusViewButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Посмотреть статус']");
    private By headerLogoScooterLink = By.className("Header_LogoScooter__3lsAR");


    public OrderFormWizardStepTwoPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDatePickerField(){
        WebElement element = driver.findElement(datePickerField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(datePickerField)).click();
    }
   
    public void clickDayPickerToDayButton(){
        WebElement element = driver.findElement(dayPickerToDayButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(dayPickerToDayButton)).click();
    }
    public void clickDropDownСontrolButton(){
        WebElement element = driver.findElement(dropDownСontrol);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
    }
   
    public void clickDropDownOptionsToSelectRentDuration(String rentDuration){
        String rentDurationOptionTemplate = ".//div[text()='%s']";
        String rentDurationValue = String.format(rentDurationOptionTemplate, rentDuration);
        driver.findElement(By.xpath(rentDurationValue)).click();
    }
    public void clickOrderCheckboxBlack(){
        driver.findElement(orderCheckboxBlack).click();
    }
    public void clickOrderCheckboxGrey(){
        driver.findElement(orderCheckboxGrey).click();
    }
    public void clickScooterColour(String scooterColour){
        if (scooterColour !=null) {
            if (scooterColour.equals("чёрный жемчуг")) {
                clickOrderCheckboxBlack();
            } else if (scooterColour.equals("серая безысходность")) {
                clickOrderCheckboxGrey();
            }
        }

    }
    public void clickFinishOrderRegisterButton(){
        WebElement element = driver.findElement(registerButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));
    }
    public void clickOrderConfirmationButton(){
        WebElement element = driver.findElement(orderConfirmButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']")));
    }
    public void clickStatusViewButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", statusViewButton);
        driver.findElement(statusViewButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Track_Content__St6Kn")));
    }
    
    public void setInputContainer(String comments){
        if(comments !=null) {
            WebElement element = driver.findElement(inputContainer);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.clear();
            element.sendKeys(comments);
        }
    }
    
    public void setOrderDate(String date){
        clickDatePickerField();
        //clickDatePickerPopper();
        clickDayPickerToDayButton();
    }
    public void setOrderRentTime(String rentDuration){
        clickDropDownСontrolButton();
        clickDropDownOptionsToSelectRentDuration(rentDuration);
    }



}
