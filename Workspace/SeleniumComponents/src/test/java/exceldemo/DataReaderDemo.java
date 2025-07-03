package exceldemo;

import framework.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DataReaderDemo {

    @DataProvider(name = "excelData")
    public Object[][] getTestDataFromExcel() {
        String path = "C:\\Users\\003J72744\\Desktop\\TestingAcademyAT\\SeleniumIsha\\JavaSeleniumNotes\\Workspace\\SeleniumComponents\\src\\test\\java\\exceldemo\\LoginData.xlsx";
        String sheetName = "Sheet1";
        String filterKey = "RunMode";
        String filterValue = "Y";

        List<Map<String, String>> excelData = ExcelUtils.readExcelAsMap(path, sheetName, filterKey, filterValue);

        Object[][] testData = new Object[excelData.size()][1];
        for (int i = 0; i < excelData.size(); i++) {
            testData[i][0] = excelData.get(i); // each test gets a Map<String, String>
        }
        return testData;
    }

    @Test(dataProvider = "excelData")
    public void loginTest(Map<String, String> data) {
        System.out.println("Username: " + data.get("Username"));
        System.out.println("Password: " + data.get("Password"));
        System.out.println("Role: " + data.get("Role"));
        System.out.println("***********************************************");
        // Here you can call Selenium code to fill login form using data.get("Username") etc.
    }

}
