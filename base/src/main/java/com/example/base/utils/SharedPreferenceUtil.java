package com.example.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;


import com.example.base.BaseApplication;

import java.io.IOException;
import java.io.StreamCorruptedException;


public class SharedPreferenceUtil {

    // 用户名key
    public final static String KEY_NAME = "KEY_NAME";
    public final static String KEY_AUTO = "KEY_AUTO";
    public final static String KEY_LOGIN = "KEY_LOGIN";
    public final static String KEY_LEVEL = "KEY_LEVEL";
    public final static String KEY_DELIVERY = "KEY_DELIVERY";
    private static SharedPreferenceUtil spUtils;
    private SharedPreferences sp;


    //

    /**
     *
     * 初始化，一般在应用启动之后就要初始化
     *
     * @param context 此处的context要用application的全局上下文,
     *                避免static强类型一直持有activity的引用,造成内存泄露
     */
    public static synchronized void initSharedPreference(Context context) {
        if (spUtils == null) {
            spUtils = new SharedPreferenceUtil(context);
        }
    }


    /**
     * 获取唯一的instance
     *
     * @return
     */

    public static synchronized SharedPreferenceUtil getInstance() {
        if (spUtils == null) {
            spUtils = new SharedPreferenceUtil(BaseApplication.getInstance());
        }

        return spUtils;
    }

    public SharedPreferenceUtil(Context context) {
        sp = context.getSharedPreferences("SharedPreferenceUtil", Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPref() {
        return sp;
    }

    public synchronized void putAutoLogin(Boolean AutoLogin) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(KEY_AUTO, AutoLogin);
        editor.commit();
    }

    public synchronized Boolean getAutoLogin() {
        Boolean flag = sp.getBoolean(KEY_AUTO, false);
        Log.i("flag", flag + "flag");
        return flag;
    }

    public synchronized void setIsLogin(Boolean AutoLogin) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(KEY_LOGIN, AutoLogin);
        editor.commit();
    }

    public synchronized Boolean getIsLogin() {
        Boolean flag = sp.getBoolean(KEY_LOGIN, false);
        return flag;
    }



    //记录用户名
    public void setUsername(String username){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("pre_username",username);
        editor.apply();
    }

    //读取用户名
    public String getUsername(){
        return sp.getString("pre_username","");
    }




    public synchronized void DeleteUser() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_NAME, "");
        editor.commit();
    }



}
