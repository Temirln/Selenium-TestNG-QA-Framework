package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.LabelElement;
import org.openqa.selenium.By;

public class ParentFrame extends BaseForm {
    
    private final By body = By.xpath("//body");
    private final LabelElement bodyLabel = new LabelElement(body,"Label in Body");
    
    public ParentFrame() {
        super(By.xpath("//iframe[@id='frame1']"), "Parent Frame");
    }
    
    public String getBodyLabel(){
        return bodyLabel.getElementText();
    }
    
    
}
