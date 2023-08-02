package com.example.asm_nguyenhnpk02250.Model;

public class Schedule {
    private String Schedule_ID, Date, Room_ID, Amphitheater_ID, Subject_ID, Classroom_ID, Lecturers_ID, Slot;

    public Schedule() {
    }

    public Schedule(String schedule_ID, String date, String room_ID, String amphitheater_ID, String subject_ID, String classroom_ID, String lecturers_ID, String slot) {
        Schedule_ID = schedule_ID;
        Date = date;
        Room_ID = room_ID;
        Amphitheater_ID = amphitheater_ID;
        Subject_ID = subject_ID;
        Classroom_ID = classroom_ID;
        Lecturers_ID = lecturers_ID;
        Slot = slot;
    }

    public String getSchedule_ID() {
        return Schedule_ID;
    }

    public void setSchedule_ID(String schedule_ID) {
        Schedule_ID = schedule_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
    }
}
