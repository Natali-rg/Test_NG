package driverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverFactory {
    public static WebDriver getDriver(BROWSER brows) {
        WebDriver driver=null;
        switch (brows) {
            case CHROME:
                driver = initChrome();
                break;
            case LOGWITHOPTIONS:
                driver=inichroWithLogOptions();
        }
        return driver;
    }

    private static WebDriver inichroWithLogOptions() {
        LoggingPreferences prefs=new LoggingPreferences();
        prefs.enable(LogType.BROWSER, Level.WARNING);
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, prefs);
        ChromeOptions options=new ChromeOptions();
        options.merge(capabilities);
        return new ChromeDriver(options);
    }


    private static WebDriver initChrome() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");//открывает хром в режиме инкогнито
        //options.addArguments("--headless");//выполняет код без открытия браузера
        options.addArguments("--start-maximized");//открывает хром в полноекранном режиме
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
