package com.example.administrator.component_based;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.RouterConstants;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private List<Fragment> mFragments = new LinkedList<>();
    private FragmentAdapter mAdapter;
    private BottomNavigationView navigation;
    private MenuItem menuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.container_pager);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        initViewPager();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViewPager() {


        Fragment module1 = (Fragment) ARouter.getInstance().build(RouterConstants.MODULE1_HOME).navigation();
        Fragment module2 = (Fragment) ARouter.getInstance().build(RouterConstants.MODULE2_HOME).navigation();
        Fragment module3 = (Fragment) ARouter.getInstance().build(RouterConstants.MODULE3_HOME).navigation();
        mFragments.add(module1);
        mFragments.add(module2);
        mFragments.add(module3);

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setAdapter(mAdapter);
    }
}
