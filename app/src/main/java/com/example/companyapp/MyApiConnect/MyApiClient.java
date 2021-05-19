package com.example.companyapp.MyApiConnect;

import android.text.TextUtils;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiClient {
     public static final String API_BASE_URL = "http://3.16.114.228:3000/api/user/";

     private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

     private static Retrofit.Builder builder =
             new Retrofit.Builder()
                     .baseUrl(API_BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create());

     private static Retrofit retrofit = builder.build();




     public static <S> S createService(Class<S> serviceClass) {
         return createService(serviceClass, null, null);
     }

     public static <S> S createService(
             Class<S> serviceClass, String email, String password) {
         if (!TextUtils.isEmpty(email)
                 && !TextUtils.isEmpty(password)) {
             String authToken = Credentials.basic(email, password);
             return createService(serviceClass, authToken);
         }

         return createService(serviceClass, null);
     }

     public static <S> S createService(
             Class<S> serviceClass, final String authToken) {
         if (!TextUtils.isEmpty(authToken)) {
             AuthenticationInterceptor interceptor =
                     new AuthenticationInterceptor(authToken);

             if (!httpClient.interceptors().contains(interceptor)) {
                 httpClient.addInterceptor(interceptor);

                 builder.client(httpClient.build());
                 retrofit = builder.build();
             }
         }

         return retrofit.create(serviceClass);
     }
 }


