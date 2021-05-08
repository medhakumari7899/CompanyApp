package com.example.companyapp.Retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
     private static final String BASE_URL="http://3.16.114.228:8000/";
     private static Retrofit retrofit=null;

     public static Retrofit getApiClient(){
         if (retrofit==null){
             retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

         }
         return retrofit;
     }
}
