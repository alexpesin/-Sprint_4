
import POM.MainPage;
import POM.OrderFormWizardStepTwoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class OrderTest extends TestBase{

    @Test
    public void checkOrderIsSuccessfullyCompletedTest(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickStartFormRegisterButton(mainPage.getStartFormRegisterButton("bottom"));
        OrderFormWizardStepTwoPage formStepTwo = new OrderFormWizardStepTwoPage(getDriver());
        fillOutOrderForm();
        formStepTwo.clickFinishOrderRegisterButton();
        formStepTwo.clickOrderConfirmationButton();
        Assert.assertTrue("Нет всплывающего окна с сообщением об успешном создании заказа",
                isElementPresent(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']")));
    }

}
