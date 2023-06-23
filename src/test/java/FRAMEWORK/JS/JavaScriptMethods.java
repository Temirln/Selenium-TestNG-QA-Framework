package FRAMEWORK.JS;

import FRAMEWORK.UTILS.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import PATTERNS.SingletonPatternDriver;

public class JavaScriptMethods {
    private final JavascriptExecutor js ;
    
    public JavaScriptMethods() {
        this.js = (JavascriptExecutor) DriverUtils.getDriver();
    }

    public void scrollToTheElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    
    public void clickElement(WebElement element){
        js.executeScript("arguments[0].click();",element);
    }

}
