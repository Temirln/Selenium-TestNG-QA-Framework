package FRAMEWORK.UTILS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private static WebDriverWait wait;
    
    public static void setWait(){
        wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(Long.parseLong(ConfigFileReader.getProperty("explicitlyWait"))));
    }
    
    
    public static List<WebElement> presenseAllElementsLocated(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    
    public static WebElement presenceElementLocated(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement toBeClicable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static WebElement visibilityElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    
    
    
    
}
