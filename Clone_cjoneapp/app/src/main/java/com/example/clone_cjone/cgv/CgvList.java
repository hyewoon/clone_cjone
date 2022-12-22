package com.example.clone_cjone.cgv;

import com.example.clone_cjone.R;

import java.util.ArrayList;

public class CgvList {

     public ArrayList<CgvDTO> setList() {

          ArrayList<CgvDTO> list_c = new ArrayList<>();
          list_c.add(new CgvDTO(R.drawable.movie1,1,"아바타-물의 길","예매율 84.22%"));
          list_c.add(new CgvDTO(R.drawable.movie2,2,"영웅", "예매율 9.38%"));
          list_c. add(new CgvDTO(R.drawable.movie3,3,"올빼미", "예매율 1.41%"));
          list_c.add(new CgvDTO(R.drawable.movie4,4,"오늘밤", "예매율 1.34%%"));
          list_c.add(new CgvDTO(R.drawable.movie5,5,"신비아파트", "예매율 0.91%"));

          return list_c;
     }
}