package com.example.base.router;

import com.example.base.provider.IHomeProvider;
import com.example.base.provider.IModule1Provider;
import com.example.base.provider.IModule2Provider;
import com.example.base.provider.IModule3Provider;

/**
 * Created by zkk on 2018/04/06
 */

public class ServiceManager {
    private static final class ServiceManagerHolder {
        private static final ServiceManager instance = new ServiceManager();
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.instance;
    }

    IModule1Provider module1Provider;

    IModule2Provider module2Provider;

    IModule3Provider module3Provider;

    IHomeProvider homeProvider;

    public IModule1Provider getModule1Provider() {
        return module1Provider != null ? module1Provider : (module1Provider = ((IModule1Provider) MyRouter.newInstance(IModule1Provider.MODULE1_SERVICE).navigation()));
    }

    public IModule2Provider getModule2Provider() {
        return module2Provider != null ? module2Provider : (module2Provider = ((IModule2Provider) MyRouter.newInstance(IModule2Provider.MODULE2_SERVICE).navigation()));
    }

    public IModule3Provider getModule3Provider() {
        return module3Provider != null ? module3Provider : (module3Provider = ((IModule3Provider) MyRouter.newInstance(IModule3Provider.MODULE3_SERVICE).navigation()));
    }

    public IHomeProvider getHomeProvider() {
        return homeProvider != null ? homeProvider : (homeProvider = ((IHomeProvider) MyRouter.newInstance(IHomeProvider.HOME_SERVICE).navigation()));
    }
}
