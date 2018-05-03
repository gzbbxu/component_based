package com.example.base.module.detail;


import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.example.base.module.login.LoginIntent;
import com.example.base.provider.IDetailProvider;
import com.example.base.router.MyRouter;

public class DetailIntent {
    public static void launchDetail(final Activity activity, String url, final int requestCode) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        MyRouter.newInstance(IDetailProvider.DETAIL_ACTIVITY)
                .withBundle(bundle)
                .navigation(activity, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        //进入详情 被拦截  说明没有登录，跳转到登录
                        LoginIntent.launchLogin(activity, requestCode);
                    }
                });
    }
}
