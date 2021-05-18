package com.example.companyapp;
import android.content.SharedPreferences;
import com.example.companyapp.entities.AccessToken;
import org.jetbrains.annotations.NotNull;

public class SessionManager  {

     private SharedPreferences prefs;
     private SharedPreferences.Editor editor;
     private static SessionManager INSTANCE = null;



     private SessionManager(SharedPreferences prefs){
          this.prefs = prefs;
          this.editor = prefs.edit();
     }
     public static synchronized SessionManager getInstance(SharedPreferences prefs){
          if(INSTANCE == null){
               INSTANCE = new SessionManager(prefs);
          }
          return INSTANCE;
     }


     public static final String USER_TOKEN = "user_token";
      public final void saveAuthToken(@NotNull String token) {
          SharedPreferences.Editor editor = this.prefs.edit();
          editor.putString("token", token);
          editor.apply();
     }
     public void saveToken(AccessToken token){
          editor.putString("ACCESS_TOKEN", token.getAccessToken()).commit();
          editor.putString("REFRESH_TOKEN", token.getRefreshToken()).commit();
     }

     public final String fetchAuthToken(String authToken) {
          return this.prefs.getString("user_token", (String)null);
     }



}
