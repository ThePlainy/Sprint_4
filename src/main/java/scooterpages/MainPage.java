package scooterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Заказать на главной странице
    private By mainOrderButton = By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");
    //Кнопка Заказать в хедере
    private By headerOrderButton = By.cssSelector("#root > div > div.Home_HomePage__ZXKIX > div.Header_Header__214zg > div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    //Нажатие на кнопку заказать на главной странице

    public void orderButtonClick(String startButton){
        if (startButton.equals(Constants.STARTING_HEADER)){driver.findElement(headerOrderButton).click();}
        else if (startButton.equals(Constants.STARTING_MAIN_PAGE)){
            WebElement element = driver.findElement(mainOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mainOrderButton));
            driver.findElement(mainOrderButton).click();
    }}
}
