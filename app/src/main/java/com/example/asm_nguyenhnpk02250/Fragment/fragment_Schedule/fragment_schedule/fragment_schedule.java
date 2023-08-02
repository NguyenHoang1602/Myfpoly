package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule.ScheduleAdapter.ScheduleAdapter;
import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class fragment_schedule extends Fragment {
    private RecyclerView rcv_schedule;
    ScheduleAdapter scheduleAdapter;
    ArrayList<Schedule> list;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_schedule, container, false);
        rcv_schedule = view.findViewById(R.id.rcv_schedule);
        return view;
    }

    public void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcv_schedule.setLayoutManager(linearLayoutManager);
        scheduleAdapter = new ScheduleAdapter(getContext(),list);
        rcv_schedule.setAdapter(scheduleAdapter);

    }
}
