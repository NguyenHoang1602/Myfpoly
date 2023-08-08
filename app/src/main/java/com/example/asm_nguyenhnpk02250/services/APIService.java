package com.example.asm_nguyenhnpk02250.services;

import com.example.asm_nguyenhnpk02250.Model.News;
import com.example.asm_nguyenhnpk02250.Model.NotificationAction;
import com.example.asm_nguyenhnpk02250.Model.NotificationStudy;
import com.example.asm_nguyenhnpk02250.Model.NotificationTuition;
import com.example.asm_nguyenhnpk02250.Model.Product;
import com.example.asm_nguyenhnpk02250.Model.Schedules;
import com.example.asm_nguyenhnpk02250.Model.TestSchedules;
import com.example.asm_nguyenhnpk02250.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    String base_link = "http://192.168.1.8/MYFPOLY_DATABASE/API/";
    @GET("GetUser.php")
    Call<ArrayList<User>> getUser();
    @GET("GetNofiticationStudy.php")
    Call<ArrayList<NotificationStudy>> getNotificationStudy();
    @GET("GetNofiticationaction.php")
    Call<ArrayList<NotificationAction>> getNotificationAction();
    @GET("GetNotificationTuition.php")
    Call<ArrayList<NotificationTuition>> getNotificationTuition();
    @GET("GetSchedule.php")
    Call<ArrayList<Schedules>> getSchedule();
    @GET("GetTestSchedule.php")
    Call<ArrayList<TestSchedules>> getTestSchedule();
    @GET("GetNews.php")
    Call<ArrayList<News>> getNews();


}
