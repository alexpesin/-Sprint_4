import POM.MainPage;
import POM.OrderFormWizardStepOnePage;
import org.junit.*;
import org.openqa.selenium.By;

public class ExtraTests extends TestBase{

    @Before
    public void openAppPageBeforeTest(){
        setUp();
        getDriver().get("https://qa-scooter.praktikum-services.ru/");
        waitForLoadHomePage();
    }


    @Test
    public void checkLogoScooterLinkShouldOpenMainScooterPage(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickHeaderLogoScooterLink();
        Assert.assertTrue("Главная страница  'Самоката' не открылась", isElementPresent(By.className("Home_FourPart__1uthg")));
    }

    @Test
    public void checkErrorMessagesForOrderTableSurNameField(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue(isElementPresent(By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']")));
        Assert.assertTrue("Должно появится сообщение об ошибке: Введите корректное имя", isElementPresent(By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректное имя']")));
    }

    @Test
    public void checkErrorMessagesForOrderTableNameField(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue(isElementPresent(By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']")));
        Assert.assertTrue("Должно появится сообщение об ошибке: Введите корректную фамилию", isElementPresent(By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректную фамилию']")));
    }
    @Test
    public void checkErrorMessagesForOrderTablePhoneField(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue(isElementPresent(By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']")));
        Assert.assertTrue("Должно появится сообщение об ошибке: Введите корректный номер", isElementPresent(By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6'][text()='Введите корректный номер']")));
    }
    @Test
    public void checkErrorMessagesForOrderTableMetroStationField(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickOrderNextButtonNoRequiredFieldsAreCompleted();
        Assert.assertTrue(isElementPresent(By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']")));
        Assert.assertTrue("Должно появится сообщение об ошибке: Выберите станцию", isElementPresent(By.xpath(".//div[@class='Order_MetroError__1BtZb'][text()='Выберите станцию']")));
    }

    @After
    public void tearDownAfterTest(){
        // Закрой браузер
        getDriver().quit();
    }
}
