package com.example.clone_cjone.Event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.clone_cjone.R;

public class EventActivity extends AppCompatActivity  implements View.OnClickListener {

    ImageView before, home, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent  intent = getIntent();

        before =findViewById(R.id.before);
        home =findViewById(R.id.home);
        menu =findViewById(R.id.menu);

        before.setOnClickListener(this);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.before){
            onBackPressed();

        }else if(v.getId() == R.id.home){
            onBackPressed();
        }

    }
}