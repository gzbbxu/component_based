package com.example.base.module.home;


import android.app.Activity;

import com.example.base.router.ServiceManager;


public class HomeService {
    public static void selectTab(Activity activity,int position){
        ServiceManager.getInstance().getHomeProvider().selectTab(activity,position);
    }
}
