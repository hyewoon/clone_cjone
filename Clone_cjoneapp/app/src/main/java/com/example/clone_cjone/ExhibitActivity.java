package com.example.clone_cjone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.clone_cjone.alarm.AlarmActivity;
import com.example.clone_cjone.menubar.MenuActivity;

public class ExhibitActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView before, home, menu;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit);

        before = findViewById(R.id.before);
        home =findViewById(R.id.home);
        menu =findViewById(R.id.menu);

        Intent intent = getIntent();
        point = intent.getIntExtra("point", -1);

        before.setOnClickListener(this);
        home.setOnClickListener(this);
        menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if(v.getId() == R.id.before){
                onBackPressed();
            }else if(v.getId()==R.id.home){
                onBackPressed();
            }else if(v.getId() ==R.id.menu){
                Intent intent = new Intent(ExhibitActivity.this, MenuActivity.class);
                intent.getIntExtra("point",point);
                startActivity(intent);
            }
        }


    }
