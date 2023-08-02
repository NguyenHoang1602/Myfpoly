package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule.ScheduleAdapter.ScheduleAdapter;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_study.HomeAdapter.HomeAdapter;
import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.NotificationStudy;
import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.Model.Schedules;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragment_schedule extends Fragment {
    private RecyclerView rcv_schedule;
    ScheduleAdapter scheduleAdapter;
    ArrayList<Schedules> schedules;
    MainActivity mainActivity;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_schedule, container, false);
        rcv_schedule = view.findViewById(R.id.rcv_schedule);
        getdata();
        return view;
    }
    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<Schedules>> response = service.getSchedule();
        response.enqueue(new Callback<ArrayList<Schedules>>() {
            @Override
            public void onResponse(Call<ArrayList<Schedules>> call, Response<ArrayList<Schedules>> response) {
                schedules = response.body();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rcv_schedule.setLayoutManager(linearLayoutManager);
                scheduleAdapter = new ScheduleAdapter(getContext(),schedules);
                rcv_schedule.setAdapter(scheduleAdapter);
                //Toast.makeText(LoginScreen.this, "" + list.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Schedules>> call, Throwable t) {
                Toast.makeText(mainActivity, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
