package framework;

import lombok.Data;
import org.openqa.selenium.WebDriver;

//To maintain all framework related objects
@Data //Creates Getter and Setter methods
public class TestUtil {

    private WebDriver driver;
    private ExcelUtils excelUtils;
    private SeleniumUtils seleniumUtils;
    private JavaScriptUtils javaScriptUtils;
    private PropertiesUtil propertiesUtil;
    private ElementsUtils elementsUtils;
    private Reports reports;


}
