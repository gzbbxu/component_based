package com.example.administrator.component_based;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.provider.IHomeProvider;

@Route(path = IHomeProvider.HOME_SERVICE)
public class HomeProvider implements IHomeProvider {
    @Override
    public void selectTab(Activity activity, int position) {
        ((MainActivity) activity).selectTab(position);
    }

    @Override
    public void init(Context context) {

    }
}
