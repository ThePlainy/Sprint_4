package scooterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //Поле фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле выбора станции метро
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private final By nextButtonFirstForm = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    //Поле дня доставки и его дроп
    private final By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By deliveryDateClickable = By.xpath(".//div[@class='react-datepicker__week']/*[@tabindex='0']");

    //Поле срока аренды
    private final By rentDurationField = By.xpath(".//div[text()='* Срок аренды']");

    //Чекбокс цвета самоката - удалено ввиду передачи непосредственно селектора в метод в параметризованном тесте
    //private By productColour = By.cssSelector(colour);

    //Кнопка Заказать
    private final By confirmOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Кнопка Да попапа подтверждения
    private final By yesOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text() = 'Да']");

    //Заголовок попапа
    private final By popupTitle = By.cssSelector(".Order_ModalHeader__3FDaJ");

    //Ввод имени
    public void setName (String name){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    //Ввод фамилии
    public void setSurname (String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    //Ввод адреса
    public void setAddress (String address){
        driver.findElement(addressField).sendKeys(address);
    }

    //Выбор станции метро
    public void setMetro (String metro){
        driver.findElement(metroField).sendKeys(metro);
        String newMetroSelector = ".//*[text()='"+metro+"']";
        driver.findElement(By.xpath(newMetroSelector)).click();
    }

    //Ввод телефона
    public void setPhoneNumber (String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //Нажатие кнопки Далее
    public void nextButtonFirstFormClick (){
        driver.findElement(nextButtonFirstForm).click();
    }

    //Ввод дня доставки
    public void setDeliveryDate (String deliveryDate){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(deliveryDateField));
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(deliveryDateClickable).click();
    }

    //Ввод срока аренды
    public void setDuration (String durationInDays){
        String dropdownChoice = "#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root.is-open > div.Dropdown-menu > div:nth-child("+durationInDays+")";
        By rentDurationFieldDropdown = By.cssSelector(dropdownChoice);
        driver.findElement(rentDurationField).click();
        driver.findElement(rentDurationFieldDropdown).click();
    }

    //Выбор цвета самоката
    public void setColour (String colour){
        driver. findElement(By.cssSelector(colour)).click();
    }

    //Нажатие на кнопку "Заказать"
    public void confirmOrderButtonClick(){
        driver.findElement(confirmOrderButton).click();
    }

    //Нажатие на кнопку подтверждения заказа
    public void yesOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(yesOrderButton));
        driver.findElement(yesOrderButton).click();
    }

    //Получение текста заголовка с попапа
    public String getPopupTitle(){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.textToBePresentInElementLocated(popupTitle, Constants.ORDER_CONFIRMED));
        return driver.findElement(popupTitle).getText();
    }


}
