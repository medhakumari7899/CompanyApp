package com.example.companyapp.Model;

import android.widget.EditText;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("id")
    private  int id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
