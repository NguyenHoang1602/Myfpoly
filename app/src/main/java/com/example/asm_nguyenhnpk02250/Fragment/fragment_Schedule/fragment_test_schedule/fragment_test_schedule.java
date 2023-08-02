package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule;

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
import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule.test_scheduleAdapter.test_ScheduleAdapter;
import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.R;

import java.util.ArrayList;

public class fragment_test_schedule extends Fragment {
    private RecyclerView rcv_test_schedule;
    test_ScheduleAdapter test_scheduleAdapter;
    ArrayList<Schedule> list;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_test_schedule, container, false);
        rcv_test_schedule = view.findViewById(R.id.rcv_test_schedule);
        init();
        setAdapter();
        return view;
    }
    private void init() {
        list = new ArrayList<>();
        list.add(new Schedule("T303C5","23-07-2023","T303","PMQT","Android Networking","MD17303","dinhnt24","17:30 - 19:30"));
        list.add(new Schedule("T303C5","25-07-2023","T303","PMQT","Khởi Sự Doanh Nghiệp","MD17303","nganntk24","17:30 - 19:30"));


    }
    public void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcv_test_schedule.setLayoutManager(linearLayoutManager);
        test_scheduleAdapter = new test_ScheduleAdapter(getContext(),list);
        rcv_test_schedule.setAdapter(test_scheduleAdapter);

    }
}
