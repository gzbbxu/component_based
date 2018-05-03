package com.example.module1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.Constants;
import com.example.base.RouterConstants;
import com.example.base.bean.User;
import com.example.base.module.detail.DetailIntent;
import com.example.base.module.login.LoginIntent;
import com.example.base.provider.IModule1Provider;

@Route(path = IModule1Provider.MODULE1_HOME)
public class Module1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int REQUEST_CODE = 0x100;
    private String mParam1;
    private String mParam2;
    private TextView  btn_login;


    public Module1Fragment() {
    }

    public static Module1Fragment newInstance(String param1, String param2) {
        Module1Fragment fragment = new Module1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_module1, container, false);
        btn_login = view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(clickListener);
        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btn_login){
              /*  ARouter.getInstance().build(RouterConstants.LOGIN_MODULE).
                        withString(Constants.START_LOGIN_WITH_PARAMS, "I am params from HomeFragment").
                        navigation(getActivity(), Constants.REQUEST_START_LOGIN);*/
//                LoginIntent.launchLogin(getActivity(),REQUEST_CODE);
                DetailIntent.launchDetail(getActivity(),"http://www.baidu.com",REQUEST_CODE);

            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            String name = data.getStringExtra("name");
            String pwd = data.getStringExtra("pwd");
            Toast.makeText(getActivity(),"登录成功:"+name+":"+pwd,Toast.LENGTH_SHORT).show();
            Constants.isLogin = true;
        }
    }
}
