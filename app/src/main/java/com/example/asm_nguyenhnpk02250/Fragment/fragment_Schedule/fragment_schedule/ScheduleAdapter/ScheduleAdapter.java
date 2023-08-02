package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule.ScheduleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.NotificationViewHolder>{

    private Context context;
    private ArrayList<Schedule> list;

    public ScheduleAdapter(Context context, ArrayList<Schedule> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.tv_subject.setText(list.get(position).getSubject_ID());
        holder.tv_room.setText(list.get(position).getRoom_ID());
        holder.tv_time.setText(list.get(position).getSlot());
        holder.tv_amphitheater.setText(list.get(position).getAmphitheater_ID());
        holder.tv_date.setText(list.get(position).getDate());
        holder.tv_lecturers.setText(list.get(position).getLecturers_ID());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject, tv_room, tv_time, tv_amphitheater, tv_date, tv_lecturers;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_room = itemView.findViewById(R.id.tv_Room);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_amphitheater = itemView.findViewById(R.id.tv_Amphitheater);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_lecturers = itemView.findViewById(R.id.tv_Lecturers);

        }
    }
}

