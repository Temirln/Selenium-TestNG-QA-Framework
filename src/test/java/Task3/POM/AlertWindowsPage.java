package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import Task3.FORMS.LeftPanelForm;
import org.openqa.selenium.By;

public class AlertWindowsPage extends BaseForm {
    
    private final LeftPanelForm leftPanelForm = new LeftPanelForm();
    
    public AlertWindowsPage() {
        super(By.xpath("//div[@id='app']"), "Alert Windows Page");
    }
    
    public void clickAlert(){
        leftPanelForm.clickAlertMenu();
    }
    
    public void clickNested(){
        leftPanelForm.clickNestedMenu();
    }
    
    public void clickBrowserWindows(){
        leftPanelForm.clickBrowserWindows();
    }

}
