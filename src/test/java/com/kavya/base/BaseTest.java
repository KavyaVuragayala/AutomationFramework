package com.kavya.base;

import com.kavya.asserts.AssertActions;
import com.kavya.endpoints.APIConstants;
import com.kavya.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    // this is used for the repeated data that is used or common to all testcases
    //   // Base URL, Content Type - json - common

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;

    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;   // used for extraction

    @BeforeTest
    public void setup() {
        System.out.println("Starting the test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.CREATE_UPDATE_BOOKING_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }

    @AfterTest
    public void tearDown(){
        System.out.println("End of the test");
    }
}
