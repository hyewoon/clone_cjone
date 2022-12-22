package com.example.clone_cjone.cgv;

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
    ArrayList<CgvDTO> list;

    public CgvAdapter(LayoutInflater inflater, ArrayList<CgvDTO> list) {
        this.inflater = inflater;
        this.list = list;

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

        h.imgv_poster.setImageResource(list.get(p).getImgRes());
        h.tv_rank.setText(String.valueOf(list.get(p).getRank()));
        h.tv_title.setText(list.get(p).getTitle());
        h.tv_ticket.setText(list.get(p).getBox_office());

    }

    @Override
    public int getItemCount() {
        return list.size();
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
