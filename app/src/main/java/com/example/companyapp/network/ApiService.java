package com.example.companyapp.network;

import com.example.companyapp.Model.LoginRequest;
import com.example.companyapp.Model.LoginResponce;
import com.example.companyapp.Model.RegisterRequest;
import com.example.companyapp.Model.RegisterResponse;
import com.example.companyapp.UserDetailsForm.BussinessRelatedData2;
import com.example.companyapp.entities.AccessToken;
import com.example.companyapp.sevice.BusinessRelatedData1Request;
import com.example.companyapp.sevice.BusinessRelatedData1Response;
import com.example.companyapp.sevice.DataCollectForms1Request;
import com.example.companyapp.sevice.DataCollectForms1Response;
import com.example.companyapp.sevice.DataCollectFormsRequest;
import com.example.companyapp.sevice.DataCollectFormsResponce;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface ApiService {
  @POST("register")
  Call<RegisterResponse> registerUser(@Header("Authorization") String token,@Body RegisterRequest registerRequest);

  @POST("company/save")
  Call<BusinessRelatedData1Response>businessrelateddata1(@Header("Authorization") String token,@Body BusinessRelatedData1Request businessRelatedData1Request);
  @PATCH("update")
  Call<DataCollectFormsResponce> datacollectform( @Body DataCollectFormsRequest dataCollectFormsRequest);
  @POST("update")
  Call<DataCollectForms1Response> datacollectform1(@Body DataCollectForms1Request dataCollectForms1Request);

  @POST("login")
  Call<LoginResponce> loginUser(@Header("Authorization") String token,@Body LoginRequest loginRequest);

  @POST("social_auth")
  @FormUrlEncoded
  Call<AccessToken> socialAuth(@Field("name") String name,
                               @Field("email") String email,
                               @Field("provider") String provider,
                               @Field("provider_user_id") String providerUserId);

  @GET("token")
  @FormUrlEncoded
  Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);

  @GET("posts")
  Call<DataCollectFormsResponce> posts();


}
