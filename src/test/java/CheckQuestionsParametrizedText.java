import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;


@RunWith(Parameterized.class)
public class CheckQuestionsParametrizedText extends TestBase{
    private int questionID;
    private String expectedItemText;

    public CheckQuestionsParametrizedText(int questionID, String expectedItemText){
        this.questionID = questionID;
        this.expectedItemText = expectedItemText;
    }

    @Parameterized.Parameters
    public static Object[][] getFrequentlyAskedQuestionsData(){
        return new Object[][]{
                {0,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, new StringBuilder().append("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. ")
                        .append("Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. ")
                        .append("Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.").toString()},
                {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void openHomeFAQPage(){
        setUp();
        getDriver().get(getBaseURL());
        waitForLoadHomePage();



    }

    @Test
    public void checkFrequentlyAskedQuestionText(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCookieConfirmButton();
        mainPage.scrollHomeFourPart();
        String actualQuestionText = mainPage.getQuestionText(questionID);
        Assert.assertEquals("Текст не соответствует ожидаемому", expectedItemText, actualQuestionText);
    }


    @After
    public void tearDown(){
        // Закрой браузер
        getDriver().quit();
    }

}
