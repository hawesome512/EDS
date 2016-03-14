package com.hawesome.edsdemo;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by haisheng on 2016/3/3.
 */
public class TabUIFragment extends Fragment {
    BarChart chartU,chartI;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_tab1,container,false);
        chartI= (BarChart) view.findViewById(R.id.chartI);
        chartU= (BarChart) view.findViewById(R.id.chartU);

        XAxis xAxis=chartI.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(14);
        YAxis yAxis=chartI.getAxisRight();
        yAxis.setEnabled(false);
        chartI.setTouchEnabled(false);
        chartI.setDescription("I(A)");
        chartI.setDescriptionTextSize(14);
        Legend legend=chartI.getLegend();
        legend.setEnabled(false);
        chartI.setData(getBarData(400,600));
        chartI.invalidate();

        xAxis=chartU.getXAxis();
        xAxis.setDrawLabels(false);
        yAxis=chartU.getAxisRight();
        yAxis.setEnabled(false);
        legend=chartU.getLegend();
        legend.setEnabled(false);
        chartU.setTouchEnabled(false);
        chartU.setDescription("U(V)");
        chartU.setDescriptionTextSize(14);
        chartU.setData(getBarData(10,120));
        chartU.invalidate();
        return view;
    }


    BarData getBarData(int range,int offset){
        List<String> xValues= Arrays.asList("A","B","C","N");
        List<BarEntry> yValues=new ArrayList<BarEntry>();
        Random random=new Random();
        for(int i=0;i<4;i++){
            yValues.add(new BarEntry(random.nextInt(range)+offset,i));
        }

        BarDataSet dataSet=new BarDataSet(yValues,"Data Set");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setValueTextSize(14);
        dataSet.setDrawValues(true);
        dataSet.setBarSpacePercent(40);
        List<BarDataSet> dataSets=new ArrayList<BarDataSet>();
        dataSets.add(dataSet);

        BarData barData=new BarData(xValues,dataSets);
        return barData;
    }
}
