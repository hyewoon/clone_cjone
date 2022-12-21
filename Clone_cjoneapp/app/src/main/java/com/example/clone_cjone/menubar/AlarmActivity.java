package com.example.clone_cjone.menubar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.clone_cjone.R;
import com.example.clone_cjone.cvg.CgvAdapter;

import java.util.ArrayList;

public class AlarmActivity extends AppCompatActivity {
    AlarmAdapter adapter;
    RecyclerView recv_alarm;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();
        //액티비티에서는 getLayoutinflater가져와야 한다
        LayoutInflater inflater = getLayoutInflater();
        recv_alarm = findViewById(R.id.recv_alarm);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recv_alarm.setLayoutManager(manager);
        recv_alarm.setHasFixedSize(true);
        adapter = new AlarmAdapter(inflater);
        recv_alarm.setAdapter(adapter);
       /* recv_alarm.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        LayoutInflater inflater = getLayoutInflater();
        *//* CgvAdapter adapter =new CgvAdapter(inflater,list1,context);*//*
        adapter = new AlarmAdapter(inflater);
        recv_alarm.setAdapter(adapter);
        //리사이클러뷰: arraylist이용해서 값 담기
*/


    }




}