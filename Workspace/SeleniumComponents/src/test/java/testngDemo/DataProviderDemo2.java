package testngDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class DataProviderDemo2 {

    //Iterator<Object>
    @Test(description = "Sample DP", dataProvider = "usernames", priority = 1)
    public void login(String un){
        System.out.println(un);

    }

    @DataProvider(name = "usernames")
    public Iterator<String> loginTestData() {
        List list=new ArrayList<String>();

        list.add("appu1");
        list.add("appu2");
        list.add("appu3");


        return list.iterator();

    }

}
