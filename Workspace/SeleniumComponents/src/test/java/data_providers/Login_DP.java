package data_providers;

import framework.ExcelUtils;
import framework.PathUtils;
import framework.ReusableLibrary;
import framework.constants.AppConstants;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class Login_DP extends ReusableLibrary {

    //Data provider to provide data for login fucntionality
    @DataProvider(name = "loginDataProvider")
    public Object[][] getTestDataFromExcel() {
        String path = PathUtils.getTestDataFolder() + "\\"+ AppConstants.loginTestData;


        String sheetName = "Login_Cred";
        String filterKey = "RunMode";
        String filterValue = "Y";

        List<Map<String, String>> excelData = ExcelUtils.readExcelAsMap(path, sheetName, filterKey, filterValue);

        Object[][] testData = new Object[excelData.size()][1];
        for (int i = 0; i < excelData.size(); i++) {
            testData[i][0] = excelData.get(i); // each test gets a Map<String, String>
        }
        return testData;
    }


}
