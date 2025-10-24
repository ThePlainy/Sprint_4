import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import scooterpages.DriverFactory;
import scooterpages.MainPage;
import util.Constants;

import java.time.Duration;

@RunWith(Parameterized.class)
public class FAQTextIsRightTest {
    public WebDriver driver;
    private final String browser;
    private final String questionInQuestion;
    private final String answerInQuestion;

    public FAQTextIsRightTest(String browser, String questionInQuestion, String answerInQuestion) {
        this.browser = browser;
        this.questionInQuestion = questionInQuestion;
        this.answerInQuestion = answerInQuestion;
    }

    @Before
    public void startUp(){
        DriverFactory objDriverFactory = new DriverFactory();
        driver = objDriverFactory.driverForSpecificBrowser(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        driver.get(Constants.SCOOTER_MAIN_PAGE);
        driver.manage().window().maximize();
    }

    @Parameterized.Parameters
    public static Object[][] getFAQData()  {
        //Структура данных на вход {Браузер (из констант), Вопрос, Ответ}
        return new Object[][]{
                {Constants.CHROME, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {Constants.CHROME, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {Constants.CHROME, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {Constants.CHROME, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {Constants.CHROME, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {Constants.CHROME, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {Constants.CHROME, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {Constants.CHROME, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},//в этом тесткейсе опечатка предумышленная, т.к. стоит задача сопоставить вопрос и ответ.
        };
    }

    @Test
    public void faqTextIsRightTest(){
        //Создаем объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        //Скроллим до FAQ
        objMainPage.faqScroll();
        //Кликаем по нужному вопросу
        objMainPage.faqClick(questionInQuestion);
        //Проверяем открывшийся ответ
        objMainPage.isFAQAnswerRight(answerInQuestion);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
