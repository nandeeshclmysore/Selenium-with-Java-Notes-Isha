package testngDemo;

import org.testng.annotations.Test;

public class GroupsDemo {

    @Test(groups = "smoke")
    public void test1() {
        System.out.println("Test 1 -Smoke");
    }

    @Test(groups = "sanity")
    public void test2() {
        System.out.println("Test 2 -Sanity");
    }

    @Test(groups = {"regression", "smoke"})
    public void test3() {
        System.out.println("Test 3 -Regression and Smoke");
    }

    @Test(groups = "regression")
    public void test4() {
        System.out.println("Test 4 -Regression");
    }
}
