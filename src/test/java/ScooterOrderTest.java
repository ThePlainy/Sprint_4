import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import scooterpages.DriverFactory;
import scooterpages.MainPage;
import scooterpages.OrderPage;
import util.Constants;

import java.time.Duration;


@RunWith(Parameterized.class)
public class ScooterOrderTest {

    public WebDriver driver;
    private final String browser;
    private final String startButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String durationInDays;
    private final String colour;

    public ScooterOrderTest(String browser, String startButton, String name, String surname, String address, String metro, String phoneNumber, String deliveryDate, String durationInDays, String colour) {
        this.browser = browser;
        this.startButton = startButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.durationInDays = durationInDays;
        this.colour = colour;
    }


    @Before
    public void startUp(){
        DriverFactory objDriverFactory = new DriverFactory();
        driver = objDriverFactory.driverForSpecificBrowser(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    @Parameterized.Parameters
    public static Object[][] getData()  {
        //Структура данных на вход {браузер (из констант), точка входа (из констант), имя, фамилия, адрес, станция метро, номер телефона, дата доставки(в формате ДД.ММ.ГГГГ), срок аренды (числом от 1 до 7), цвет самоката (из констант)}
        return new Object[][]{
                {Constants.FIREFOX, Constants.STARTING_HEADER,"Дмитрий", "Дмитриенко", "Дмитровское шоссе, 7", "Дмитровская", "89126820552", "27.10.2025","3", Constants.GREY},
                {Constants.FIREFOX, Constants.STARTING_MAIN_PAGE,"Дмитрий", "Дмитриенко", "Дмитровское шоссе, 7", "Красные Ворота", "89126820552", "27.10.2025","2", Constants.BLACK},
                {Constants.CHROME, Constants.STARTING_HEADER,"Дмитрий", "Дмитриенко", "Дмитровское шоссе, 7", "Полянка", "89126820552", "27.10.2025","7", Constants.GREY},
                {Constants.CHROME, Constants.STARTING_MAIN_PAGE,"Александр", "Лехано", "Алексеевский переулок, 6", "Алексеевская", "88005553535", "29.10.2025","1", Constants.BLACK},
        };
    }

    @Test
    public void scooterOrderTest(){

        //Переход на страницу тестового приложения
        driver.get(Constants.SCOOTER_MAIN_PAGE);

        //Создаем объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        //Переход в форму
        objMainPage.orderButtonClick(startButton);
        //Создание объекта класса страницы формы
        OrderPage objOrderPage = new OrderPage(driver);
        //Заполнение имени
        objOrderPage.setName(name);
        //Заполнение фамилии
        objOrderPage.setSurname(surname);
        //Заполнение адреса
        objOrderPage.setAddress(address);
        //Заполнение метро
        objOrderPage.setMetro(metro);
        //Заполнение номера телефона
        objOrderPage.setPhoneNumber(phoneNumber);
        //Нажатие первой кнопки подтверждения
        objOrderPage.nextButtonFirstFormClick();
        //Заполнение даты
        objOrderPage.setDeliveryDate(deliveryDate);
        //Заполнение длительности
        objOrderPage.setDuration(durationInDays);
        //Выбор цвета
        objOrderPage.setColour(colour);
        //Нажатие второй кнопки подтверждения
        objOrderPage.confirmOrderButtonClick();
        //Нажатие третьей кнопки подтверждения
        objOrderPage.yesOrderButtonClick();
        //Проверка сообщения о заказе
        objOrderPage.checkOrderConfirmation();


    }

    @After
    public void teardown(){
        driver.quit();
    }

}
