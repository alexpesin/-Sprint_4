package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage{
        private WebDriver driver;
        private By headerRegisterButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
        private By homeFinishRegisterButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
        private By headerLogoScooterLink = By.className("Header_LogoScooter__3lsAR");



        public MainPage(WebDriver driver){
            this.driver = driver;
        }

    public void clickHeaderRegisterButton(){
        WebElement element = driver.findElement(headerRegisterButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(headerRegisterButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_NextButton__1_rCA")));
    }

    public WebElement getStartFormRegisterButton (String buttonName){
        WebElement startFormRegisterButton = null;
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
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_NextButton__1_rCA")));
    }
  /*  public void clickOrderNextButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderNextButton);
        driver.findElement(orderNextButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Buttons__1xGrp")));

    }
    public void clickDatePickerPopper(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", datePickerPopper);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(datePickerPopper));
        driver.findElement(datePickerPopper).click();
    }
    public void clickDayPickerToDayButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dayPickerToDayButton);
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(dayPickerToDayButton));
        driver.findElement(dayPickerToDayButton).click();
    }
    public void clickDropDownСontrolButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dropDownСontrol);
        driver.findElement(dropDownСontrol).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));
    }
    public void clickDropDownOptionsToSelectOneDay(){
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
    }
    public void clickDropDownOptionsToSelectSevenDays(){
        driver.findElement(By.xpath(".//div[text()='семеро суток']")).click();
    }
    public void clickOrderCheckboxBlack(){
        driver.findElement(orderCheckboxBlack).click();
    }
    public void clickOrderCheckboxGrey(){
        driver.findElement(orderCheckboxGrey).click();
    }
    public void clickRegisterButtonMiddle(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", registerButtonMiddle);
        driver.findElement(registerButtonMiddle).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));
    }
    public void clickOrderConfirmButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderConfirmButton);
        driver.findElement(orderConfirmButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Text__2broi")));
    }
    public void clickStatusViewButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", statusViewButton);
        driver.findElement(statusViewButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Track_Content__St6Kn")));
    }

        // метод ожидания загрузки страницы
       public void waitForLoadHeader(){
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Nav__AGCXC")));
        }
    public void waitForLoadOrderContentForm(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderContentForm));
    }
    public void setSurNameField(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", surNameField);
        driver.findElement(surNameField).clear();
        driver.findElement(surNameField).sendKeys("Иван");
    }
    public void setNameField(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nameField);
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys("Иванов");
    }
    public void setAddressField(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addressField);
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys("ул. Труда");
    }
    public void setMetroStationField(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", metroStationField);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String metroValue = String.format(metroOptionTemplate, "Черкизовская");
        driver.findElement(By.xpath(metroValue)).click();
    }
    public void setPhoneField(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", phoneField);
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys("+755555555");
    }
    public void setInputContainer(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", inputContainer);
        driver.findElement(inputContainer).clear();
        driver.findElement(inputContainer).sendKeys("Не опаздывать!");
    }
    public void setOrderDate(){
            clickDatePickerPopper();
            clickDayPickerToDayButton();
    }
    public void setOrderRentTime(){
        clickDropDownСontrolButton();
        clickDropDownOptionsToSelectSevenDays();
    }


    public void fillOutOrderForm(){
        clickHeaderRegisterButton();
        setSurNameField();
        setNameField();
        setAddressField();
        setMetroStationField();
        setPhoneField();
        clickOrderNextButton();
        setOrderDate();
        setOrderRentTime();
        clickOrderCheckboxBlack();
        setInputContainer();
        clickRegisterButtonMiddle();
        clickOrderConfirmButton();
    }*/


}
