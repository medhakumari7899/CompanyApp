package com.example.companyapp;

import com.example.companyapp.network.TokenManager;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

 private static final String BASE_URL = "http://3.16.114.228:3000/api/";

 private final static OkHttpClient client = buildClient();
 private final static Retrofit retrofit = buildRetrofit();

 private static OkHttpClient buildClient(){
  OkHttpClient.Builder builder = new OkHttpClient.Builder()
          .addInterceptor(new Interceptor() {
           @NotNull
           @Override
           public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request();

            Request.Builder builder = request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("authorization", "Accept");

            request = builder.build();

            return chain.proceed(request);

           }
          });

  if(BuildConfig.DEBUG){
   builder.addNetworkInterceptor(new StethoInterceptor());
  }

  return builder.build();

 }

 private static Retrofit buildRetrofit(){
  return new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(RetrofitBuilder.client)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
 }

 public static <T> T createService(Class<T> service){
  return retrofit.create(service);
 }

 public static <T> T createServiceWithAuth(Class<T> service, final TokenManager tokenManager){

  OkHttpClient newClient = client.newBuilder().addInterceptor(new Interceptor() {
   @NotNull
   @Override
   public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {

    Request request = chain.request();

    Request.Builder builder = request.newBuilder();

    if(tokenManager.getToken().getAccessToken() != null){
     builder.addHeader("Authorization", "Bearer " + tokenManager.getToken().getAccessToken());
    }
         request = builder.build();
             return chain.proceed(request);
   }
  }).authenticator(CustomAuthenticator.getInstance(tokenManager)).build();
  Retrofit newRetrofit = retrofit.newBuilder().client(newClient).build();
  return newRetrofit.create(service);

 }

 public static Retrofit getRetrofit() {
  return retrofit;
 }
}
