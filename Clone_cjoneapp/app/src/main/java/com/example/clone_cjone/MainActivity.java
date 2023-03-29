package com.example.clone_cjone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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
    ImageView imgv_barcode, imgv_alarm,imgv_menu, imgv_nextbar, imgv_logo;
    RelativeLayout rl_logo;
    FrameLayout frame_back;
    LinearLayout ln_event, ln_fun_town, ln_finance, click_ad1, click_ad2, click_ad3;
    TabLayout tab_layout;
    CgvAdapter adapter;
    TextView tv_main_point;
    Toolbar toolbar;

    SharedPreferences pref;  // 프리퍼런스
    SharedPreferences.Editor editor;  //에디터


    int cnt =0;
    int point = 1000; //포인트 저장
    int total_point = 0;
    int no1= 0;
    int no2 =0;
    int no3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tv_main_point = findViewById(R.id.tv_main_point);    
    recv_cgv = findViewById(R.id.recv_cgv);
    imgv_barcode = findViewById(R.id.imgv_barcode);
    imgv_alarm = findViewById(R.id.imgv_alarm);
    imgv_menu = findViewById(R.id.imgv_menu);
    imgv_nextbar =findViewById(R.id.imgv_nextbar);
    imgv_logo = findViewById(R.id.imgv_logo);

    tab_layout = findViewById(R.id.tab_layout);
    rl_logo = findViewById(R.id.rl_logo);
    ln_event = findViewById(R.id.ln_event);
    ln_fun_town = findViewById(R.id.ln_fun_town);
    ln_finance = findViewById(R.id.ln_finance);
    frame_back = findViewById(R.id.frame_back);
    click_ad1 = findViewById(R.id.click_ad1);
    click_ad2 = findViewById(R.id.click_ad2);
    click_ad3 = findViewById(R.id.click_ad3);
    tv_main_point = findViewById(R.id.tv_main_point);

//클릭이벤트
    imgv_barcode.setOnClickListener(this);
    imgv_alarm.setOnClickListener(this);
    imgv_menu.setOnClickListener(this);
    rl_logo.setOnClickListener(this);
    ln_event.setOnClickListener(this);
    ln_fun_town.setOnClickListener(this);
    ln_finance.setOnClickListener(this);

    tv_main_point.setText(point +"P");
    tv_main_point.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("로그", "onClick: " + "클릭");
            connActivity(new MypointActivity());
           // Intent intent = new Intent(MainActivity.this,MypointActivity.class);
        }
    });

        //1.Shared Preference 초기화
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        //2. 저장해 둔 값 불러오기
        point = pref.getInt("point",1000);

        //3. 앱을 새로 켜면 이전에 저장해둔 값이 표시됨
        editor.commit();

    click_ad1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(no1==0) {
                pointChange(tv_main_point);
                connect(new AdActivity1());
                no1++;
            }else if(no1>=1){
                Toast.makeText(MainActivity.this, "이미 적립되었습니다.", Toast.LENGTH_SHORT).show();
                connect(new AdActivity1());
            }

        }
    });

    click_ad2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(no2==0){
                pointChange(tv_main_point);
                no2++;
            }else if(no2>=1){
                Toast.makeText(MainActivity.this, "이미 적립되었습니다.", Toast.LENGTH_SHORT).show();
            }

        }
    });

    click_ad3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(no3==0){
                pointChange(tv_main_point);
                no3++;
            }else if(no3>=1){
                Toast.makeText(MainActivity.this, "이미 적립되었습니다.", Toast.LENGTH_SHORT).show();
            }
            }

    });






    // 버튼 클릭시 이미지 전환
    imgv_nextbar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        //    Log.d("로그", "onClick: " + cnt);

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


    //배경화면은 id값 없으니까 고정값을 주려면 getTag()로 지정해서 가지고 온다
    frame_back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(frame_back.getTag().toString().equals("1")){
                  Toast.makeText(MainActivity.this, "화면 준비중입니다.", Toast.LENGTH_SHORT).show();
            }else if(frame_back.getTag().toString().equals("2")){
                  Toast.makeText(MainActivity.this, "화면 준비중입니다.", Toast.LENGTH_SHORT).show();
            }else if(frame_back.getTag().toString().equals("3")){
                connActivity(new ExhibitActivity());
            }else if(frame_back.getTag().toString().equals("4")){
                  Toast.makeText(MainActivity.this, "화면 준비중입니다.", Toast.LENGTH_SHORT).show();
            }
        }
    });

        //tab_layout
    tab_layout.addTab(tab_layout.newTab().setText("CJ"));
    tab_layout.addTab(tab_layout.newTab().setText("CGV"));
    tab_layout.addTab(tab_layout.newTab().setText("올리브영"));
    tab_layout.addTab(tab_layout.newTab().setText("CJ외식"));

    // 첫 화면에 첫번째 fragment 가 붙어 있어야 한다
    getSupportFragmentManager().beginTransaction().replace(R.id.frame_giftcard,new CjFragment()).commit();

    tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
           int position = tab.getPosition();
            if(position == 0){
                Log.d("로그", "onTabSelected: " + position);
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


    //리사이클러뷰, 어댑터 연결
    ArrayList<CgvDTO> list_c = new CgvList().setList();

    LayoutInflater inflater =getLayoutInflater();
    LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
    recv_cgv.setLayoutManager(manager);
    recv_cgv.setHasFixedSize(true);
    adapter = new CgvAdapter(inflater,list_c);
    recv_cgv.setAdapter(adapter);

    }

    //액티비티 간 연결 : Intent
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.rl_logo ){
           //Activity activity = new MypointActivity();
           connActivity(new MypointActivity());
            Log.d("로그", "onClick: " + "연결됨1");


        }else if(v.getId() == R.id.imgv_barcode ){
            connActivity(new BarcodeActivity());
            Log.d("로그", "onClick: " + "연결됨2");


        }else if(v.getId() == R.id.imgv_alarm) {
          Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
          startActivity(intent);

        } else  if(v.getId()== R.id.imgv_menu){
            connActivity(new MenuActivity());
        }
    }
    //Inetent 기본 메소드
    public void connect(Activity activity){
        Intent intent = new Intent(MainActivity.this,activity.getClass());
        startActivity(intent);

    }

    //Intent 포인트 전달 메소드
    public void connActivity(Activity activity){

       Intent intent = new Intent(MainActivity.this, activity.getClass());
       intent.putExtra("point", point);
       startActivity(intent);
    }

    //포인트 변경 메소드 - 한번 클릭되면 다시는 선택되지 못함
        public void pointChange(TextView text){

        point += 10;
        text.setText(point + "P");
        Toast.makeText(this, "10포인트 적립이 요청되었습니다.", Toast.LENGTH_SHORT).show();
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

