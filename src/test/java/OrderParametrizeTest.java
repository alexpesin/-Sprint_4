import pom.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pom.OrderPage;

@RunWith(Parameterized.class)
public class OrderParametrizeTest extends TestBase{


    private final String startRegisterButton;
    private final String surName;
    private final String name;
    private final String address;
    private final String metroStation;
    private final String phone;

    private final String time;
    private final String rentDuration;
    private final String scooterColour;
    private final String comments;


    public OrderParametrizeTest(String startRegisterButton, String surName, String name,
                                String address, String metroStation, String phone, String time, String rentDuration, String scooterColour, String comments){
        this.startRegisterButton = startRegisterButton;
        this.surName = surName;
        this.name = name;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.time = time;
        this.rentDuration = rentDuration;
        this.scooterColour = scooterColour;
        this.comments = comments;
    }


    @Parameterized.Parameters
    public static Object[][] getFormData(){
        return new Object[][]{
                {"top", "Елена", "Петрова", null, "Стрешнево", "11111111111", "27.12.2023", "семеро суток", null, null},
                {"bottom", "Сергей Петрович", "Сидоров", "Кронштадский бульвар ", "Водный стадион", "55555555599", "27.11.2022", "четверо суток", "серая безысходность", "доставить заказ к 5 часам"},
                {"top", "Вася", "Иванов", "домой", "Сокольники", "55555555555", "27.11.2022", "трое суток", "чёрный жемчуг", "Нужно точно в срок!"},
        };
    }

    @Before
    public void openAppPage(){
        setUp();
        getDriver().get(getBaseURL());
        waitForLoadHomePage();
    }

    @Test
    public void checkOrderIsSuccessfullyCompletedTest(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickStartFormRegisterButton(mainPage.getStartFormRegisterButton(startRegisterButton));
        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.fillOutOrderForm(surName, name, address, metroStation, phone, time, rentDuration, scooterColour, comments);
        orderPage.clickFinishOrderRegisterButton();
        orderPage.clickOrderConfirmationButton();
        Assert.assertTrue("Нет всплывающего окна с сообщением об успешном создании заказа",
                isElementPresent(orderPage.getOrderModalHeader()));
    }
    @After
    public void tearDownAfterTest(){
        // Закрой браузер
        getDriver().quit();
    }

}
