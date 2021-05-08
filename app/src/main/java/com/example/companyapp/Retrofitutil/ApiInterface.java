package com.example.companyapp.Retrofitutil;

import com.example.companyapp.Model.usermodel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/user/login")
    Call<usermodel> loginuserPerform(@Field("email") String email, @Field("password") String password);
    @POST("api/user/register")
    Call<usermodel> registeruserPerform(@Field("firstname") String firstname,
                                        @Field("lastname") String lastname, @Field("email") String email, @Field("password") String password,
                                        @Field("phone") String phone, @Field("dob") String dob, @Field("placeofbirth") String placeofbirth,
                                        @Field("citizenship") String citizenship, @Field("address") String address);

}
