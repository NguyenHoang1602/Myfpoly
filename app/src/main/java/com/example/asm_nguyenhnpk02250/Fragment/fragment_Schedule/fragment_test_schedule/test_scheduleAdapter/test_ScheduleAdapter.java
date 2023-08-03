package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule.test_scheduleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.Model.Schedules;
import com.example.asm_nguyenhnpk02250.Model.TestSchedules;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class test_ScheduleAdapter extends RecyclerView.Adapter<test_ScheduleAdapter.NotificationViewHolder>{

    private final ArrayList<TestSchedules> list;
    private Context context;

    public test_ScheduleAdapter(Context context, ArrayList<TestSchedules> list) {
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
        final TestSchedules testSchedules = list.get(position);
        holder.tv_subject.setText(testSchedules.getName());
        holder.tv_room.setText(testSchedules.getRoom_Name());
        holder.tv_time.setText(testSchedules.getTime());
        holder.tv_amphitheater.setText(testSchedules.getAmphitheater_Name());
        holder.tv_date.setText(testSchedules.getDate());
        holder.tv_lecturers.setText(testSchedules.getLecturers_ID());
        holder.tv_subject_ID.setText(testSchedules.getSubject_ID());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject, tv_room, tv_time, tv_amphitheater, tv_date, tv_lecturers,tv_subject_ID;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_room = itemView.findViewById(R.id.tv_Room);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_amphitheater = itemView.findViewById(R.id.tv_Amphitheater);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_lecturers = itemView.findViewById(R.id.tv_Lecturers);
            tv_subject_ID = itemView.findViewById(R.id.tv_Subject_ID);

        }
    }
}

