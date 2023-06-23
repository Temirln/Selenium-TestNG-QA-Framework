package FRAMEWORK.BASE;

import FRAMEWORK.UTILS.DriverUtils;
import org.openqa.selenium.By;

public class BaseForm {
    
    private final By locator;
    private final String formName;
    
    public BaseForm(By locator, String formName){
        this.locator = locator;
        this.formName = formName;
    }
    
    public boolean isOpened(){
        return DriverUtils.getDriver().findElements(locator).size()>0;
    }

    
}
