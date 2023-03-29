package com.example.clone_cjone.menubar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clone_cjone.R;
import com.example.clone_cjone.alarm.AlarmActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView close, home, alarm;
    TextView menu_point;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        close = findViewById(R.id.close);
        home = findViewById(R.id.home);
        alarm = findViewById(R.id.alarm);
        menu_point = findViewById(R.id.menu_point);

        Intent intent = getIntent();
        point = intent.getIntExtra("point", -1);
        menu_point.setText(point + "P");


        close.setOnClickListener(this);
        home.setOnClickListener(this);
        alarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.close){
            onBackPressed();
        }else if(v.getId() == R.id.home){
            onBackPressed();
        }else if(v.getId() == R.id.alarm){
            Intent intent = new Intent(MenuActivity.this, AlarmActivity.class);
            startActivity(intent);

        }
    }
}