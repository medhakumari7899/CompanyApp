package com.example.companyapp.sevice;

import com.example.companyapp.network.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
     public static Retrofit getRetrofit(){

         HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
         httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

         OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

         Retrofit retrofit = new Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl("http://3.16.114.228:3000/api/")
                 .client(okHttpClient)
                 .build();


         return retrofit;

     }

     public static ApiService getService(){
         ApiService apiService = getRetrofit().create(ApiService.class);

         return apiService;
     }
 }
