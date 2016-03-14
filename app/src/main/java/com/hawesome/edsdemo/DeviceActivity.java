package com.hawesome.edsdemo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class DeviceActivity extends AppCompatActivity {

    ViewPager viewPager;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        initViewPager();
        initTab();
    }

    private void initViewPager() {
        viewPager= (ViewPager) findViewById(R.id.device_vp);
        fragments=new ArrayList<Fragment>();
//        fragments.add(TabFragment.newInstance(R.layout.frag_tab1));
        fragments.add(new TabUIFragment());
        fragments.add(TabFragment.newInstance(R.layout.frag_tab2));
        fragments.add(new TabOIFragment());
        fragments.add(new TabHistoryFragment());
        fragments.add(TabFragment.newInstance(R.layout.frag_tab5));
        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Scroll",Integer.toString(position));
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb1.setChecked(true);
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;
                    case 3:
                        rb4.setChecked(true);
                        break;
                    case 4:
                        rb5.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("ScrollStateChanged",Integer.toString(state));
            }
        });
    }

    private void initTab() {
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.device_tab);
        rb1= (RadioButton) linearLayout.findViewById(R.id.rb1);
        rb2= (RadioButton) linearLayout.findViewById(R.id.rb2);
        rb3= (RadioButton) linearLayout.findViewById(R.id.rb3);
        rb4= (RadioButton) linearLayout.findViewById(R.id.rb4);
        rb5= (RadioButton) linearLayout.findViewById(R.id.rb5);
        rb1.setOnClickListener(new TabRadioButtonOnClickListener(0));
        rb2.setOnClickListener(new TabRadioButtonOnClickListener(1));
        rb3.setOnClickListener(new TabRadioButtonOnClickListener(2));
        rb4.setOnClickListener(new TabRadioButtonOnClickListener(3));
        rb5.setOnClickListener(new TabRadioButtonOnClickListener(4));
    }

    class TabRadioButtonOnClickListener implements View.OnClickListener{

        private int index=0;
        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }

        public TabRadioButtonOnClickListener(int index) {
            this.index=index;
        }
    }
}
