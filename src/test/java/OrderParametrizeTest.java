import POM.MainPage;
import POM.OrderFormWizardStepTwoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

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
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"top", "Елена", "Петрова", null, "Стрешнево", "11111111111", "27.12.2023", "семеро суток", null, null},
                {"bottom", "Сергей Петрович", "Сидоров", "Кронштадский бульвар ", "Водный стадион", "55555555599", "27.11.2022", "четверо суток", "серая безысходность", "доставить заказ к 5 часам"},
                {"top", "Вася", "Иванов", "домой", "Сокольники", "55555555555", "27.11.2022", "трое суток", "чёрный жемчуг", "Нужно точно в срок!"},


        };
    }

    @Before
    public void openAppPageBeforeTest(){
        getDriver().get("https://qa-scooter.praktikum-services.ru/");
        waitForLoadHomePage();
    }

    @Test
    public void checkOrderIsSuccessfullyCompletedTest(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickStartFormRegisterButton(mainPage.getStartFormRegisterButton(startRegisterButton));
        OrderFormWizardStepTwoPage formStepTwo = new OrderFormWizardStepTwoPage(getDriver());
        fillOutOrderForm(surName, name, address, metroStation, phone, time, rentDuration, scooterColour, comments);
        formStepTwo.clickFinishOrderRegisterButton();
        formStepTwo.clickOrderConfirmationButton();
        Assert.assertTrue("Нет всплывающего окна с сообщением об успешном создании заказа",
                isElementPresent(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']")));
    }


}
