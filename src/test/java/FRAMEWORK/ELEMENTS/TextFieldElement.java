package FRAMEWORK.ELEMENTS;

import FRAMEWORK.BASE.BaseElement;
import FRAMEWORK.UTILS.LoggerUtils;
import FRAMEWORK.UTILS.WaitUtils;
import org.openqa.selenium.By;

public class TextFieldElement extends BaseElement {
    
    public TextFieldElement(By locator, String name) {
        super(locator, name);
    }
    
    public void waitSend(String value){
        LoggerUtils.infoLog("Value:"+value+" sended to "+this.getName());
        WaitUtils.toBeClicable(this.getLocator()).sendKeys(value);
    }
}
