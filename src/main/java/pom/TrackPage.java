package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrackPage{
    private WebDriver driver;
    private By orderContentForm = By.className("Track_NotFound__6oaoY");

    public TrackPage(WebDriver driver){
        this.driver = driver;
    }

    public By getOrderContentForm(){
        return orderContentForm;
    }
}
