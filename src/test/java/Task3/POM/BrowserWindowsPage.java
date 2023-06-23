package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.ButtonElement;
import Task3.FORMS.LeftPanelForm;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {

    private final By newTab = By.xpath("//button[@id='tabButton']");
    private final ButtonElement newTabButton = new ButtonElement(newTab,"New Tab");
    
    public BrowserWindowsPage() {
        super(By.xpath("//div[@id='browserWindows']"), "Browser Windows Page");
    }
    
    public void clickNewTabButton(){
        newTabButton.waitClick();
    }
    
    public void clickLinks(){
        LeftPanelForm leftPanelForm = new LeftPanelForm();
        leftPanelForm.clickLinksButtonMenu();
    }

    
}
