package com.example.module2;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.provider.IModule2Provider;

import static com.example.base.provider.IModule2Provider.MODULE2_SERVICE;

@Route(path = MODULE2_SERVICE)
public class Module2Provider implements IModule2Provider {
    @Override
    public Fragment newInstance(Object... args) {
        return Module2Fragment.newInstance(args[0].toString(),args[1].toString());
    }

    @Override
    public void init(Context context) {

    }
}
