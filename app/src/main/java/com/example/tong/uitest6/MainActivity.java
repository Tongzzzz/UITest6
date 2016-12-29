package com.example.tong.uitest6;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import com.example.tong.uitest6.fragment.FirstFragment;
import com.example.tong.uitest6.fragment.SecondFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        tabLayout = (TabLayout)findViewById(R.id.viewpager_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //返回功能
        getSupportActionBar().setHomeButtonEnabled(true);       //显示home键

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //设置ViewPager
        ArrayList<Fragment> fragments = new ArrayList<>();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        ArrayList<String> viewpager_title = new ArrayList<>();
        viewpager_title.add("first");
        viewpager_title.add("second");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragments,viewpager_title);

        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
