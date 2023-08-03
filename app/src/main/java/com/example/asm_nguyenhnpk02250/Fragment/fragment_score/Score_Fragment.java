package com.example.asm_nguyenhnpk02250.Fragment.fragment_score;

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

import com.example.asm_nguyenhnpk02250.Fragment.fragment_score.NewAdapter.NewAdapter;
import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.News;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Score_Fragment extends Fragment {
    private RecyclerView rcv_news;
    NewAdapter newsAdapter;
    ArrayList<News> list;
    MainActivity mainActivity;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.score_fragment, container, false);
        rcv_news = view.findViewById(R.id.rcv_news);
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
        Call<ArrayList<News>> response = service.getNews();
        response.enqueue(new Callback<ArrayList<News>>() {
            @Override
            public void onResponse(Call<ArrayList<News>> call, Response<ArrayList<News>> response) {
                list = response.body();
                if(list == null || list.isEmpty()){
                    Toast.makeText(mainActivity, "Khong co tin moi",Toast.LENGTH_SHORT).show();
                    return;
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rcv_news.setLayoutManager(linearLayoutManager);
                newsAdapter = new NewAdapter(getContext(),list);
                rcv_news.setAdapter(newsAdapter);
                //Toast.makeText(LoginScreen.this, "" + list.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<News>> call, Throwable t) {
                Toast.makeText( mainActivity, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
