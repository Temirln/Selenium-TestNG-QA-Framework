package Task3.POM;

import FRAMEWORK.BASE.BaseForm;
import FRAMEWORK.ELEMENTS.LabelElement;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    
    private final By homeLink = By.xpath("//a[@id='simpleLink']");
    private final LabelElement homelink = new LabelElement(homeLink,"Home Link");
    
    public LinksPage() {
        super(By.xpath("//div[@id='linkWrapper']"), "Links Page");
    }
    
    public void clickHomeLink(){
        homelink.waitClick();
    }
}
