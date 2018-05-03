package com.example.base.provider;


import android.support.v4.app.Fragment;

public interface IFragmentProvider extends IBaseProvider {
    Fragment newInstance(Object... args);
}
