package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;


public class OrderPage{

    private WebDriver driver;
    private By orderContentForm = By.className("Order_Content__bmtHS");
    private By home_FourPart = By.className("Home_FourPart__1uthg");
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
    private By orderHeaderScooter = By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']");
    private By orderModalHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");
    private By errorMessageTextSurNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректное имя']");
    private By errorMessageTextNameField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректную фамилию']");
    private By errorMessageTextPhoneField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректный номер']");
    private By errorMessageTextAddressField = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректный адрес']");
    private By errorMessageTextMetroStationField = By.xpath(".//div[@class='Order_MetroError__1BtZb'][text()='Выберите станцию']");


    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public By getOrderModalHeader(){
        return orderModalHeader;
    }

    public String getErrorMessageTextAddressField(){
        return driver.findElement(errorMessageTextAddressField).getText();
    }

    public String getErrorMessageTextMetroStationField(){
        return driver.findElement(errorMessageTextMetroStationField).getText();
    }

    public String getErrorMessageTextPhoneField(){
        return driver.findElement(errorMessageTextPhoneField).getText();
    }

    public String getErrorMessageTextNameField(){
        return driver.findElement(errorMessageTextNameField).getText();
    }

    public String getErrorMessageTextSurNameField(){
        return driver.findElement(errorMessageTextSurNameField).getText();
    }


    public By getOrderHeaderScooter(){
        return orderHeaderScooter;
    }


    public void clickHeaderLogoScooterLink(){
        WebElement element = driver.findElement(headerLogoScooterLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(home_FourPart));
    }

    public void clickOrderNextButton(){
        WebElement element = driver.findElement(orderNextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButtonMiddle));
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
        if (address != null) {
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

    public void setMetroStationFieldUsingEnterKeyButton(String metroStation){
        WebElement element = driver.findElement(metroStationField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String metroValue = String.format(metroOptionTemplate, metroStation);
        element.sendKeys(metroStation);
        element.sendKeys(ENTER);

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
        new WebDriverWait(driver, Duration.ofSeconds(3))
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
        if (scooterColour != null) {
            if (scooterColour.equals("чёрный жемчуг")) {
                clickOrderCheckboxBlack();
            } else if (scooterColour.equals("серая безысходность")) {
                clickOrderCheckboxGrey();
            }
        }
    }

    public void setInputContainer(String comments){
        if (comments != null) {
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
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmButton));
    }

    public void clickOrderConfirmationButton(){
        WebElement element = driver.findElement(orderConfirmButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderModalHeader));
    }

    public void clickStatusViewButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", statusViewButton);
        driver.findElement(statusViewButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
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
