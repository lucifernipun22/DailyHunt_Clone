package com.example.dailyhunt_clone;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class MyApplication extends Application {

    private static MyApplication mInstance;
    public SharedPreferences preferences;
    Activity activity;
    public String prefName = "news";

    public MyApplication() {
        mInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void saveIsLogin(boolean flag) {
        preferences = this.getSharedPreferences(prefName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("IsLoggedIn", flag);
        editor.commit();
    }

    public boolean getIsLogin() {
        preferences = this.getSharedPreferences(prefName, 0);
        if (preferences != null) {
            boolean flag = preferences.getBoolean(
                    "IsLoggedIn", false);
            return flag;
        }
        return false;
    }

    public void saveLogin(String user_id, String user_name, String email) {
        preferences = this.getSharedPreferences(prefName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user_id", user_id);
        editor.putString("user_name", user_name);
        editor.putString("email", email);
        editor.commit();
    }

    public String getUserId() {
        preferences = this.getSharedPreferences(prefName, 0);
        if (preferences != null) {
            String user_id = preferences.getString(
                    "user_id", "");
            return user_id;
        }
        return "";
    }

    public String getUserName() {
        preferences = this.getSharedPreferences(prefName, 0);
        if (preferences != null) {
            String user_name = preferences.getString(
                    "user_name", "");
            return user_name;
        }
        return "";
    }

    public String getUserEmail() {
        preferences = this.getSharedPreferences(prefName, 0);
        if (preferences != null) {
            String user_email = preferences.getString(
                    "email", "");
            return user_email;
        }
        return "";
    }

    public String getType() {
        preferences = this.getSharedPreferences(prefName, 0);
        if (preferences != null) {
            String user_type = preferences.getString(
                    "type", "");
            return user_type;
        }
        return "";
    }

    public void saveType(String type) {
        preferences = this.getSharedPreferences(prefName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("type", type);
        editor.commit();
    }

}
