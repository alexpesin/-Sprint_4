import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.MainPage;
import pom.OrderPage;
import pom.TrackPage;

public class ExtraTests extends TestBase{

    @Before
    public void openAppPageBeforeTest(){
        setUp();
        getDriver().get(getBaseURL());
        waitForLoadHomePage();
    }


    @Test
    public void checkLogoScooterLinkShouldOpenMainScooterPage(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.clickHeaderLogoScooterLink();
        Assert.assertTrue("Главная страница  'Самоката' не открылась", isElementPresent(mainPage.getHome_FourPart()));
    }
    // тесты на сообщения об ошибках, когда обязательные поля не заполнены
    @Test
    public void checkErrorMessagesForOrderTableSurNameFieldEmptyValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setNameField("Иванов");
        orderPage.setAddressField("село Кукуево");
        orderPage.setMetroStationField("Сокол");
        orderPage.setPhoneField("55555555555");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректное имя";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextSurNameField());
    }

    @Test
    public void checkErrorMessagesForOrderTableSurNameFieldNonRussianValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setSurNameField("Test!");
        orderPage.setNameField("Иванов");
        orderPage.setAddressField("село Кукуево");
        orderPage.setMetroStationField("Сокол");
        orderPage.setPhoneField("55555555555");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректное имя";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextSurNameField());

    }

    @Test
    public void checkErrorMessagesForOrderTableNameFieldEmptyValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setAddressField("село Кукуево");
        orderPage.setMetroStationField("Сокол");
        orderPage.setPhoneField("55555555555");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректную фамилию";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextNameField());
    }

    @Test
    public void checkErrorMessagesForOrderTableNameFieldNonRussianValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setMetroStationField("Сокол");
        orderPage.setPhoneField("55555555555");
        orderPage.setAddressField("село Кукуево");
        orderPage.setNameField("Doe");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректную фамилию";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextNameField());

    }
    @Test
    public void checkErrorMessagesForOrderTablePhoneFieldEmptyValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setAddressField("село Кукуево");
        orderPage.setMetroStationField("Черкизовская");
        orderPage.setNameField("Петров");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректный номер";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextPhoneField());
    }

    @Test
    public void checkErrorMessagesForOrderTablePhoneFieldInvalidValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setPhoneField("32");
        orderPage.setAddressField("село Кукуево");
        orderPage.setMetroStationField("Черкизовская");
        orderPage.setNameField("Петров");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректный номер";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextPhoneField());
    }

    @Test
    public void checkErrorMessagesForOrderTableMetroStationFieldEmptyValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setNameField("Петров");
        orderPage.setAddressField("село Кукуево");
        orderPage.setPhoneField("55555555555");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));

        String expectedErrorMessage = "Выберите станцию";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextMetroStationField());
    }

    @Test
    public void checkErrorMessagesForOrderTableMetroStationFieldInvalidValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setNameField("Петров");
        orderPage.setAddressField("село Кукуево");
        orderPage.setPhoneField("55555555555");
        orderPage.setSurNameField("Иван");
        orderPage.setMetroStationFieldUsingEnterKeyButton("Купчино");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));

        String expectedErrorMessage = "Выберите станцию";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextMetroStationField());
    }

    @Test
    public void checkErrorMessagesForOrderTableAddressFieldEmptyValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setPhoneField("55555555555");
        orderPage.setMetroStationField("Черкизовская");
        orderPage.setNameField("Петров");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректный адрес";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextAddressField());
    }
    @Test
    public void checkErrorMessagesForOrderTableAddressFieldNonRussianValue(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickHeaderRegisterButton();
        OrderPage orderPage = new OrderPage(getDriver());

        orderPage.setPhoneField("55555555555");
        orderPage.setMetroStationField("Черкизовская");
        orderPage.setNameField("Петров");
        orderPage.setAddressField("!@#$%^&*");
        orderPage.setSurNameField("Иван");

        orderPage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue("Пользователь должен остаться на той же странице", isElementPresent(orderPage.getOrderHeaderScooter()));
        String expectedErrorMessage = "Введите корректный адрес";
        Assert.assertEquals("Неверное сообщение об ошибке: ", expectedErrorMessage, orderPage.getErrorMessageTextAddressField());
    }

    @Test
    public void checkTrackNotFound(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.clickOrderStatusButton();
        mainPage.setOrderNumber(123123);
        mainPage.clickGoButton();
        TrackPage trackPage = new TrackPage(getDriver());
        Assert.assertTrue("Заказ с таким номером не должен быть найден", isElementPresent(trackPage.getOrderContentForm()));
    }

    @After
    public void tearDownAfterTest(){
        // Закрой браузер
        getDriver().quit();
    }
}
