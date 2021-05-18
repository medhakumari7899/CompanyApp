package com.example.companyapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponce   {

   @SerializedName("status_code")
    int statuscode;
   @SerializedName("auth_token")
    String authToken;
   @SerializedName("register_request")
    RegisterRequest registerRequest;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public RegisterRequest getRegisterRequest() {
        return registerRequest;
    }

    public void setRegisterRequest(RegisterRequest registerRequest) {
        this.registerRequest = registerRequest;
    }
}
