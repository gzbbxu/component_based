package com.example.base.module.module3;


import android.support.v4.app.Fragment;

import com.example.base.router.ServiceManager;

public class Module3Service {
    public static Fragment getModule3Fragment(Object ... objs){
        return ServiceManager.getInstance().getModule3Provider().newInstance(objs);
    }
}
