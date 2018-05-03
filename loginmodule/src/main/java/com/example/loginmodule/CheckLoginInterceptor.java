package com.example.loginmodule;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.Constants;
import com.example.base.module.login.LoginIntent;
import com.example.base.provider.IDetailProvider;

/**
 * Created by zkk on 2018/3/15.
 * 优先级越大，越先执行
 */
@Interceptor(priority = 8, name = "测试拦截器")
public class CheckLoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i("zhouke","CheckLoginInterceptor process:"+postcard.getPath()+":"+postcard.getExtras().getString(Constants.START_LOGIN_WITH_PARAMS));
        if(postcard.getPath().equals(IDetailProvider.DETAIL_ACTIVITY)){
            if(Constants.isLogin){
//                postcard.withString("extra", "我是在拦截器中附加的参数");
                callback.onContinue(postcard); // 处理完成，交还控制权
            }else{
                callback.onInterrupt(null);
            }
        }else{
            callback.onContinue(postcard); // 处理完成，交还控制权
        }


       /* callback.onInterrupt(null);
        ARouter.getInstance().build("/router/login").navigation();*/
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.i("zhouke","CheckLoginInterceptor init2222");
    }
}
