package com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_study.HomeAdapter.HomeAdapter;
import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.NotificationStudy;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragment_notification_study extends Fragment {
    private RecyclerView rcv_notification_study;
    private LinearLayout linearLayout;
    HomeAdapter homeAdapter;
    MainActivity mainActivity;
    ArrayList<NotificationStudy> notificationStudies;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_notification_study, container, false);
        rcv_notification_study = view.findViewById(R.id.rcv_notification_study);
        linearLayout = view.findViewById(R.id.linearNotification);
        notificationStudies = new ArrayList<>();
        getdata();
        return view;

    }

    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<NotificationStudy>> response = service.getNotificationStudy();
        response.enqueue(new Callback<ArrayList<NotificationStudy>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationStudy>> call, Response<ArrayList<NotificationStudy>> response) {
                notificationStudies = response.body();
                if(notificationStudies == null || notificationStudies.isEmpty()){
                    Toast.makeText(getContext(), "Khong co thong bao hoc tap",Toast.LENGTH_SHORT).show();
                    return;
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rcv_notification_study.setLayoutManager(linearLayoutManager);
                homeAdapter = new HomeAdapter(getContext(),notificationStudies);
                rcv_notification_study.setAdapter(homeAdapter);
                //Toast.makeText(LoginScreen.this, "" + list.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationStudy>> call, Throwable t) {
                Toast.makeText(mainActivity, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
