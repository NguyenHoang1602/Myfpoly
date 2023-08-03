package com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_work;

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

import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_work.WorkAdapter.WorkAdapter;
import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.NotificationAction;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragment_notification_work extends Fragment {

    private RecyclerView rcv_notification_study;
    WorkAdapter workAdapter;
    ArrayList<NotificationAction> list;
    MainActivity mainActivity;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_notification_work, container, false);
        rcv_notification_study = view.findViewById(R.id.rcv_notification_work);
        list = new ArrayList<>();
        getdata();
        return view;
    }

    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<NotificationAction>> response = service.getNotificationAction();
        response.enqueue(new Callback<ArrayList<NotificationAction>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationAction>> call, Response<ArrayList<NotificationAction>> response) {
                list = response.body();
                if(list == null || list.isEmpty()){
                    Toast.makeText(getContext(), "Khong co thong bao hoat dong",Toast.LENGTH_SHORT).show();
                    return;
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rcv_notification_study.setLayoutManager(linearLayoutManager);
                workAdapter = new WorkAdapter(getContext(),list);
                rcv_notification_study.setAdapter(workAdapter);
                //Toast.makeText(LoginScreen.this, "" + list.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationAction>> call, Throwable t) {
                Toast.makeText( mainActivity, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
