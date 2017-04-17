package com.example.dakshpatel.writeandread.Album;

import com.example.dakshpatel.writeandread.Model.Information;

import java.util.Date;

/**
 * Created by dakshpatel on 4/15/17.
 */

public class Album {
    String name;


    String date;


    public Album(String name){
        this.name = name;
        date = Information.formatter.format(new Date());


    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getDate(){
        return this.date;
    }

}
