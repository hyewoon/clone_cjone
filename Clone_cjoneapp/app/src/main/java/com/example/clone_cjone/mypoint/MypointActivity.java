package com.example.clone_cjone.mypoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clone_cjone.R;
import com.example.clone_cjone.menubar.MenuActivity;

import java.util.ArrayList;

public class MypointActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView before, home, menu;
    TextView mypoint_point;
    Intent intent;
    RecyclerView recv_mypoint;

    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypoint);

        before = findViewById(R.id.before);
        home = findViewById(R.id.home);
        menu = findViewById(R.id.menu);
        mypoint_point = findViewById(R.id.mypoint_point);

        intent = getIntent();
        point= intent.getIntExtra("point", -1);
        mypoint_point.setText(point +"P");
        Log.d("로그", "onCreate: " + point);



        before.setOnClickListener(this);
        home.setOnClickListener(this);
        menu.setOnClickListener(this);


        ArrayList<MypointDTO> list = new ArrayList();
        list.add(new MypointDTO("2022.12.20", "광고 리워드", "+1P" ));
        list.add(new MypointDTO("2022.12.20", "광고 리워드", "+1P" ));
        list.add(new MypointDTO("2022.12.19", "구매 리워드", "+12P" ));
        list.add(new MypointDTO("2022.12.17", "광고 리워드", "+1P" ));
        list.add(new MypointDTO("2022.12.17", "광고 리워드", "+5P" ));
        list.add(new MypointDTO("2022.12.17", "광고 리워드", "+1P" ));
        list.add(new MypointDTO("2022.12.15", "구매 리워드", "+10P" ));
        list.add(new MypointDTO("2022.12.14", "광고 리워드", "+3P" ));
        list.add(new MypointDTO("2022.12.14", "광고 리워드", "+1P" ));
        list.add(new MypointDTO("2022.12.13", "구매 리워드", "+5P" ));

        LayoutInflater inflater =getLayoutInflater();
        recv_mypoint.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        MypointAdapter adapter = new MypointAdapter(inflater,list);
        recv_mypoint.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.before){
            onBackPressed();
        }else if(v.getId() == R.id.home){
            onBackPressed();
        }else if(v.getId() == R.id.menu){
            Intent intent =new Intent(MypointActivity.this, MenuActivity.class);
            startActivity(intent);
        }

    }
}