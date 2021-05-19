package com.example.companyapp.MyApiConnect;

import retrofit2.Call;
import retrofit2.http.POST;

public interface MyApiServive {
     @POST("login")
     Call<MyUser> basicLogin();

     @POST("register")
    Call<MyUser> basicRegister();

 }
