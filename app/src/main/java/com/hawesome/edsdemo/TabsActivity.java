package com.hawesome.edsdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        TabHost tabHost= (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("第一标签").setContent(R.id.linearLayout));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("第二标签").setContent(R.id.linearLayout2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("第三标签").setContent(R.id.linearLayout3));
    }
}
