package Task3.TESTS;

import FRAMEWORK.BASE.BaseTest;
import FRAMEWORK.UTILS.AlertUtils;
import FRAMEWORK.UTILS.DataProvider;
import FRAMEWORK.UTILS.DriverUtils;
import FRAMEWORK.UTILS.LoggerUtils;
import Task3.MODELS.UserTable;
import Task3.POM.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class DemoqaTest extends BaseTest {
    
    @Test(priority = 1)
    public void alerts(){
        
        LoggerUtils.infoLog("ALERTS TEST");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpened(),"This is not Main Page Demoqa");

        mainPage.clickAlertFrameWindows();

        AlertWindowsPage alertWindowsPage = new AlertWindowsPage();

        alertWindowsPage.clickAlert();
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isOpened(),"The form did not appear on the page");


        alertsPage.clickAlertButton();
        Assert.assertEquals(AlertUtils.getAlertText(),"You clicked a button","Alert text doesn't match with expected value");
    
        AlertUtils.acceptAlert();
        Assert.assertFalse(AlertUtils.isAlertPresent(),"Alert Popup is present should be closed");

        alertsPage.clickAlertConfirmButton();
        Assert.assertEquals(AlertUtils.getAlertText(),"Do you confirm action?","Alert text doesn't match with expected value");
    
        AlertUtils.acceptAlert();
        Assert.assertFalse(AlertUtils.isAlertPresent(),"Alert Popup is present should be closed");
        Assert.assertEquals(alertsPage.getConfirmResult(),"You selected Ok","Confirm result doesn't match");

        alertsPage.clickPropmtBox();
        Assert.assertEquals(AlertUtils.getAlertText(),"Please enter your name","Alert text doesn't match with expected value");

        AlertUtils.sendKeysALert("Temirlan");
        AlertUtils.acceptAlert();
        Assert.assertFalse(AlertUtils.isAlertPresent(),"Alert Popup is present should be closed");
        Assert.assertEquals(alertsPage.getPromptboxResult(),"Temirlan","Appeared text should be equal to the one entered before");
    }
    
    @Test(priority = 2)
    public void iframe(){
        
        LoggerUtils.infoLog("IFRAME TEST");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpened(),"This is not Main Page Demoqa");
        mainPage.clickAlertFrameWindows();
        AlertWindowsPage alertWindowsPage = new AlertWindowsPage();
        alertWindowsPage.clickNested();
        NestedFramesPage nest = new NestedFramesPage();
        Assert.assertTrue(nest.isOpened(),"This is not Nested Frames Page");


        Assert.assertTrue(nest.checkMessagesPresent(),"There are no messages in this page");

        nest.clickFramesButton();

        FramesPage framesPage = new FramesPage();

        Assert.assertTrue(framesPage.isOpened(),"This is not Frames Page");

        Assert.assertTrue(framesPage.checkMessages(),"Messages not equal");

    }

    @Test(dataProvider = "TablesData",dataProviderClass = DataProvider.class ,priority = 3)
    public void tables(String firsname,String salary,String department,String email,String  age,String lastname) throws InterruptedException {
        
        LoggerUtils.infoLog("TABLES TEST");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpened(),"This is not Main Page Demoqa");

        mainPage.clickElements();

        ElementsPage elementsPage = new ElementsPage();
        elementsPage.clickWebTables();

        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isOpened(),"Web Tables form did not open");

        webTablesPage.clickAddButton();
        Assert.assertTrue(webTablesPage.checkFormAppeared(),"Registration form did not appeared");

        UserTable userNo = new UserTable(firsname,lastname,age,email,salary,department);
        webTablesPage.fillRegistrationFormAndSubmit(firsname,lastname,email,age,salary,department);
        Assert.assertFalse(webTablesPage.checkFormAppeared(),"Registration form should closed after sumbission");

        List<UserTable> usersRow = webTablesPage.getAllUsers();

        int records = usersRow.size();
        Assert.assertTrue(usersRow.contains(userNo),"Table doesn't contain User");
        webTablesPage.deleteUser(userNo);
        Assert.assertEquals(webTablesPage.getAllUsers().size(), records - 1, "Records doesn't changed");
        Assert.assertFalse(webTablesPage.getAllUsers().contains(userNo),"Table should not contain UserNo");

    }

    @Test(priority = 4)
    public void handles(){
        
        LoggerUtils.infoLog("HANDLES TEST");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpened(),"This is not Main Page Demoqa");
        mainPage.clickAlertFrameWindows();

        AlertWindowsPage alertWindowsPage = new AlertWindowsPage();
        alertWindowsPage.clickBrowserWindows();

        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();

        Assert.assertTrue(browserWindowsPage.isOpened(),"This is not Browser Windows Page");

        browserWindowsPage.clickNewTabButton();
        String window = DriverUtils.getWindowHandle();

        ArrayList<String> tabs = new ArrayList<>(DriverUtils.getWindowHandles());

        DriverUtils.switchToTab(tabs.get(1));

        Assert.assertNotEquals(window,DriverUtils.getWindowHandle());

        DriverUtils.closeDriver();
        DriverUtils.switchToTab(window);

        Assert.assertTrue(browserWindowsPage.isOpened(),"This is not Browser Windows Page");

        browserWindowsPage.clickLinks();

        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isOpened(),"This is not Links Page");

        linksPage.clickHomeLink();

        ArrayList<String> tabs1 = new ArrayList<>(DriverUtils.getWindowHandles());
        DriverUtils.switchToTab(tabs1.get(1));

        Assert.assertTrue(mainPage.isOpened(),"Opened Tab not Main Page");
        DriverUtils.switchToTab(tabs1.get(0));
        Assert.assertTrue(linksPage.isOpened(),"This is not Links Page");


    }
}
