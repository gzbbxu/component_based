package com.example.module3;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.provider.IModule3Provider;

import static com.example.base.provider.IModule3Provider.MODULE3_SERVICE;

@Route(path = MODULE3_SERVICE)
public class Module3Provider implements IModule3Provider {
    @Override
    public Fragment newInstance(Object... args) {
        return Module3Fragment.newInstance(args[0].toString(), args[1].toString());
    }

    @Override
    public void init(Context context) {

    }
}
