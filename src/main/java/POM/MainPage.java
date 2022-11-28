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
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_NextButton__1_rCA")));
    }

}
