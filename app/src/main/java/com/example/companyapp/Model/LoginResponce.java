package com.example.companyapp.Model;

import com.example.companyapp.entities.AccessToken;
import com.google.gson.annotations.SerializedName;

public class LoginResponce   {

   @SerializedName("status_code")
    int statuscode;
   @SerializedName("token")
    String authToken;
   @SerializedName("register_request")
    RegisterRequest registerRequest;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }


    public RegisterRequest getRegisterRequest() {
        return registerRequest;
    }

    public void setRegisterRequest(RegisterRequest registerRequest) {
        this.registerRequest = registerRequest;
    }
}
