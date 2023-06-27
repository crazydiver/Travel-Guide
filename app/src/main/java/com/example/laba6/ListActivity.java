package com.example.laba6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;
import java.util.Arrays;


public class ListActivity extends Activity{

    private boolean fav = false;

    private User getUser(){
        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable("user");
        return user;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        User user = getUser();
        ((TextView)findViewById(R.id.hellolay2)).setText("Привет, " + user.getFirst_name()+"!");
        ListView listView = findViewById(R.id.listview);
        listView.setClickable(true);
        PlaceAdapter placeAdapter = new PlaceAdapter(this, initList(), user);
        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, MapActivity.class);
                intent.putExtra("data",initList().get(position));
                startActivity(intent);
            }
        });
    }

    private ArrayList<Place> initList(){
        Place place1 = new Place(new Point( 55.752652,37.623086),"Собор Василия Блаженного – православный храм в центре Москвы, полное название которого звучит как Собор Покрова Пресвятой Богородицы, что на Рву. Памятник русской архитектуры XVI в. находится на Красной площади и включен в списки Всемирного наследия ЮНЕСКО. Собор представляет собой комплекс из одиннадцати церквей на едином подклете, среди которых центральная освящена в честь Покрова Богородицы.","Храм Василия Блаженного","500", "10:00-18:00");
        Place place2 = new Place(new Point(55.760221, 37.618561),"Большой театр - один из самых известных театров оперы и балета. Находится в Москве на Театральной площади. Он был построен по проекту архитектора Христиана Розберга в 1776-1789 г. и назывался тогда Большим Петровским театром. В 1805 г. здание театра сгорело, после чего К. Росси построил новое деревянное здание на Арбатской площади. Во время пожара 1812 г. оно также сгорело. В 1825 г. открылось новое здание театра, построенное по проекту О. Бове.","Большой театр", "зависит от спектакля", "11:00-20:00" );
        Place place3 = new Place(new Point(55.744561, 37.605463),"Храм Христа Спасителя, или Храм Рождества Христова, — кафедральный собор Русской православной церкви, расположенный в центральной части Москвы на улице Волхонке. Существующее сооружение, построенное в 1990-х годах, является воссозданием одноимённого храма, разрушенного в 1931 году. Самый большой православный храм России.","Храм Христа Спасителя","бесплатно","10:00-18:00");
        Place place4 = new Place(new Point(55.741556, 37.620028),"Государственная Третьяковская галерея — московский художественный музей, основанный в 1856 году купцом Павлом Третьяковым. В 1867-м галерея была открыта для посещения, а в 1892 году передана в собственность Москве. На момент передачи коллекция музея насчитывала 1276 картин, 471 рисунок, десять скульптур русских художников, а также 84 картины иностранных мастеров.","Третьяковская галерея","500","10:00-21:00");
        Place place5 = new Place(new Point(55.826398, 37.637875),"Выставка достижений народного хозяйства — крупнейший экспозиционный, музейный и рекреационный комплекс в мире. С момента открытия 1 августа 1939 года название менялось несколько раз — ВСХВ, ВДНХ СССР, ВВЦ. Сегодня ВДНХ — уникальное пространство музейно-выставочных проектов, международных деловых выставок и конгрессов, фестивалей и праздников.","ВДНХ","бесплтано","круглосуточно");
        Place place6 = new Place(new Point(55.741343, 37.610098),"Просто клуб, куда я иду тусить после того, как хакончу это ООООЧЕНЬ интересное дз","Клуб Live Stars","500","16:00-05:30");
        ArrayList<Place> places = new ArrayList<>(Arrays.asList(place1, place2, place3, place4, place5, place6));
        return places;
    }

    public void favBtn(View view){
        ListView listView = findViewById(R.id.listview);
        listView.setClickable(true);
        User user = ((PlaceAdapter)listView.getAdapter()).getUser();
        if (fav){
            PlaceAdapter placeAdapter = new PlaceAdapter(this, initList(), user);
            listView.setAdapter(placeAdapter);
            fav = false;
        }
        else{

            fav = true;
            ArrayList<Place> favPlaces = new ArrayList<>();
            for (Integer i: user.getFavouritePlaces()){
                favPlaces.add(initList().get(i));
            }
            PlaceAdapter placeAdapter = new PlaceAdapter(this, favPlaces, user);
            listView.setAdapter(placeAdapter);
        }
    }

}
