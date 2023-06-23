package FRAMEWORK.UTILS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Set;

public class DriverUtils {
    private static WebDriver driver;
    
    
    public static void initDriver(String browser){
        if (driver == null){
            switch (browser) {
                case "firefox" -> {
                    LoggerUtils.infoLog("Firefox Browser choosen");
                    WebDriverManager.firefoxdriver().setup();
                    
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments(ConfigFileReader.getProperty("firefoxIncognito"));
                    driver = new FirefoxDriver(options);
                    LoggerUtils.infoLog("Driver Created");
                }
                case "chrome" -> {
                    LoggerUtils.infoLog("Chrome Browser choosen");
                    WebDriverManager.chromedriver().setup();
            
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(ConfigFileReader.getProperty("chromeIncognito"));
                    driver = new ChromeDriver(options);
                    LoggerUtils.infoLog("Driver Created");
                }
                case "edge" -> {
                    LoggerUtils.infoLog("Microsoft Edge Browser Choosen");
                    WebDriverManager.edgedriver().setup();
                    
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments(ConfigFileReader.getProperty("edgeIncognito"));
                    driver = new EdgeDriver(options);
                    LoggerUtils.infoLog("Driver Created");
                }
                default -> {
                    LoggerUtils.warnLog("Invalid Browser Name");
                    throw new RuntimeException("Invalid Browser Name");
                }
            }
        }
    }
    
    public static WebDriver getDriver(){
        return driver;
    }
    
    public static void quitDriver(){
        LoggerUtils.infoLog("Driver Quitted");
        driver.quit();
        driver = null;
    }
    
    public static void closeDriver(){
        LoggerUtils.infoLog("Driver Closed");
        driver.close();
    }
    
    public static void goToUrl(String url){
        LoggerUtils.infoLog("Go To Url "+url);
        driver.get(url);
    }
    
    public static void maximizeWindow(){
        LoggerUtils.infoLog("Driver maximized Window");
        driver.manage().window().maximize();
    }
    
    public static void switchIframeByElement(WebElement element){
        LoggerUtils.infoLog("Switched Iframe");
        driver.switchTo().frame(element);
    }
    
    public static void switchIframeByLocator(By locator){
        LoggerUtils.infoLog("Switched Iframe");
        driver.switchTo().frame(WaitUtils.visibilityElement(locator));
    }
    
    public static void switchMainFrame(){
        LoggerUtils.infoLog("Switched to Main Iframe");
        driver.switchTo().defaultContent();
    }
    
    public static void switchToParentFrame(){
        LoggerUtils.infoLog("Switched To Parent Iframe");
        driver.switchTo().parentFrame();
    }
    
    public static String getWindowHandle(){
        return driver.getWindowHandle();
    }
    
    public static Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
    
    public static void switchToNewWindow(){
        LoggerUtils.infoLog("Switched to new Window");
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
    
    public static void switchToTab(String handle){
        LoggerUtils.infoLog("Switched to Table "+handle);
        driver.switchTo().window(handle);
    }
    
}
