package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.ButtonElement;
import FRAMEWORK.ELEMENTS.LabelElement;
import org.openqa.selenium.By;


public class AlertsPage extends BaseForm {
    
    private final By alert = By.xpath("//button[@id='alertButton']");
    private final ButtonElement alertButton = new ButtonElement(alert,"Alert Button");
    
    private final By alertConfirm = By.xpath("//button[@id='confirmButton']");
    private final ButtonElement alertConfirmButton = new ButtonElement(alertConfirm,"Alert Confirm Button");
    
    private final By confirmResult = By.xpath("//span[@id='confirmResult']");
    private final LabelElement confirmResultLabel = new LabelElement(confirmResult,"Confirm Result Label");
    
    
    private final By promptBox = By.xpath("//button[@id='promtButton']");
    private final ButtonElement promptBoxButton = new ButtonElement(promptBox,"Prompt Box Button");
    
    private final By promptBoxResult = By.xpath("//span[@id='promptResult']");
    private final LabelElement promptBoxLabel = new LabelElement(promptBoxResult,"Prompt Box Result Label");
    
    
    public AlertsPage() {
        super(By.xpath("//div[@id='javascriptAlertsWrapper']"), "Alerts Page");
    }
    
    
    public void clickAlertButton(){
        alertButton.waitClick();
    }
    
    public void clickAlertConfirmButton(){
        alertConfirmButton.waitClick();
    }
    
    public String getConfirmResult(){
        return confirmResultLabel.getElementText();
    }
    
    public void clickPropmtBox(){
        promptBoxButton.clickViaJs();
    }
    
    public String getPromptboxResult(){
        return promptBoxLabel.getElementText().split(" ")[2];
    }
    
}
