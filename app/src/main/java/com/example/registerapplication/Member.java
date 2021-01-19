package com.example.registerapplication;

public class Member {

    private String Name;
    private String Age;
    private String Gender;
    private String Retina;

    public Member(){}

    public String getName(){
        return Name;
    }
    public String getAge(){
        return  Age;
    }

    public void setName(String name) { Name = name;}
    public void setAge(String age) {Age = age;}
    public String getGender() {return Gender; }
    public void  setGender (String gender) {Gender = gender;}

    public String getRetina() {return Retina; }
    public void  setRetina (String retina) {Retina = retina;}
}
