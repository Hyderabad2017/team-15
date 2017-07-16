package com.example.ranjith.united;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Bases extends BaseAdapter{

    Context context;
    ArrayList<Person> arrayList;
    public Bases(Context context,ArrayList<Person> arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.activity_bases,null,true);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        TextView textView=(TextView)view.findViewById(R.id.name_list);
        TextView textView1=(TextView)view.findViewById(R.id.phone_list);
        TextView textView2=(TextView)view.findViewById(R.id.gender_list);
        textView.setText(arrayList.get(position).getName());
        textView1.setText(arrayList.get(position).getPhone());
        textView2.setText(arrayList.get(position).getGender());
        String x=arrayList.get(position).getStatus();

        if (x.equalsIgnoreCase("yes")) {
            imageView.setImageResource(R.drawable.green_dot);
        } else if (arrayList.get(position).getStatus().equalsIgnoreCase("no")) {
            imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.red_dot));
        }

        return view;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
