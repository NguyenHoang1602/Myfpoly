package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule.ScheduleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Model.NotificationStudy;
import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.Model.Schedules;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.NotificationViewHolder>{

    private Context context;
    private ArrayList<Schedules> list;

    public ScheduleAdapter(Context context, ArrayList<Schedules> list) {
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

        final Schedules schedules = list.get(position);
        holder.tv_subject.setText(schedules.getName());
        holder.tv_room.setText(schedules.getRoom_Name());
        holder.tv_time.setText(schedules.getTime());
        holder.tv_amphitheater.setText(schedules.getAmphitheater_Name());
        holder.tv_date.setText(schedules.getDate());
        holder.tv_lecturers.setText(schedules.getLecturers_ID());
        holder.tv_subject_ID.setText(schedules.getSubject_ID());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject, tv_room, tv_time, tv_amphitheater, tv_date, tv_lecturers,tv_subject_ID;
        LinearLayout layout_item;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_room = itemView.findViewById(R.id.tv_Room);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_amphitheater = itemView.findViewById(R.id.tv_Amphitheater);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_lecturers = itemView.findViewById(R.id.tv_Lecturers);
            layout_item = itemView.findViewById(R.id.tab_layout_Schedule);
            tv_subject_ID = itemView.findViewById(R.id.tv_Subject_ID);

        }
    }
}

