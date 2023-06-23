package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.ButtonElement;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    
    private final By alertframewindow = By.xpath("//div[@class='category-cards']//h5[contains(text(),'Alerts, Frame & Windows')]");
    private final ButtonElement alertFrameWindowButton = new ButtonElement(alertframewindow,"Alert Frame Windows Button");
    
    private final By elements = By.xpath("//div[@class='category-cards']//h5[normalize-space()='Elements']");
    private final ButtonElement elementsButton = new ButtonElement(elements,"Elements Button");
    
    
    public MainPage() {
        super(By.xpath("//div[@class='home-content']"), "Main Page");
    }

    public void clickAlertFrameWindows(){
        alertFrameWindowButton.clickViaJs();
    }
    
    public void clickElements(){
        elementsButton.clickViaJs();
    }
    
}
