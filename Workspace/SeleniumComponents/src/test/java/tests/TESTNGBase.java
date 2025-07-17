package tests;

import framework.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TESTNGBase {

    private TestUtil testUtil = new TestUtil();
    private WebDriver driver;
    private SeleniumUtils seleniumUtils;
    private PropertiesUtil propertiesUtil;
    private ExcelUtils excelUtils;



    @BeforeSuite
    public void killExistingBrowsers() {
        BrowserUtils.killExistingBrowsers();
    }

    //Creates Object for all the reference variables declared in TestUtil class
    @BeforeClass
    public void setupFrameworkObject() {
        if (ReusableLibrary.testUtilsThred.get() == null) {

            testUtil.setPropertiesUtil(new PropertiesUtil());
            testUtil.setDriver(BrowserUtils.getDriver(testUtil.getPropertiesUtil().getBrowser()));
            testUtil.setExcelUtils(new ExcelUtils());
            testUtil.setElementsUtils(new ElementsUtils(testUtil.getDriver()));
            testUtil.setSeleniumUtils(new SeleniumUtils(testUtil.getDriver(), testUtil.getElementsUtils()));
            testUtil.setReports(new Reports(testUtil.getDriver()));
            testUtil.setJavaScriptUtils(new JavaScriptUtils(testUtil.getDriver()));

            ReusableLibrary.testUtilsThred.set(testUtil);

        } else {
            testUtil = ReusableLibrary.testUtilsThred.get();
        }

        driver = testUtil.getDriver();
        seleniumUtils = testUtil.getSeleniumUtils();
        propertiesUtil = testUtil.getPropertiesUtil();
        excelUtils=testUtil.getExcelUtils();
    }

    @BeforeMethod
    public void launchApplication() {
        System.out.println("URL: " + propertiesUtil.getURL());
        seleniumUtils.launchApp(propertiesUtil.getURL());
    }

    @AfterMethod
    public void afterExecution(ITestResult iTestResult) {
        System.out.println(iTestResult.getStatus());
        System.out.println(iTestResult.getMethod().getMethodName());
    }

    @AfterClass
    public void endApplication() {
        seleniumUtils.closeBrowser();
    }
}
