
import POM.HomeFAQPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomeFAQTextMultipleMethodsTest extends TestBase{

@BeforeClass
public static void openFAQPage(){
    HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
    objHomeFAQPage.openFAQPage();
}


    @Test
    public void checkZeroItemText(){

        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem0Text();
        System.out.println(actualItemText);
        String expectedItemText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @Test
    public void checkFirstItemText(){

        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem1Text();
        System.out.println(actualItemText);
        String expectedItemText = "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void checkSecondItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem2Text();
        System.out.println(actualItemText);
        String expectedItemText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @Test
    public void checkThirdItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem3Text();
        System.out.println(actualItemText);
        String expectedItemText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @Test
    public void checkFourthItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem4Text();
        System.out.println(actualItemText);
        String expectedItemText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);

    }
    @Test
    public void checkFifthItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem5Text();
        System.out.println(actualItemText);
        String expectedItemText = "Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @Test
    public void checkSixthItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem6Text();
        System.out.println(actualItemText);
        String expectedItemText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @Test
    public void checkSeventhItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText =  objHomeFAQPage.getAccordionItem7Text();
        System.out.println(actualItemText);
        String expectedItemText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }


}

