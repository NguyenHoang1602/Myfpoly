package com.example.asm_nguyenhnpk02250.Model;

import java.io.Serializable;

public class Schedules implements Serializable {
    private Integer Schedule_ID, Slot_ID;
    private String Room_ID, Amphitheater_ID, Subject_ID, Classroom_ID, Lecturers_ID, Time, room_Name, amphitheater_Name, Name, classroom_Name, Date;

    public Schedules() {
    }

    public Schedules(Integer schedule_ID, Integer slot_ID, String room_ID, String amphitheater_ID, String subject_ID, String classroom_ID, String lecturers_ID, String time, String room_Name, String amphitheater_Name, String name, String classroom_Name, String date) {
        Schedule_ID = schedule_ID;
        Slot_ID = slot_ID;
        Room_ID = room_ID;
        Amphitheater_ID = amphitheater_ID;
        Subject_ID = subject_ID;
        Classroom_ID = classroom_ID;
        Lecturers_ID = lecturers_ID;
        Time = time;
        this.room_Name = room_Name;
        this.amphitheater_Name = amphitheater_Name;
        Name = name;
        this.classroom_Name = classroom_Name;
        Date = date;
    }

    public Integer getSchedule_ID() {
        return Schedule_ID;
    }

    public void setSchedule_ID(Integer schedule_ID) {
        Schedule_ID = schedule_ID;
    }

    public Integer getSlot_ID() {
        return Slot_ID;
    }

    public void setSlot_ID(Integer slot_ID) {
        Slot_ID = slot_ID;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String room_ID) {
        Room_ID = room_ID;
    }

    public String getAmphitheater_ID() {
        return Amphitheater_ID;
    }

    public void setAmphitheater_ID(String amphitheater_ID) {
        Amphitheater_ID = amphitheater_ID;
    }

    public String getSubject_ID() {
        return Subject_ID;
    }

    public void setSubject_ID(String subject_ID) {
        Subject_ID = subject_ID;
    }

    public String getClassroom_ID() {
        return Classroom_ID;
    }

    public void setClassroom_ID(String classroom_ID) {
        Classroom_ID = classroom_ID;
    }

    public String getLecturers_ID() {
        return Lecturers_ID;
    }

    public void setLecturers_ID(String lecturers_ID) {
        Lecturers_ID = lecturers_ID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getRoom_Name() {
        return room_Name;
    }

    public void setRoom_Name(String room_Name) {
        this.room_Name = room_Name;
    }

    public String getAmphitheater_Name() {
        return amphitheater_Name;
    }

    public void setAmphitheater_Name(String amphitheater_Name) {
        this.amphitheater_Name = amphitheater_Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClassroom_Name() {
        return classroom_Name;
    }

    public void setClassroom_Name(String classroom_Name) {
        this.classroom_Name = classroom_Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Schedules{" +
                "Schedule_ID=" + Schedule_ID +
                ", Slot_ID=" + Slot_ID +
                ", Room_ID='" + Room_ID + '\'' +
                ", Amphitheater_ID='" + Amphitheater_ID + '\'' +
                ", Subject_ID='" + Subject_ID + '\'' +
                ", Classroom_ID='" + Classroom_ID + '\'' +
                ", Lecturers_ID='" + Lecturers_ID + '\'' +
                ", Time='" + Time + '\'' +
                ", room_Name='" + room_Name + '\'' +
                ", amphitheater_Name='" + amphitheater_Name + '\'' +
                ", Name='" + Name + '\'' +
                ", classroom_Name='" + classroom_Name + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
