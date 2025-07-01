package testngDemo;

import org.testng.annotations.Test;

public class DataProviderDemo {

    @Test
    public void login(String un,String password){
        System.out.println(un+"  "+password);

    }
}
