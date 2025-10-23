package samokatpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    //Кнопка Заказать на главной странице
    private By orderButton = By.cssSelector("#root > div > div.Home_HomePage__ZXKIX > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");

    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }
}
