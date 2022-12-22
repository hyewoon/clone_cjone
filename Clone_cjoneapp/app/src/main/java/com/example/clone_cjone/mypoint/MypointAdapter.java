package com.example.clone_cjone.mypoint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clone_cjone.R;

import java.util.ArrayList;

public class MypointAdapter extends RecyclerView.Adapter<MypointAdapter.MViewHolder> {
    LayoutInflater inflater;
    ArrayList<MypointDTO> list;

    public MypointAdapter(LayoutInflater inflater, ArrayList<MypointDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_mypoint,parent,false);
        MViewHolder viewHolder = new MViewHolder(v);
        return viewHolder ;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder h, int i) {
        h.date.setText(list.get(i).getDate());
        h.reward.setText(list.get(i).getReward());
        h.point.setText(list.get(i).getPoint());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder {
        TextView date, reward, point;

        public MViewHolder(@NonNull View v) {
            super(v);
            date = v.findViewById(R.id.date);
            reward = v.findViewById(R.id.reward);
            point = v.findViewById(R.id.point);
        }
    }
}
