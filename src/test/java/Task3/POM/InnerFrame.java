package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.LabelElement;
import org.openqa.selenium.By;

public class InnerFrame extends BaseForm {
    
    private final By body = By.xpath("//body");
    private final LabelElement bodyLabel = new LabelElement(body,"Label in Body");
    
    
    public InnerFrame() {
        super(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"), "Inner Frame");
    }
    
    public String getBodyLabel(){
        return bodyLabel.getElementText();
    }
    
}
