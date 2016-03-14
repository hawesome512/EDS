package com.hawesome.edsdemo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab2Activity extends AppCompatActivity {

    ImageView ivTab1,ivTab2,ivTab3,ivTab4,ivTab5;
    List<ImageView> ivTabList;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;
    ViewPager viewPager;
    List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        initTabItems();

        initViewPager();
    }

    private void initViewPager() {
        viewPager= (ViewPager) findViewById(R.id.vPager);
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(TabFragment.newInstance(R.layout.frag_tab1));
        fragmentList.add(TabFragment.newInstance(R.layout.frag_tab4));
        fragmentList.add(TabFragment.newInstance(R.layout.frag_tab3));
        fragmentList.add(TabFragment.newInstance(R.layout.frag_tab2));
        fragmentList.add(TabFragment.newInstance(R.layout.frag_tab5));
        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),fragmentList));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Scroll",Integer.toString(position));
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Selected",Integer.toString(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("ScrollStateChanged",Integer.toString(state));
            }
        });
    }

    private void initTabItems() {
        ivTab1= (ImageView) findViewById(R.id.ivTab1);
        ivTab2= (ImageView) findViewById(R.id.ivTab2);
        ivTab3= (ImageView) findViewById(R.id.ivTab3);
        ivTab4= (ImageView) findViewById(R.id.ivTab4);
        ivTab5= (ImageView) findViewById(R.id.ivTab5);
        ivTabList= Arrays.asList(ivTab1, ivTab2, ivTab3, ivTab4, ivTab5);
        linearLayout1= (LinearLayout) findViewById(R.id.tabL1);
        linearLayout2= (LinearLayout) findViewById(R.id.tabL2);
        linearLayout3= (LinearLayout) findViewById(R.id.tabL3);
        linearLayout4= (LinearLayout) findViewById(R.id.tabL4);
        linearLayout5= (LinearLayout) findViewById(R.id.tabL5);
        linearLayout1.setOnClickListener(new TabTextOnClickListener(0));
        linearLayout2.setOnClickListener(new TabTextOnClickListener(1));
        linearLayout3.setOnClickListener(new TabTextOnClickListener(2));
        linearLayout4.setOnClickListener(new TabTextOnClickListener(3));
        linearLayout5.setOnClickListener(new TabTextOnClickListener(4));
    }

    class TabTextOnClickListener implements View.OnClickListener{
        private int index=0;
        public TabTextOnClickListener(int index){
            this.index=index;
        }

        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }
    }

}
