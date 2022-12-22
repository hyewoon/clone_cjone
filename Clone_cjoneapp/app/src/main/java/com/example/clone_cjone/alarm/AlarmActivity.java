package com.example.clone_cjone.alarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clone_cjone.R;
import com.example.clone_cjone.cgv.CgvAdapter;
import com.example.clone_cjone.menubar.MenuActivity;

import java.util.ArrayList;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView before, home, menu;
    AlarmAdapter adapter;
    RecyclerView recv_alarm;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();

        recv_alarm =findViewById(R.id.recv_alarm);
        before= findViewById(R.id.before);
        home= findViewById(R.id.home);
        menu= findViewById(R.id.menu);

        before.setOnClickListener(this);
        home.setOnClickListener(this);
        menu.setOnClickListener(this);


  /*     recv_alarm = findViewById(R.id.recv_alarm);
        recv_alarm.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        AlarmAdapter adapter = new AlarmAdapter(getLayoutInflater());
        recv_alarm.setAdapter(adapter);*/


        ArrayList<AlarmDTO> list_a= new AlarmList().alarm();
        LayoutInflater inflater = getLayoutInflater();
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recv_alarm.setLayoutManager(manager);
        recv_alarm.setHasFixedSize(true);
        adapter = new AlarmAdapter(inflater,list_a);
        recv_alarm.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.before){
            onBackPressed();
        }else if(v.getId()==R.id.home){
            onBackPressed();
        }else if(v.getId() ==R.id.menu){
            Intent intent = new Intent(AlarmActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }


}