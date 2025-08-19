package com.kavya.pojos.responsePOJO.VWO;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;

public class InvaildloginResponse {

    @SuppressWarnings("unused")
    public class InvalidloginResponse {

        @SerializedName("message")
        private String mMessage;

        public String getMessage() {
            return mMessage;
        }

        public void setMessage(String message) {
            mMessage = message;
        }

    }
}
