package FRAMEWORK.BASE;

import FRAMEWORK.UTILS.DriverUtils;
import FRAMEWORK.UTILS.LoggerUtils;
import FRAMEWORK.UTILS.WaitUtils;
import FRAMEWORK.JS.JavaScriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BaseElement {
    
    private final By locator;
    private final String name;
    
    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }
    
    public void waitClick(){
        WaitUtils.toBeClicable(locator).click();
        LoggerUtils.infoLog(name+" clicked");
    }
    
    public WebElement getElement(){
        return WaitUtils.presenceElementLocated(locator);
    }
    
    public String getElementText(){
        return WaitUtils.presenceElementLocated(locator).getText();
    }
    
    public List<WebElement> getElements(){
        return WaitUtils.presenseAllElementsLocated(locator);
    }
    
    public By getLocator(){
        return locator;
    }
    
    public String getName(){
        return name;
    }
    
    public void clickViaJs(){
        WebElement element = getElement();
        JavaScriptMethods js = new JavaScriptMethods();
        js.clickElement(element);
        LoggerUtils.infoLog("Clicked Via JS "+name);
    }
    
    public void scrollViaJs(){
        WebElement element = getElement();
        JavaScriptMethods js = new JavaScriptMethods();
        js.scrollToTheElement(element);
        LoggerUtils.infoLog("Scrolled Via JS "+name);
    }
    
    public void scrollToTheElement(){
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(getElement()).build().perform();
        LoggerUtils.infoLog("Scrolled to the "+name);
    }
    
    
    
}
