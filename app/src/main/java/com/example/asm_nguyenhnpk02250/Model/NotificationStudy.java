package com.example.asm_nguyenhnpk02250.Model;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class NotificationStudy implements Serializable {
    private String Notification_ID, Publishers, C_NotificatonID , Title, Details, Time;

    public NotificationStudy() {
    }

    public NotificationStudy(String notification_ID, String publishers, String c_NotificatonID, String title, String details, String time) {
        Notification_ID = notification_ID;
        Publishers = publishers;
        C_NotificatonID = c_NotificatonID;
        Title = title;
        Details = details;
        Time = time;
    }

    public String getNotification_ID() {
        return Notification_ID;
    }

    public void setNotification_ID(String notification_ID) {
        Notification_ID = notification_ID;
    }

    public String getPublishers() {
        return Publishers;
    }

    public void setPublishers(String publishers) {
        Publishers = publishers;
    }

    public String getC_NotificatonID() {
        return C_NotificatonID;
    }

    public void setC_NotificatonID(String c_NotificatonID) {
        C_NotificatonID = c_NotificatonID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "NotificationStudy{" +
                "Notification_ID='" + Notification_ID + '\'' +
                ", Publishers='" + Publishers + '\'' +
                ", C_NotificatonID='" + C_NotificatonID + '\'' +
                ", Title='" + Title + '\'' +
                ", Details='" + Details + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
