package com.example.clone_cjone.cvg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clone_cjone.R;

import java.util.ArrayList;

public class CgvAdapter  extends RecyclerView.Adapter<CgvAdapter.CViewHolder> {

    LayoutInflater inflater;
    ArrayList<CgvDTO> list1;
  //  private Context context;



    public CgvAdapter(LayoutInflater inflater, ArrayList<CgvDTO> list1) {
        this.inflater = inflater;
        this.list1 = list1;
    }


    @NonNull
    @Override
    public CViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (ViewGroup)inflater.inflate(R.layout.item_recv_cgv,parent,false);
        CViewHolder viewHolder =new CViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CViewHolder h, int p) {
        h.imgv_poster.setImageResource(list1.get(p).getImgRes());
        h.tv_rank.setText(list1.get(p).getRank());
        h.tv_title.setText(list1.get(p).getTitle());
        h.tv_ticket.setText(list1.get(p).getBox_office());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class CViewHolder  extends RecyclerView.ViewHolder {

        ImageView imgv_poster;
        TextView tv_rank, tv_title, tv_ticket;


        public CViewHolder(@NonNull View v) {
            super(v);
            imgv_poster =v.findViewById(R.id.imgv_poster);
            tv_rank =v.findViewById(R.id.tv_rank);
            tv_title =v.findViewById(R.id.tv_title);
            tv_ticket =v.findViewById(R.id.tv_ticket);

        }
    }
}
