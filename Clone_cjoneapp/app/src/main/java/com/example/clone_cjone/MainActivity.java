package com.example.clone_cjone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.clone_cjone.Event.EventActivity;
import com.example.clone_cjone.barcode.BarcodeActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recv_cgv;
    ImageView imgv_barcode, imgv_alarm,imgv_menu, imgv_nextbar;
    RelativeLayout rl_logo;
    FrameLayout frame_back;
    LinearLayout ln_event, ln_fun_town, ln_finance;
    TabLayout tab_layout;

    int cnt = 0;
    int position = 0;
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


    //클릭이벤트
        imgv_barcode.setOnClickListener(this);
        imgv_alarm.setOnClickListener(this);
        rl_logo.setOnClickListener(this);
        imgv_menu.setOnClickListener(this);
        ln_event.setOnClickListener(this);
        ln_fun_town.setOnClickListener(this);
        ln_finance.setOnClickListener(this);

       // 버튼 클릭시 이미지 전환
        imgv_nextbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("로그", "onClick: " + cnt);

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


        //리사이클러뷰, 어댑터 연결
        recv_cgv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recv_cgv.setAdapter(new CgvAdapter(getLayoutInflater()));


        //tab_layout 
        tab_layout.addTab(tab_layout.newTab().setText("CJ"));
        tab_layout.addTab(tab_layout.newTab().setText("CGV"));
        tab_layout.addTab(tab_layout.newTab().setText("올리브영"));
        tab_layout.addTab(tab_layout.newTab().setText("CJ외식"));

        //tab 선택시 fragment 연결
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("로그", "onTabSelected: " + "텝");
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new CjFragment()).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //배경화면은 id값 없으니까 고정값을 주려면 getTag()로 지정해서 가지고 온다
        frame_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frame_back.getTag().toString().equals("1")){
                    
                    Toast.makeText(MainActivity.this, "11", Toast.LENGTH_SHORT).show();
                }else if(frame_back.getTag().toString().equals("2")){
                    Toast.makeText(MainActivity.this, "22", Toast.LENGTH_SHORT).show();
                }else if(frame_back.getTag().toString().equals("3")){
                    Toast.makeText(MainActivity.this, "33", Toast.LENGTH_SHORT).show();
                }else if(frame_back.getTag().toString().equals("4")){
                    Toast.makeText(MainActivity.this, "44", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //액티비티 간 연결 : Intent
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

        }else if(v.getId() == R.id.imgv_menu){
            Activity activity = new DetailActivity();
            connActivity(activity);

        }else if(v.getId() == R.id.ln_event){
            Activity activity = new EventActivity();
            connActivity(activity);

        } else if(v.getId() == R.id.ln_fun_town){
            Activity activity = new DetailActivity();
            connActivity(activity);

        }   else if(v.getId() == R.id.ln_finance) {
            Activity activity = new DetailActivity();
            connActivity(activity);
        }
    }

    //Intent 메소드
    public void connActivity(Activity activity){

       Intent intent = new Intent(MainActivity.this, activity.getClass());
        startActivity(intent);
    }
    
    

    //커스텀 액션 바
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(false); //
        actionBar.setDisplayShowTitleEnabled(false);//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(true);  //홈 아이콘을 숨김처리합니다.

*/
    /*

     ActionBar actionBar = getSupportActionBar();
     // ActionBar바 사용하기 위한 설정
        actionBar.setDisplayShowCustomEnabled(true); //커스텀한 내용이 사용될 수 있도록 true
        actionBar.setDisplayHomeAsUpEnabled(false); //
        actionBar.setDisplayShowTitleEnabled(false);//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);  //홈 아이콘을 숨김처리합니다.

        //layout을 action bar에 연결
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);

        actionBar.setCustomView(actionbar);



    return false;

    }

     */


}

