package com.example.module1;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.provider.IModule1Provider;

import static com.example.base.provider.IModule1Provider.MODULE1_SERVICE;

@Route(path = MODULE1_SERVICE)
public class Module1Provider implements IModule1Provider{
    @Override
    public Fragment newInstance(Object... args) {
        return Module1Fragment.newInstance(args[0].toString(),args[1].toString());
    }

    @Override
    public void init(Context context) {

    }
}
