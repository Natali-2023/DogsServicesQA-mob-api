package org.ait.dogservices.mobtests;

import org.ait.dogservices.mob.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

public class TestBaseMob {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBaseMob.class);

    @BeforeMethod

    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start test "+ m.getName()+ " with data: "+ Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: "+ result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: "+result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.error("*********************************************");
    }
}
