package com.example.base.module.module1;


import android.support.v4.app.Fragment;

import com.example.base.router.ServiceManager;

public class Module1Service {
    public static Fragment getModule1Fragment(Object... args){
        return ServiceManager.getInstance().getModule1Provider().newInstance(args);
    }
}
