package scooterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Легаси класс, на случай новых тестов
public class Header {
    private WebDriver driver;
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Заказать в хедере
    private By orderButton = By.cssSelector("#root > div > div.Home_HomePage__ZXKIX > div.Header_Header__214zg > div.Header_Nav__AGCXC > button.Button_Button__ra12g");

    //Нажатие на кнопку заказать
    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }
}
