package com.hawesome.edsdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HistoryFullActivity extends Activity {

    CombinedChart chart;
    CombinedData combinedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history_full);
        chart= (CombinedChart) findViewById(R.id.chartUI);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        MyCombinedData myCombinedData=bundle.getParcelable("Data");
        initChart();
        ArrayList<BarEntry> y1=new ArrayList<>();
        ArrayList<Entry> y2=new ArrayList<>();
        for(int i=0;i<24*12;i++){
            y1.add(new BarEntry(myCombinedData.y2Values[i],i));
            y2.add(new Entry(myCombinedData.y1Values[i],i));
        }
        BarDataSet barDataSet=new BarDataSet(y1,"I");
        barDataSet.setColor(ColorTemplate.VORDIPLOM_COLORS[myCombinedData.index]);
        BarData barData=new BarData();
        barData.addDataSet(barDataSet);

        LineDataSet lineDataSet=new LineDataSet(y2,"U");
        lineDataSet.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineDataSet.setDrawCircles(false);
        LineData lineData=new LineData();
        lineData.addDataSet(lineDataSet);

        combinedData=new CombinedData(myCombinedData.xValues);
        combinedData.setData(barData);
        combinedData.setData(lineData);

        initChart();
    }
    
    void initChart(){
        // apply styling
        // chart.setValueTypeface(mTf);
        chart.setDescription("");
        chart.setDrawGridBackground(false);
//        chart.setTouchEnabled(false);

        Legend legend=chart.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = chart.getAxisLeft();
//        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(5, false);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = chart.getAxisRight();
//        rightAxis.setTypeface(mTf);
        rightAxis.setLabelCount(5, false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMaxValue(250);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)
        rightAxis.setTextColor(ColorTemplate.VORDIPLOM_COLORS[4]);

        // set data
        chart.setData(combinedData);

        // do not forget to refresh the chart
        // chart.invalidate();
        chart.animateX(750);
    }

    @Override
    protected void onResume() {
        boolean isTablet=getResources().getBoolean(R.bool.isTablet);
        if(!isTablet&&getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

}
