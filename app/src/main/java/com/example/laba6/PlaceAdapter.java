package com.example.laba6;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {
    private Context context;

    private ArrayList<Place> placeArrayList;

    public ArrayList<CheckBox> ch = new ArrayList<CheckBox>();

    private User user;

    @Override
    public int getCount() {
        return placeArrayList.size();
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView name = convertView.findViewById(R.id.name);
        TextView time = convertView.findViewById(R.id.time);
        TextView cost = convertView.findViewById(R.id.cost);
        CheckBox favourite = convertView.findViewById(R.id.favourite);


        name.setText(placeArrayList.get(position).getName());
        time.setText(placeArrayList.get(position).getTime());
        cost.setText(placeArrayList.get(position).getCost());



        if (user.getFavouritePlaces().contains(position))
            favourite.setChecked(true);

        favourite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    user.getFavouritePlaces().add(position);
                }else{
                    user.getFavouritePlaces().remove(Integer.valueOf(position));
                }
                Log.i("ok", user.getFavouritePlaces().toString());
            }
        });

        return convertView;
    }

    public User getUser() {
        return user;
    }

    public PlaceAdapter(Context context, ArrayList<Place> placeArrayList, User user) {
        super(context, 0, placeArrayList);
        this.context = context;
        this.placeArrayList = placeArrayList;
        this.user = user;
    }

}
