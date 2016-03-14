package com.hawesome.edsdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haisheng on 2016/3/10.
 */
public class MyCombinedData implements Parcelable {
    int index;
    String[] xValues;
    float[] y1Values, y2Values;

    public MyCombinedData(){
        this.xValues=new String[24*12];
        this.y1Values=new float[24*12];
        this.y2Values=new float[24*12];
    }

    public static final Parcelable.Creator<MyCombinedData> CREATOR = new Parcelable.Creator<MyCombinedData>() {
//重写Creator

        @Override
        public MyCombinedData createFromParcel(Parcel source) {
            MyCombinedData p = new MyCombinedData();
            p.index = source.readInt();
            source.readStringArray(p.xValues);
            source.readFloatArray(p.y1Values);
            source.readFloatArray(p.y2Values);
            return p;
        }

        @Override
        public MyCombinedData[] newArray(int size) {
            // TODO Auto-generated method stub
            return null;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeStringArray(xValues);
        dest.writeFloatArray(y1Values);
        dest.writeFloatArray(y2Values);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String[] getxValues() {
        return xValues;
    }

    public void setxValues(String[] xValues) {
        this.xValues = xValues;
    }

    public float[] getY1Values() {
        return y1Values;
    }

    public void setY1Values(float[] y1Values) {
        this.y1Values = y1Values;
    }

    public float[] getY2Values() {
        return y2Values;
    }

    public void setY2Values(float[] y2Values) {
        this.y2Values = y2Values;
    }
}
