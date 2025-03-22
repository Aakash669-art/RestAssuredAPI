package APITestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITestNG01 {

    public void test_post_request(){


    }
    @BeforeTest
    public void before_Test(){

        System.out.println("Before test");
    }
    @Test(priority = 2)
    public void test(){

        System.out.println("test");
    }
    @Test(priority = 1)

    public  void test2(){

        System.out.println("test2");
    }
    @Test(dependsOnMethods = "test")
    public  void depend(){
        System.out.println("print depend");
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void Enabled (){
        Assert.assertTrue(true);
    }
    @Test(alwaysRun = true , enabled = false)
    public  void alwaysRun(){

        Assert.assertTrue(true);
    }
    @Test(invocationCount = 100)

    public void count (){
        Assert.assertTrue(true);
    }

}
