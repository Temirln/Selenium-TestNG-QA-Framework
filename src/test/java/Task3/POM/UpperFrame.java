package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.LabelElement;
import org.openqa.selenium.By;

public class UpperFrame extends BaseForm {
    
    private final By frameBody = By.xpath("//body");
    private final LabelElement bodyLabel = new LabelElement(frameBody,"Body Label");
    
    public UpperFrame() {
        super(By.xpath("//iframe[@id='frame1']"), "Upper Frame");
    }
    
    public String getBodyLabel(){
        return bodyLabel.getElementText();
    }
    
}
