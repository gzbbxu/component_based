package com.example.base.module.module2;

import android.support.v4.app.Fragment;

import com.example.base.router.ServiceManager;

public class Module2Service {
    public static Fragment getModule2Fragment(Object ... objs){
        return ServiceManager.getInstance().getModule2Provider().newInstance(objs);
    }
}
