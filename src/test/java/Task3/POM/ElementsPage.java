package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import Task3.FORMS.LeftPanelForm;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {
    
    private final LeftPanelForm leftPanelForm = new LeftPanelForm();
    
    public ElementsPage() {
        super(By.xpath("//div[@id='app']"), "Elements Page");
    }
    
    public void clickWebTables(){
        leftPanelForm.clickWebTablesButton();
    }
    
}
