package com.example.clone_cjone.alarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clone_cjone.R;

import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AViewHolder> {
    LayoutInflater inflater;
    ArrayList<AlarmDTO> list_a;

    public AlarmAdapter(LayoutInflater inflater, ArrayList<AlarmDTO> list_a) {
        this.inflater = inflater;
        this.list_a = list_a;
    }

    @NonNull
    @Override
    public AViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.item_recv_alarm, parent,false);
        AViewHolder viewHolder = new AViewHolder(v);
        return viewHolder;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull AViewHolder h, int i) {
        h.alarm_title.setText(list_a.get(i).getTitle());
        h.content1.setText(list_a.get(i).getContent1());
        h.content2.setText(list_a.get(i).getContent2());
        h.alarm_time.setText(list_a.get(i).getTime());
    }

    @Override
    public int getItemCount() {
        return list_a.size();
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