package samokatpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;


public class OrderPage {
    private WebDriver driver;

    //Поле имя
    private By nameField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(1) > input");

    //Поле фамилия
    private By surnameField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(2) > input");

    //Поле адреса
    private By addressField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(3) > input");

    //Поле выбора станции метро
    private By metroField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(4) > div > div > input");
    //#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(4) > div > div > div.select-search__select

    //Поле телефона
    private By phoneNumberField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(5) > input");

    //Кнопка Далее
    private By nextButtonFirstForm = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_NextButton__1_rCA > button");

    //Поле дня доставки
    private By deliveryDateField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Order_MixedDatePicker__3qiay > div.react-datepicker-wrapper > div > input");

    //Поле срока аренды и его дроп
    private By rentDurationField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root");

    //Чекбокс цвета самоката
    //private final String colour;
    //private By productColour = By.cssSelector(colour);

    //Кнопка Заказать
    private By confirmOrderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");

    //Кнопка Да попапа подтверждения
    private By yesOrderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");

    //Плашка "Заказ оформлен"
    private By orderConfirmation = By.cssSelector(".Order_ModalHeader__3FDaJ");

    //Ввод имени
    public void setName (String name){
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
        driver.findElement(By.xpath(".//*[text()='Черкизовская']")).click();
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
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }

    //Ввод срока аренды
    public void setDuration (int dropdownChoiceNumber){
        String dropdownChoice = "#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root.is-open > div.Dropdown-menu > div:nth-child("+dropdownChoiceNumber+")0";
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

    //Проверка успешного заказа
    public void checkOrderConfirmation(){
        Assert.assertTrue((driver.findElement(orderConfirmation)).isDisplayed());
    }


}
