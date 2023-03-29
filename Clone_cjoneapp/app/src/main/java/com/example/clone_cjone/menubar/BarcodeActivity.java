package com.example.clone_cjone.menubar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clone_cjone.R;

public class BarcodeActivity extends AppCompatActivity  {

    ImageView close;
    TextView barcode_point;

    int point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);


        close= findViewById(R.id.close);
        barcode_point= findViewById(R.id.barcode_point);

        Intent intent =getIntent();
        point = intent.getIntExtra("point" ,-1);
        barcode_point.setText(point+"P");


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }

}