package com.example.base.module.login;


import android.app.Activity;

import com.example.base.provider.ILoginProvider;
import com.example.base.router.MyRouter;


public class LoginIntent {
    public static void launchLogin(Activity activity, int requestCode){
        MyRouter.newInstance(ILoginProvider.LOGIN_MAIN_ACTIVITY)
                .navigation(activity, requestCode);
    }
}
