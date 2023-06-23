package FRAMEWORK.BASE;

import FRAMEWORK.UTILS.ConfigFileReader;
import FRAMEWORK.UTILS.DriverUtils;
import FRAMEWORK.UTILS.LoggerUtils;
import FRAMEWORK.UTILS.WaitUtils;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startup(){
        LoggerUtils.infoLog("##################### Test Started #######################");
        ConfigFileReader.initConfig();
        
        DriverUtils.initDriver(ConfigFileReader.getProperty("browser"));
        WaitUtils.setWait();
        LoggerUtils.infoLog(String.valueOf(DriverUtils.getDriver()));
        DriverUtils.goToUrl(ConfigFileReader.getProperty("url"));
        DriverUtils.maximizeWindow();
        
    }
    
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        DriverUtils.quitDriver();
        LoggerUtils.infoLog("##################### Test Finished ######################");
    }
}
