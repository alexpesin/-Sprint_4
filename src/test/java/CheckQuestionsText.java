import POM.HomeFAQPage;
import org.junit.*;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
public class CheckQuestionsText extends TestBase{

   /* В этом классе есть  два варианта запуска тестов:
    1. используя @BeforeClass в TestBase инициализирую браузер один раз, прогоняю все тесты и закрываю браузер
    2. @Before инициализирую и закрываю браузер после каждого теста (выбрано сейчаc  из-за условия задачи, но первый вариант выглядит логичнее)
    */

    @Before
    public void openHomeFAQPage(){
        setUp();
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        objHomeFAQPage.openFAQPage();
    }


    @Test
    public void a_checkZeroQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(0);
        String expectedItemText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void b_checkFirstQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(1);
        String expectedItemText = "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void c_checkSecondQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(2);
        String expectedItemText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void d_checkThirdQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(3);
        String expectedItemText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void e_checkFourthQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(4);
        String expectedItemText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);

    }

    @Test
    public void f_checkFifthQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(5);
        String expectedItemText = "Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void g_checkSixthQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(6);
        String expectedItemText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }

    @Test
    public void h_checkSeventhQuestionItemText(){
        HomeFAQPage objHomeFAQPage = new HomeFAQPage(getDriver());
        String actualItemText = objHomeFAQPage.getAccordionItemText(7);
        String expectedItemText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualItemText);
    }
    @After
    public void tearDownAfterTest(){
        // Закрой браузер
        getDriver().quit();
    }

}
