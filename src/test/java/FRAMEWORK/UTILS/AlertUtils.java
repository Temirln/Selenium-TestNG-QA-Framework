package FRAMEWORK.UTILS;

import org.openqa.selenium.NoAlertPresentException;

public class AlertUtils {
    
    public static void acceptAlert(){
        LoggerUtils.infoLog("Alert Accepted");
        DriverUtils.getDriver().switchTo().alert().accept();
    }
    
    public static void sendKeysALert(String name){
        LoggerUtils.infoLog("Sended key "+name+" to");
        DriverUtils.getDriver().switchTo().alert().sendKeys(name);
    }
    
    public static String getAlertText(){
        return DriverUtils.getDriver().switchTo().alert().getText();
    }
    
    public static boolean isAlertPresent(){
        try {
            DriverUtils.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
    
}
