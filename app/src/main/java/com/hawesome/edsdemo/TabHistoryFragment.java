package com.hawesome.edsdemo;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.hawesome.edsdemo.listviewitems.ChartItem;
import com.hawesome.edsdemo.listviewitems.CombinedChartItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by haisheng on 2016/3/4.
 */
public class TabHistoryFragment extends Fragment {

    String[] items = {"Ia", "Ua", "Ib", "Ub", "Ic", "Uc", "In", "Un"};
    ArrayList<ChartItem> mChartItems;
    Button button;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tab4, container, false);

        lv = (ListView) view.findViewById(R.id.listCharts);
        lv.addHeaderView(getHeadView());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getContext(),HistoryFullActivity.class);
                MyCombinedData myCombinedData=new MyCombinedData();
                int index=position-1;
                myCombinedData.setIndex(index);
                myCombinedData.setxValues(getXValues());
                myCombinedData.setY1Values(getYValues(30,110));
                myCombinedData.setY2Values(getYValues(400,600));
                Bundle bundle=new Bundle();
                bundle.putParcelable("Data",myCombinedData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        setData();

        ChartDataAdapter cda = new ChartDataAdapter(getContext(), mChartItems);
        lv.setAdapter(cda);

        return view;
    }

    private void setData() {
        mChartItems = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            CombinedData combinedData = new CombinedData(getHours());
            combinedData.setData(generateDataLine(i));
            combinedData.setData(generateDataBar(i));
            mChartItems.add(new CombinedChartItem(combinedData, getContext()));
        }
    }

    private View getHeadView() {
        LinearLayout layout = new LinearLayout(getContext());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layoutParams);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);

        button = new Button(getContext());
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setBackgroundColor(getResources().getColor(R.color.colorLRed));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        button.setText(df.format(calendar.getTime()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        button.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        setData();
                        ChartDataAdapter cda = new ChartDataAdapter(getContext(), mChartItems);
                        lv.setAdapter(cda);

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                datePickerDialog.show();

            }
        });

        layout.addView(button);
        return layout;
    }

    /**
     * adapter that supports 3 different item types
     */
    private class ChartDataAdapter extends ArrayAdapter<ChartItem> {

        public ChartDataAdapter(Context context, List<ChartItem> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getItem(position).getView(position, convertView, getContext());
        }

        @Override
        public int getItemViewType(int position) {
            // return the views type
            return getItem(position).getItemType();
        }

        @Override
        public int getViewTypeCount() {
            return 3; // we have 3 different item-types
        }
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private LineData generateDataLine(int index) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 24; i++) {
            e1.add(new Entry((int) (Math.random() * 30) + 110, i));
        }

        LineDataSet d1 = new LineDataSet(e1, items[2 * index + 1]);
        d1.setLineWidth(2.5f);
        d1.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
//        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);
        d1.setAxisDependency(YAxis.AxisDependency.RIGHT);
        LineData cd = new LineData();
        cd.addDataSet(d1);
        return cd;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private BarData generateDataBar(int index) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < 24; i++) {
            xValues.add(Integer.toString(i));
            entries.add(new BarEntry((int) (Math.random() * 400) + 600, i));
        }

        BarDataSet d = new BarDataSet(entries, items[2 * index]);
        d.setBarSpacePercent(20f);
        d.setColor(ColorTemplate.VORDIPLOM_COLORS[index]);
//        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData();
        cd.addDataSet(d);
        return cd;
    }

    private float[] getYValues(int max,int offset){
        float[] yValues=new float[24*12];
        Random random=new Random();
        for(int i=0;i<yValues.length;i++){
            yValues[i]=random.nextInt(max)+offset;
        }
        return yValues;
    }
    private String[] getXValues(){
        String[] xValues=new String[24*12];
        for(int i=0;i<xValues.length;i++){
            xValues[i]=String.format("%d:%02d",i/12,i%12*5);
        }
        return xValues;
    }

    private ArrayList<String> getHours() {
        ArrayList<String> h = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            h.add(Integer.toString(i));
        }
        return h;
    }

}
