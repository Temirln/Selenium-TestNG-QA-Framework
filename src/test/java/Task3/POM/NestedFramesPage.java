package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import Task3.FORMS.LeftPanelForm;
import FRAMEWORK.UTILS.DriverUtils;
import FRAMEWORK.UTILS.WaitUtils;
import org.openqa.selenium.By;

import java.util.Objects;

public class NestedFramesPage extends BaseForm {
    
    private final By frame1 = By.xpath("//iframe[@id='frame1']");
    private final By frame2 = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");

    
    private final LeftPanelForm leftPanelForm = new LeftPanelForm();
    
    public NestedFramesPage() {
        super(By.xpath("//div[@id='framesWrapper']"), "Nested Frames Page");
    }
    
    public boolean checkMessagesPresent(){
        
        WaitUtils.toBeClicable(frame1);
        
        DriverUtils.switchIframeByLocator(frame1);
        
        ParentFrame parentFrame = new ParentFrame();
        String parent = parentFrame.getBodyLabel();
        DriverUtils.switchIframeByLocator(frame2);
        InnerFrame innerFrame = new InnerFrame();
        String child = innerFrame.getBodyLabel();
        
        DriverUtils.switchMainFrame();
        
        return Objects.equals(parent, "Parent frame") && Objects.equals(child, "Child Iframe");
    }

    public void clickFramesButton(){
        leftPanelForm.clickFramesMenu();
    }
    
}
