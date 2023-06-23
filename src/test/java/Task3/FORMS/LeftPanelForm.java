package Task3.FORMS;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.ButtonElement;
import FRAMEWORK.UTILS.DriverUtils;
import org.openqa.selenium.By;

public class LeftPanelForm extends BaseForm {
    
    private final By alertsFrameWindowsMenu = By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]");
    private final ButtonElement alertsFrameWindowsMenuButton = new ButtonElement(alertsFrameWindowsMenu,"Alerts, Frame & Windows Button");
    
    private final By browserWindows = By.xpath(".//span[normalize-space()='Browser Windows']");
    private final ButtonElement browserWindowsButton = new ButtonElement(browserWindows,"Browser Windows Button");
    
    private final By alertMenu = By.xpath(".//span[normalize-space()='Alerts']");
    private final ButtonElement alertMenuButton = new ButtonElement(alertMenu,"Alert Menu Button");
    
    private final By frames = By.xpath("//span[normalize-space()='Frames']");
    private final ButtonElement framesButton = new ButtonElement(frames,"Frames Button");
    
    private final By nestedFrames = By.xpath(".//span[normalize-space()='Nested Frames']");
    private final ButtonElement nestedFrameButton = new ButtonElement(nestedFrames,"Nested Frames Button");
    
    
    
    private final By elementsMenu = By.xpath(".//div[contains(text(),'Elements')]");
    private final ButtonElement elementsMenuButton = new ButtonElement(elementsMenu,"Elements Menu Button");
    
    private final By webTables = By.xpath("//span[normalize-space()='Web Tables']");
    private final ButtonElement webTablesButton = new ButtonElement(webTables,"Web Tables Button");
    
    private final By linksMenu = By.xpath(".//span[normalize-space()='Links']");
    private final ButtonElement linksMenuButton = new ButtonElement(linksMenu,"Menu Links Button");
    
    private final By collapsedList = By.xpath("//div[div[contains(@class, 'element-list collapse show')]]//span[contains(@class, 'group-header')]");
    private final ButtonElement collapsedListButton = new ButtonElement(collapsedList,"Collapsed List");
    
    public LeftPanelForm() {
        super(By.xpath("//div[@class='left-pannel']"), "Left Panel Form");
    }
    
    public void clickAlertsFramesWindows(){
        alertsFrameWindowsMenuButton.scrollToTheElement();
        alertsFrameWindowsMenuButton.waitClick();
    }
    
    public void clickAlertMenu(){
        alertMenuButton.clickViaJs();
    }
    
    public void clickFramesMenu(){
        framesButton.clickViaJs();
    }
    
    public void clickNestedMenu(){
        nestedFrameButton.clickViaJs();
    }
    
    public void clickBrowserWindows(){
        browserWindowsButton.clickViaJs();
    }
    
    public void clickLinksButtonMenu(){
        closeCollapsed();
        elementsMenuButton.clickViaJs();
        linksMenuButton.clickViaJs();
    }
    
    public void clickWebTablesButton(){
        webTablesButton.clickViaJs();
    }
    
    
    public void closeCollapsed(){
        if (DriverUtils.getDriver().findElements(collapsedList).size()>0) {
            collapsedListButton.clickViaJs();
        }
    }
    
    
}
