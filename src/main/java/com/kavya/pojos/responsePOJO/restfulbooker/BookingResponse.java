package com.kavya.pojos.responsePOJO.restfulbooker;

import com.kavya.pojos.requestPOJO.restfulbooker.Booking;

public class BookingResponse {

    private Integer bookingId;
    private Booking booking;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
