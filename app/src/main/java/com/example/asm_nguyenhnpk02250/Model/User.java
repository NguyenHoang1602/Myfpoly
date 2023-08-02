package com.example.asm_nguyenhnpk02250.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String MSSV, Name, Email, Pass, Address, Specialized_ID, Classroom_ID, Specialized_Name, Sex_Name, Status;
    private int Contact_Number, Sex_ID, Status_ID;

    public User() {
    }

    public User(String MSSV, String name, String email, String pass, String address, String specialized_ID, String classroom_ID, String specialized_Name, String sex_Name, String status, int contact_Number, int sex_ID, int status_ID) {
        this.MSSV = MSSV;
        Name = name;
        Email = email;
        Pass = pass;
        Address = address;
        Specialized_ID = specialized_ID;
        Classroom_ID = classroom_ID;
        Specialized_Name = specialized_Name;
        Sex_Name = sex_Name;
        Status = status;
        Contact_Number = contact_Number;
        Sex_ID = sex_ID;
        Status_ID = status_ID;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSpecialized_ID() {
        return Specialized_ID;
    }

    public void setSpecialized_ID(String specialized_ID) {
        Specialized_ID = specialized_ID;
    }

    public String getClassroom_ID() {
        return Classroom_ID;
    }

    public void setClassroom_ID(String classroom_ID) {
        Classroom_ID = classroom_ID;
    }

    public String getSpecialized_Name() {
        return Specialized_Name;
    }

    public void setSpecialized_Name(String specialized_Name) {
        Specialized_Name = specialized_Name;
    }

    public String getSex_Name() {
        return Sex_Name;
    }

    public void setSex_Name(String sex_Name) {
        Sex_Name = sex_Name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(int contact_Number) {
        Contact_Number = contact_Number;
    }

    public int getSex_ID() {
        return Sex_ID;
    }

    public void setSex_ID(int sex_ID) {
        Sex_ID = sex_ID;
    }

    public int getStatus_ID() {
        return Status_ID;
    }

    public void setStatus_ID(int status_ID) {
        Status_ID = status_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "MSSV='" + MSSV + '\'' +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Pass='" + Pass + '\'' +
                ", Address='" + Address + '\'' +
                ", Specialized_ID='" + Specialized_ID + '\'' +
                ", Classroom_ID='" + Classroom_ID + '\'' +
                ", Specialized_Name='" + Specialized_Name + '\'' +
                ", Sex_Name='" + Sex_Name + '\'' +
                ", Status='" + Status + '\'' +
                ", Contact_Number=" + Contact_Number +
                ", Sex_ID=" + Sex_ID +
                ", Status_ID=" + Status_ID +
                '}';
    }
}
