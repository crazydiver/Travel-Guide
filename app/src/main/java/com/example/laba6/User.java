package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class User implements Parcelable {
    private String second_name;
    private String first_name;
    private String email;

    private ArrayList<Integer> favouritePlaces = new ArrayList<>();

    public ArrayList<Integer> getFavouritePlaces() {
        return favouritePlaces;
    }

    public void setFavouritePlaces(ArrayList<Integer> favouritePlaces) {
        this.favouritePlaces = favouritePlaces;
    }

    protected User(Parcel in) {
        second_name = in.readString();
        first_name = in.readString();
        email = in.readString();
        in.readList(favouritePlaces,getClass().getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String second_name, String first_name, String email) {
        this.second_name = second_name;
        this.first_name = first_name;
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(second_name);
        dest.writeString(first_name);
        dest.writeString(email);
        dest.writeList(favouritePlaces);
    }
}
