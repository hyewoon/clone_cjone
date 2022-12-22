package com.example.clone_cjone.alarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clone_cjone.R;

import java.util.zip.Inflater;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AViewHolder> {
    LayoutInflater inflater;

    public AlarmAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public AViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.item_recv_alarm, parent,false);
        AViewHolder viewHolder = new AViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AViewHolder extends RecyclerView.ViewHolder {
        TextView alarm_title, content1, content2, alarm_time;

        public AViewHolder(@NonNull View v) {
            super(v);

            alarm_title = v.findViewById(R.id.alarm_title);
            content1 = v.findViewById(R.id.content1);
            content2 = v.findViewById(R.id.content2);
            alarm_time = v.findViewById(R.id.alarm_time);
        }
    }
}