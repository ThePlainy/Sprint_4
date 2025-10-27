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
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Заказать на главной странице
    private final By mainOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']") ;
    //Кнопка Заказать в хедере
    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    //выпадающее меню FaQ
    private final By faqAccordion = By.cssSelector(".Home_FAQ__3uVm4");

    //Скролл до FAQ
    public void faqScroll(){
        WebElement element = driver.findElement(faqAccordion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(faqAccordion));
    }

    //Клик по элементу FAQ
    public void faqClick(String questionInQuestion){
        String question = ".//*[text()='"+questionInQuestion+"']";
        driver.findElement(By.xpath(question)).click();
    }

    //Сверка ответа на FAQ
    public String getFAQAnswer(){
        String questionId = driver.findElement(By.cssSelector("div[aria-expanded = 'true']")).getAttribute("id");
        String answerIdSelector = "#accordion__panel-"+questionId.substring(19);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(answerIdSelector)));
        return driver.findElement(By.cssSelector(answerIdSelector)).getText();
    }

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
