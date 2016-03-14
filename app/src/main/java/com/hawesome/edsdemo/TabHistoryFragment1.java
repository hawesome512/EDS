package com.hawesome.edsdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by haisheng on 2016/3/4.
 */
public class TabHistoryFragment1 extends Fragment {

    LineChart lineChart;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_tab4,container,false);

        initChart(view);

        return view;
    }

    private void initChart(View view) {
        lineChart= (LineChart) view.findViewById(R.id.chartHistory);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.setData(getData());
        lineChart.setDescription("");
        lineChart.getLegend().setForm(Legend.LegendForm.LINE);
        lineChart.setMaxVisibleValueCount(50);
        lineChart.invalidate();
    }

    LineData getData(){
        List<String> xValues=new ArrayList<String>();
        List<Entry> yValues1=new ArrayList<Entry>();
        List<Entry> yValues2=new ArrayList<Entry>();
        List<Entry> yValues3=new ArrayList<Entry>();
        Random random=new Random();
        for(int i=0;i<300;i++){
            xValues.add(Integer.toString(i));
            yValues1.add(new Entry(random.nextInt(300)+500,i));
            yValues2.add(new Entry(random.nextInt(300)+500,i));
            yValues3.add(new Entry(random.nextInt(300)+500,i));
        }
        LineDataSet dataSet1=new LineDataSet(yValues1,"Ia");
        dataSet1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        dataSet1.setDrawCircles(false);
        LineDataSet dataSet2=new LineDataSet(yValues2,"Ib");
        dataSet2.setColor(ColorTemplate.VORDIPLOM_COLORS[1]);
        dataSet2.setDrawCircles(false);
        LineDataSet dataSet3=new LineDataSet(yValues3,"Ic");
        dataSet3.setColor(ColorTemplate.VORDIPLOM_COLORS[2]);
        dataSet3.setDrawCircles(false);
        List<LineDataSet> dataSets= Arrays.asList(dataSet1,dataSet2,dataSet3);
        LineData lineData=new LineData(xValues,dataSets);

        return lineData;
    }
}
