package scooterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.Constants;

public class DriverFactory {

    public WebDriver driverForSpecificBrowser(String browser){
        if (browser.equals(Constants.CHROME)) {return new ChromeDriver();}
        if (browser.equals(Constants.FIREFOX)) {return new FirefoxDriver();}
        return null;
    }
}
