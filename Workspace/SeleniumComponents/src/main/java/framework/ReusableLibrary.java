package framework;

import org.openqa.selenium.WebDriver;

public class ReusableLibrary {

    public static ThreadLocal<TestUtil> testUtilsThred = new ThreadLocal<>();

    protected TestUtil testUtils = testUtilsThred.get();
    protected WebDriver driver = testUtils.getDriver();
    protected ExcelUtils excelUtils = testUtils.getExcelUtils();
    protected SeleniumUtils seleniumUtils = testUtils.getSeleniumUtils();
    protected JavaScriptUtils javaScriptUtils = testUtils.getJavaScriptUtils();
    protected PropertiesUtil propertiesUtil = testUtils.getPropertiesUtil();
    protected ElementsUtils elementsUtils = testUtils.getElementsUtils();
    protected Reports reports = testUtils.getReports();
}
