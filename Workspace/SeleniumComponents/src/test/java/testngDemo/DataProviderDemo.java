package testngDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    //2D Object array
    @Test(description = "Sample DP", dataProvider = "logintestdata", priority = 1)
    public void login(String un,String password){
        System.out.println(un+"  "+password);

    }

    @DataProvider(name = "logintestdata")
    public Object[][] loginTestData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "appu";
        data[0][1] = "appu123";

        data[1][0] = "raghu";
        data[1][1] = "raghu123";

        return data;

    }


    //1D Object array
    @Test(description = "Sample DP", dataProvider = "urltestdata", priority = 2)
    public void url(String url) {
        System.out.println(url);

    }

    @DataProvider(name = "urltestdata")
    public Object[] urlTestData() {
        Object[] data = new Object[3];

        data[0] = "URL1";
        data[1] = "URL2";
        data[2] = "URL3";

        return data;
    }


}
