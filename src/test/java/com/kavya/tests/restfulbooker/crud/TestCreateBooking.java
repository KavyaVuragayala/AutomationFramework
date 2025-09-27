package com.kavya.tests.restfulbooker.crud;

import com.kavya.base.BaseTest;
import com.kavya.endpoints.APIConstants;
import com.kavya.pojos.responsePOJO.restfulbooker.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {


    @Test(groups = "reg", priority = 1)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingPOST_Positive() {

        // Setup will first and making the request - Part - 1
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .log().all().post();

        //Extraction Part - 2
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingId());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Alexa");


    }


    @Test(groups = "reg", priority = 1)
    @Description("TC#2 - Verify that the Booking can't be Created, When Payload is null")
    public void testCreateBookingPOST_Negative() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().
                body("{}").log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);


    }

    @Test(groups = "reg", priority = 1)

    @Description("TC#3 - Verify that the Booking can be Created, When Payload is CHINESE")
    public void testCreateBookingPOST_POSITIVE_CHINESE() {


        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.createPayloadBookingAsWrongBody())
                .log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Extraction Part - 2
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingId());


    }

    @Test(groups = "reg", priority = 1)
    @Description("TC#4 - Verify that the Booking can be Created, When Payload is RANDOM")
    public void testCreateBookingPOST_POSITIVE_FAKER_RANDOM_DATA() {
        // Setup and Making a Request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingId());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());
    }



    @Test(groups = "reg", priority = 1)
    @Description("TC#5 - Verify that the Booking can be Created, URL is wrong")
    public void testCreateBookingPOST_NEGATIVE_BASE_URL_Header() {
        // Setup and Making a Request.
        requestSpecification.baseUri(APIConstants.APP_VWO_URL);
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.contentType(ContentType.HTML);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }

}