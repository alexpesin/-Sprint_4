package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPage{

    private WebDriver driver;
    private By orderContentForm = By.className("Order_Content__bmtHS");
    private By surNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By nameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.className("select-search__input");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderNextButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text()='Далее']");
    private By headerLogoScooterLink = By.className("Header_LogoScooter__3lsAR");
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


    public OrderPage(WebDriver driver){
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
    public void clickOrderNextButtonNoRequiredFieldsAreCompleted(){
        WebElement element = driver.findElement(orderNextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
//заполнение полей первого шага визарда формы заказа
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

    // второй шаг заполнения формы заказа

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
    // заполнение формы заказа
    public void fillOutOrderForm(String surName, String name,
                                 String address, String metroStation, String phone, String date, String rentDuration, String scooterColour, String comments){
        setSurNameField(surName);
        setNameField(name);
        setAddressField(address);
        setMetroStationField(metroStation);
        setPhoneField(phone);
        clickOrderNextButton();
        setOrderDate(date);
        setOrderRentTime(rentDuration);
        clickScooterColour(scooterColour);
        setInputContainer(comments);

    }

}
