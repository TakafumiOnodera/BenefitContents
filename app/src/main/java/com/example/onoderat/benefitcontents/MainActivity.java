package com.example.onoderat.benefitcontents;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements RecyclerFragment.RecyclerFragmentListener {
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = findViewById(R.id.viewPager);
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);

        //TODO タブにフラグメントをセットしたい
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onRecyclerEvent() {
        //TODO 画面遷移
        Log.d("MainActivity", "画面遷移");
    }
}
