package com.example.registerapplication;

public class Friend {

    private String name;
    private String attended_date;

    private String next_clinic_date;
    private String doctor_comment;

    public Friend(String name, String attended_date, String next_clinic_date, String doctor_comment) {
        this.name = name;
      this.attended_date = attended_date;
        this.next_clinic_date = next_clinic_date;
        this.doctor_comment = doctor_comment;
    }

    public String getName() {
        return name;
    }
    public  String getAttended_date(){
        return  attended_date;
    }
    public String getNext_clinic_date(){
        return  next_clinic_date;
    }
    public String getDoctor_comment(){
        return doctor_comment;
    }


}