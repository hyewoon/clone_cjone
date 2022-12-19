package com.example.clone_cjone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clone_cjone.R;

public class CgvAdapter  extends RecyclerView.Adapter<CgvAdapter.CViewHolder> {

    LayoutInflater inflater;

    public CgvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public CViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CViewHolder viewHolder = new CViewHolder(inflater.inflate(R.layout.item_recv_cgv,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class CViewHolder  extends RecyclerView.ViewHolder {

        public CViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
