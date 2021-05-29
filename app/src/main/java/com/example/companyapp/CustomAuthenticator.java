package com.example.companyapp;

import com.example.companyapp.entities.AccessToken;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Route;

public class CustomAuthenticator implements Authenticator {


    private SessionManager sessionManager;
         private static CustomAuthenticator INSTANCE;

         private CustomAuthenticator(SessionManager sessionManager){
             this.sessionManager = sessionManager;
         }

         static synchronized CustomAuthenticator getInstance(SessionManager sessionManager){
             if(INSTANCE == null){
                 INSTANCE = new CustomAuthenticator(sessionManager);
             }

             return INSTANCE;
         }


         @Nullable
         @Override
         public Request authenticate(Route route, okhttp3.Response response) throws IOException {

            /* if(responseCount(response) >= 3){
                 return null;
             }*/

             AccessToken token = sessionManager.getToken();


             return response.request().newBuilder().header("Authorization", token.getAccessToken()).build();

         }

         private int responseCount(okhttp3.Response response) {
             int result = 1;
             while ((response = response.priorResponse()) != null) {
                 result++;
             }
             return result;
         }
     }


