package com.example.a15017381.p02_sgholidays;

/**
 * Created by 15017381 on 28/4/2017.
 */

public class SGHolidays {
    private String name;
    private String date;
    private String pictures;

    public SGHolidays(String name, String date, String pictures){
        this.name = name;
        this.date = date;
        this.pictures = pictures;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getPictures(){
        return pictures;
    }
}
