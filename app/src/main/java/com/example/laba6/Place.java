package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

import java.io.Serializable;

public class Place implements Parcelable {
    private Point point;
    private String info;
    private String name;

    private String cost;

    private String time;

    protected Place(Parcel in) {
        info = in.readString();
        name = in.readString();
        point = new Point(in.readDouble(), in.readDouble());
        cost = in.readString();
        time = in.readString();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Place() {
    }

    public Place(Point point, String info, String name, String cost, String time) {
        this.point = point;
        this.info = info;
        this.name = name;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(info);
        dest.writeString(name);
        dest.writeDouble(point.getLatitude());
        dest.writeDouble(point.getLongitude());
        dest.writeString(cost);
        dest.writeString(time);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

}
