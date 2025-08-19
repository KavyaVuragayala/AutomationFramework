package com.kavya.pojos.requestPOJO.restfulbooker;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Auth {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    }

