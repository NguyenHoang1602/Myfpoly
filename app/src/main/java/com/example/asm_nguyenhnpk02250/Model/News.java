package com.example.asm_nguyenhnpk02250.Model;

import java.io.Serializable;

public class News implements Serializable {
    private Integer New_ID;
    private String New_Title, Publisher_news, Avatar, Ima, news_Time;

    public News() {
    }

    public News(Integer new_ID, String new_Title, String publisher_news, String avatar, String ima, String news_Time) {
        New_ID = new_ID;
        New_Title = new_Title;
        Publisher_news = publisher_news;
        Avatar = avatar;
        Ima = ima;
        this.news_Time = news_Time;
    }

    public Integer getNew_ID() {
        return New_ID;
    }

    public void setNew_ID(Integer new_ID) {
        New_ID = new_ID;
    }

    public String getNew_Title() {
        return New_Title;
    }

    public void setNew_Title(String new_Title) {
        New_Title = new_Title;
    }

    public String getPublisher_news() {
        return Publisher_news;
    }

    public void setPublisher_news(String publisher_news) {
        Publisher_news = publisher_news;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getIma() {
        return Ima;
    }

    public void setIma(String ima) {
        Ima = ima;
    }

    public String getNews_Time() {
        return news_Time;
    }

    public void setNews_Time(String news_Time) {
        this.news_Time = news_Time;
    }

    @Override
    public String toString() {
        return "News{" +
                "New_ID=" + New_ID +
                ", New_Title='" + New_Title + '\'' +
                ", Publisher_news='" + Publisher_news + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", Ima='" + Ima + '\'' +
                ", news_Time='" + news_Time + '\'' +
                '}';
    }
}
