package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.UTILS.DriverUtils;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    
    private final By frame1 = By.xpath("//iframe[@id='frame1']");
    private final By frame2 = By.xpath("//iframe[@id='frame2']");
    
    public FramesPage() {
        super(By.xpath("//div[@id='framesWrapper']"), "Frames Page");
    }
    
    public Boolean checkMessages(){
        DriverUtils.switchIframeByLocator(frame1);
        
        UpperFrame upperFrame = new UpperFrame();
        
        String upperMessage = upperFrame.getBodyLabel();

        DriverUtils.switchToParentFrame();
        DriverUtils.switchIframeByLocator(frame2);
        
        LowerFrame lowerFrame = new LowerFrame();
        String lowerMessage = lowerFrame.getBodyLabel();
    
        DriverUtils.switchToParentFrame();
        
        return lowerMessage.equals(upperMessage);
    }
    
}
