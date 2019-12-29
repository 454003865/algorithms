package com.main.dao;

public class User {
    private int userid;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                '}';
    }

    public  User(int num , String name){
       this.userid=num;
       this.name=name;
   }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
