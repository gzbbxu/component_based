package com.example.base.provider;


import android.app.Activity;

public interface IHomeProvider extends IBaseProvider {
    String HOME = "/home/";
    String HOME_SERVICE = HOME + "main/service";

    void selectTab(Activity activity, int position);
}
