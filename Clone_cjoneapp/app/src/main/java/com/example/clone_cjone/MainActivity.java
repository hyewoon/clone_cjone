package com.example.clone_cjone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.clone_cjone.Giftcard.FoodFragment;
import com.example.clone_cjone.Giftcard.CgvFragment;
import com.example.clone_cjone.Giftcard.CjFragment;
import com.example.clone_cjone.Giftcard.OliveyoungFragment;
import com.example.clone_cjone.cgv.CgvAdapter;
import com.example.clone_cjone.cgv.CgvList;
import com.example.clone_cjone.cgv.CgvDTO;
import com.example.clone_cjone.menubar.BarcodeActivity;
import com.example.clone_cjone.alarm.AlarmActivity;
import com.example.clone_cjone.menubar.MenuActivity;
import com.example.clone_cjone.mypoint.MypointActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recv_cgv;
    ImageView imgv_barcode, imgv_alarm,imgv_menu, imgv_nextbar;
    RelativeLayout rl_logo;
    FrameLayout frame_back;
    LinearLayout ln_event, ln_fun_town, ln_finance;
    TabLayout tab_layout;
    CgvAdapter adapter;

    int cnt =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recv_cgv = findViewById(R.id.recv_cgv);
    imgv_barcode = findViewById(R.id.imgv_barcode);
    imgv_alarm = findViewById(R.id.imgv_alarm);
    imgv_menu = findViewById(R.id.imgv_menu);
    imgv_nextbar =findViewById(R.id.imgv_nextbar);
    tab_layout = findViewById(R.id.tab_layout);
    rl_logo = findViewById(R.id.rl_logo);
    ln_event = findViewById(R.id.ln_event);
    ln_fun_town = findViewById(R.id.ln_fun_town);
    ln_finance = findViewById(R.id.ln_finance);
    frame_back = findViewById(R.id.frame_back);

//???????????????
    imgv_barcode.setOnClickListener(this);
    imgv_alarm.setOnClickListener(this);
    imgv_menu.setOnClickListener(this);
    rl_logo.setOnClickListener(this);
    ln_event.setOnClickListener(this);
    ln_fun_town.setOnClickListener(this);
    ln_finance.setOnClickListener(this);


    // ?????? ????????? ????????? ??????
    imgv_nextbar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        //    Log.d("??????", "onClick: " + cnt);

            if(cnt == 0){
                frame_back.setBackgroundResource(R.drawable.main1);
                frame_back.setTag("1");
            }else if(cnt==1){
                frame_back.setBackgroundResource(R.drawable.main2);
                frame_back.setTag("2");
            }else if(cnt==2){
                frame_back.setBackgroundResource(R.drawable.main3);
                frame_back.setTag("3");
            }else if (cnt==3){
                frame_back.setBackgroundResource(R.drawable.main4);
                frame_back.setTag("4");
            }
            cnt ++;
            if(cnt>3) cnt= 0;
        }
    });


    //??????????????? id??? ???????????? ???????????? ????????? getTag()??? ???????????? ????????? ??????
    frame_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(frame_back.getTag().toString().equals("1")){
                  Toast.makeText(MainActivity.this, "?????? ??????????????????.", Toast.LENGTH_SHORT).show();
            }else if(frame_back.getTag().toString().equals("2")){
                  Toast.makeText(MainActivity.this, "?????? ??????????????????.", Toast.LENGTH_SHORT).show();
            }else if(frame_back.getTag().toString().equals("3")){
                Activity activity = new ExhibitActivity();
                connActivity(activity);
            }else if(frame_back.getTag().toString().equals("4")){
                  Toast.makeText(MainActivity.this, "?????? ??????????????????.", Toast.LENGTH_SHORT).show();
            }
        }
    });

        //tab_layout
    tab_layout.addTab(tab_layout.newTab().setText("CJ"));
    tab_layout.addTab(tab_layout.newTab().setText("CGV"));
    tab_layout.addTab(tab_layout.newTab().setText("????????????"));
    tab_layout.addTab(tab_layout.newTab().setText("CJ??????"));

    // ??? ????????? ????????? fragment ??? ?????? ????????? ??????
    getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new CjFragment()).commit();

    tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
           int position = tab.getPosition();
            if(position == 0){
                Log.d("??????", "onTabSelected: " + position);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new CjFragment()).commit();
            }else if(position ==1){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new CgvFragment()).commit();
            }else if(position ==2){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new OliveyoungFragment()).commit();
            }else if(position ==3){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new FoodFragment()).commit();
            }

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }
        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    });


    //??????????????????, ????????? ??????
    ArrayList<CgvDTO> list_c = new CgvList().setList();

    LayoutInflater inflater =getLayoutInflater();
    LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
    recv_cgv.setLayoutManager(manager);
    recv_cgv.setHasFixedSize(true);
    adapter = new CgvAdapter(inflater,list_c);
    recv_cgv.setAdapter(adapter);

    }

    //???????????? ??? ?????? : Intent
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.rl_logo ){
           Activity activity = new MypointActivity();
           connActivity(activity);

        }else if(v.getId() == R.id.imgv_barcode ){
            Activity activity = new BarcodeActivity();
            connActivity(activity);

        }else if(v.getId() == R.id.imgv_alarm) {
            Activity activity = new AlarmActivity();
            connActivity(activity);

        } else  if(v.getId()== R.id.imgv_menu){
            Activity activity = new MenuActivity();
            connActivity(activity);
        }
    }

    //Intent ?????????
    public void connActivity(Activity activity){

       Intent intent = new Intent(MainActivity.this, activity.getClass());
        startActivity(intent);
    }
    
    

    //????????? ?????? ???
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(false); //
        actionBar.setDisplayShowTitleEnabled(false);//???????????? ???????????? ????????? ??????????????? ???????????????.
        actionBar.setDisplayShowHomeEnabled(true);  //??? ???????????? ?????????????????????.

*/
    /*

     ActionBar actionBar = getSupportActionBar();
     // ActionBar??? ???????????? ?????? ??????
        actionBar.setDisplayShowCustomEnabled(true); //???????????? ????????? ????????? ??? ????????? true
        actionBar.setDisplayHomeAsUpEnabled(false); //
        actionBar.setDisplayShowTitleEnabled(false);//???????????? ???????????? ????????? ??????????????? ???????????????.
        actionBar.setDisplayShowHomeEnabled(false);  //??? ???????????? ?????????????????????.

        //layout??? action bar??? ??????
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);

        actionBar.setCustomView(actionbar);



    return false;

    }

     */


}

