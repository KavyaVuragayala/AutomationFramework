package com.kavya.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.kavya.pojos.requestPOJO.restfulbooker.Auth;
import com.kavya.pojos.requestPOJO.restfulbooker.Booking;
import com.kavya.pojos.requestPOJO.restfulbooker.BookingDates;
import com.kavya.pojos.responsePOJO.restfulbooker.BookingResponse;
import com.kavya.pojos.responsePOJO.restfulbooker.TokenResponse;

public class PayloadManager {

    // responsibility of POJO is to serialization and deserialization
     Gson gson = new Gson();
     Faker faker = new Faker();


    // Convert the Java Object into the JSON String to use as Payload.
    // Serialization
     public String createPayloadBookingAsString(){

         Booking booking = new Booking();
         booking.setFirstname("Alexa");
         booking.setLastname("Hamela");
         booking.setTotalprice(112);
         booking.setDepositpaid(true);

         BookingDates bookingdates = new BookingDates();
         bookingdates.setCheckinDate("2024-02-01");
         bookingdates.setCheckoutDate("2024-02-05");

         booking.setBookingdates(bookingdates);
         booking.setAdditionalneeds("Breakfast");

         System.out.println(booking);
         return gson.toJson(booking);

         // gson.toJson(Booking) will return
         //        {
//            "firstname" : "LUCKY",
//                "lastname" : "Dutta",
//                "totalprice" : 3000,
//                "depositpaid" : true,
//                "bookingdates" : {
//            "checkin" : "2025-07-22",
//                    "checkout" : "2025-07-27"
//        },
//            "additionalneeds" : "Breakfast"
//        }
     }

     public String createPayloadBookingAsWrongBody(){
         Booking booking = new Booking();
         booking.setFirstname("会意; 會意");
         booking.setLastname("会意; 會意");
         booking.setTotalprice(112);
         booking.setDepositpaid(false);

         BookingDates bookingdates = new BookingDates();
         bookingdates.setCheckinDate("5025-02-01");
         bookingdates.setCheckoutDate("5025-02-04");
         booking.setBookingdates(bookingdates);
         booking.setAdditionalneeds("会意; 會意");

         System.out.println(booking);

         return gson.toJson(booking);
     }

     // valid booking with dynamic data

     public String createPayloadBookingFakerJS(){

         faker = new Faker();
         Booking booking = new Booking();
         booking.setFirstname(faker.name().firstName());
         booking.setLastname(faker.name().lastName());
         booking.setTotalprice(faker.random().nextInt(1, 1000));
         booking.setDepositpaid(faker.random().nextBoolean());

         BookingDates bookingdates = new BookingDates();
         bookingdates.setCheckinDate("2024-02-01");
         bookingdates.setCheckoutDate("2024-02-01");
         booking.setBookingdates(bookingdates);
         booking.setAdditionalneeds("Breakfast");

         System.out.println(booking);

         gson = new Gson();
         String jsonStringBooking = gson.toJson(booking);
         return jsonStringBooking;
     }


    // deserialization ( JSON String to Java Objects)
    // Convert the JSON String to Java Object so that we can verify response Body
    // DeSerialization

    public BookingResponse bookingResponseJava(String responseString) {
       gson = new Gson();
       BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
       return bookingResponse;
    }


    public String setAuthPayload(){


         Auth auth = new Auth();
         auth.setUsername("admin");
         auth.setPassword("password123");

         gson = new Gson();
         String jsonPayloadString = gson.toJson(auth);
         return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
         gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }


    // DeSer ( JSON String -> Java Object
    public String getInvalidResponse(String invalidTokenResponse){
        gson = new Gson();
        InvalidTokenResponse tokenResponse1 = gson.fromJson(invalidTokenResponse, InvalidTokenResponse.class);
        return  tokenResponse1.getReason();
    }

}
