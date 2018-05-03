package com.example.module3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.module.home.HomeService;
import com.example.base.provider.IModule3Provider;

@Route(path = IModule3Provider.MODULE3_HOME)
public class Module3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView btn_tv1,btn_tv2;


    public Module3Fragment() {
    }

    public static Module3Fragment newInstance(String param1, String param2) {
        Module3Fragment fragment = new Module3Fragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_module3, container, false);
        btn_tv1 = view.findViewById(R.id.btn_tv1);
        btn_tv2 = view.findViewById(R.id.btn_tv2);
        btn_tv1.setOnClickListener(clickListener);
        btn_tv2.setOnClickListener(clickListener);
        return  view;
    }

    View.OnClickListener clickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            if(view.getId()==btn_tv1.getId()){
                HomeService.selectTab(getActivity(),0);
            }else if(view.getId() == btn_tv2.getId()){
                HomeService.selectTab(getActivity(),1);
            }
        }
    };


}
