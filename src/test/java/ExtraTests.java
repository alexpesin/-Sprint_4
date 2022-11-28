import POM.HomeFAQPage;
import POM.MainPage;
import POM.OrderFormWizardStepOnePage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;

public class ExtraTests extends TestBase{
    @Test
    public void checkLogoScooterLinkShouldOpenMainScooterPage(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickHeaderRegisterButton();
        OrderFormWizardStepOnePage stepOnePage = new OrderFormWizardStepOnePage(getDriver());
        stepOnePage.clickHeaderLogoScooterLink();
        Assert.assertTrue("Главная страница  'Самоката' не открылась", isElementPresent(By.className("Home_FourPart__1uthg")));
    }
}
