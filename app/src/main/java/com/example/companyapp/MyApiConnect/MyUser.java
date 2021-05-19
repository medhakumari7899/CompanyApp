package com.example.companyapp.MyApiConnect;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class MyUser {
     @SerializedName("id")
    int id;

    @SerializedName("auth_token")
    String authToken;
    @SerializedName("refresh_token")
    String refreshToken;

     @SerializedName("firstname")
    String firstname;
    @SerializedName("lastname")
    String lastname;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("phone")
    String phone;
    @SerializedName("dob")
    String dob;
    @SerializedName("placeofbirth")
    String placeofbirth;
    @SerializedName("citizenship")
    String citizenship;
    @SerializedName("address")
    String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getAddress() {
        return address;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setAddress(String address) {
        this.address = address;


    }
}
