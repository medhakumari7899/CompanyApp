package com.example.companyapp;

import com.example.companyapp.entities.AccessToken;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.network.TokenManager;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Response;

public class CustomAuthenticator implements Authenticator {

         private TokenManager tokenManager;
         private static CustomAuthenticator INSTANCE;

         private CustomAuthenticator(TokenManager tokenManager){
             this.tokenManager = tokenManager;
         }

         static synchronized CustomAuthenticator getInstance(TokenManager tokenManager){
             if(INSTANCE == null){
                 INSTANCE = new CustomAuthenticator(tokenManager);
             }

             return INSTANCE;
         }


         @Nullable
         @Override
         public Request authenticate(Route route, okhttp3.Response response) throws IOException {

             if(responseCount(response) >= 3){
                 return null;
             }

             AccessToken token = tokenManager.getToken();

             ApiService service = RetrofitBuilder.createService(ApiService.class);
             Call<AccessToken> call = service.refresh(token.getRefreshToken() + "a");
             retrofit2.Response<AccessToken> res = call.execute();

             if(res.isSuccessful()){
                 AccessToken newToken = res.body();
                 tokenManager.saveToken(newToken);

                 return response.request().newBuilder().header("Authorization", "Bearer " + res.body().getAccessToken()).build();
             }else{
                 return null;
             }
         }

         private int responseCount(okhttp3.Response response) {
             int result = 1;
             while ((response = response.priorResponse()) != null) {
                 result++;
             }
             return result;
         }
     }


