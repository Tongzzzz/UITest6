package com.example.tong.uitest6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tong on 2016/3/3.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public ArrayList<Fragment> fragmentList = new ArrayList<>();
    public ArrayList<String> viewpager_title = new ArrayList<>();

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList,ArrayList<String> viewpager_title) {
        super(fm);
        this.fragmentList=fragmentList;
        this.viewpager_title = viewpager_title;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return viewpager_title.get(position);
            case 1:
                return viewpager_title.get(position);

        }
        defautl:
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
