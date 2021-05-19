package com.example.companyapp.MyApiConnect;
import android.content.SharedPreferences;
public class MySessionManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static MySessionManager INSTANCE = null;

    private MySessionManager (SharedPreferences prefs){
        this.prefs = prefs;
        this.editor = prefs.edit();
    }

    public static synchronized MySessionManager getInstance(SharedPreferences prefs){
        if(INSTANCE == null){
            INSTANCE = new MySessionManager(prefs);
        }
        return INSTANCE;
    }

    public void saveToken(MyUser token){
        editor.putString("AUTH_TOKEN", token.getAuthToken()).commit();
        editor.putString("REFRESH_TOKEN", token.getAuthToken()).commit();
    }

    public void deleteToken(){
        editor.remove("AUTH_TOKEN").commit();
        editor.remove("REFRESH_TOKEN").commit();
    }

    public MyUser fetchToken(){
        MyUser token = new MyUser();
        token.setAuthToken(prefs.getString("ACCESS_TOKEN", null));
        token.setRefreshToken(prefs.getString("REFRESH_TOKEN", null));
        return token;
    }

}
