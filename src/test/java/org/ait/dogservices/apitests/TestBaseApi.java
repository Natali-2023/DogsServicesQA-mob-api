package org.ait.dogservices.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ait.dogservices.mob.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;



public class TestBaseApi {
    Logger logger = LoggerFactory.getLogger(TestBaseApi.class);


    @BeforeMethod
    public  void init() {   // precondition
        System.err.close();

        RestAssured.baseURI = "https://hunde24.online/";
        RestAssured.basePath = "api";
    }
        @BeforeMethod
        public void startTest(Method m, Object[] p){
            logger.info("Start test "+ m.getName()+ " with data: "+ Arrays.asList(p));

    }
    public static Response login() {
        String username = "nat@mail.com";
        String password = "Qwerty8888!";


        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");
        return authResponse;
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
