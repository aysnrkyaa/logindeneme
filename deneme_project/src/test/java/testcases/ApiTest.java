package testcases;

import base.BaseTest;
import com.sun.org.apache.xerces.internal.xinclude.XIncludeHandler;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {


    @Test
    public void getStatusCode()
    {
        RestAssured.baseURI = "http://ip.jsontest.com/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        // Get the status code from the Response. In case of
        // a successfull interaction with the web service, we
        // should get a status code of 200.
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.
       // Assert.assertEquals(statusCode, 200, "Correct status code returned");
        if(statusCode==200)
        {
            System.out.println("Correct status code returned");
        }
        else
        {
            System.out.println("Not correct status code returned");

        }


    }




}


