package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule;

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
import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule.test_scheduleAdapter.test_ScheduleAdapter;
import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.Schedule;
import com.example.asm_nguyenhnpk02250.Model.Schedules;
import com.example.asm_nguyenhnpk02250.Model.TestSchedules;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragment_test_schedule extends Fragment {
    private RecyclerView rcv_test_schedule;
    test_ScheduleAdapter test_scheduleAdapter;
    ArrayList<TestSchedules> list;
    public ArrayList<TestSchedules> testSchedules;
    MainActivity mainActivity;
    String ID;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_test_schedule, container, false);
        rcv_test_schedule = view.findViewById(R.id.rcv_test_schedule);
        mainActivity = (MainActivity) getActivity();
        ID = mainActivity.user.getClassroom_ID();
        list = new ArrayList<>();
        testSchedules = new ArrayList<>();
        getdata();
        return view;
    }
    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<TestSchedules>> response = service.getTestSchedule();
        response.enqueue(new Callback<ArrayList<TestSchedules>>() {
            @Override
            public void onResponse(Call<ArrayList<TestSchedules>> call, Response<ArrayList<TestSchedules>> response) {
                list = response.body();
                if(list == null || list.isEmpty()){
                    return;
                }
                for(TestSchedules mschedule : list){
                    if(ID.equals(mschedule.getClassroom_ID())){
                        testSchedules.add(mschedule);
                    }
                }
                if (testSchedules == null || testSchedules.isEmpty()){
                    Toast.makeText(mainActivity, "Bạn không có lịch thi trong thời gian tới ",Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(mainActivity, "listschedule : " + list.size(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(mainActivity, "list"+schedules.size(),Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rcv_test_schedule.setLayoutManager(linearLayoutManager);
                test_scheduleAdapter = new test_ScheduleAdapter(getContext(),testSchedules);
                rcv_test_schedule.setAdapter(test_scheduleAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<TestSchedules>> call, Throwable t) {
                Toast.makeText(mainActivity, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
