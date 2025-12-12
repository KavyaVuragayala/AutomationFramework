package com.kavya.tests.restfulbooker.crud;

import com.kavya.base.BaseTest;
import com.kavya.endpoints.APIConstants;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg" , priority = 1)
    public void test_verifyTokenPOST(){


        // Automatically have the base URL set and the header set.
        // This URL as well as the header of application JSON is automatically
        // set when you start using extends from BaseTest.

        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();


        // Extraction ( JSON String response to Java Object)
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);


        // Validation of the request.
        assertActions.verifyStringKeyNotNull(token);

    }

    @Test
    public void testTokenPOST_Negative() {


        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification)
                .when()
                .body("{}").post();


        // Extraction ( JSON String response to Java Object)
        String invalid_reason = payloadManager.getInvalidResponse(response.asString());
        System.out.println(invalid_reason);


        // Validation of the request.
        assertActions.verifyStringKey(invalid_reason,"Bad credentials");




    }

}
