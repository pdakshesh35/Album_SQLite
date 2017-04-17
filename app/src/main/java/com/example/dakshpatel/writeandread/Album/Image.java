package com.example.dakshpatel.writeandread.Album;

import android.graphics.Bitmap;

import com.example.dakshpatel.writeandread.Model.Information;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * Consider image as path
 * To convert into Image call ImageConverterFromPath
 * Created by dakshpatel on 4/15/17.
 */

public class Image extends Album {

    int id;
    String image;
    List<String> tags;
    JSONObject currentJsonIndex;


    String date;


    public Image(int id, String image, String album){
        super(album);
        this.id = id;
        this.image = image;
        this.date = Information.formatter.format(new Date());;
    }
    public Image(String album, String image, List<String> tags ){
        super(album);

        this.image = image;
        this.tags = tags;
        this.date = Information.formatter.format(new Date());
    }


    public Image(int id, String image, List<String> tags, String album){
        super(album);
        this.id = id;
        this.image = image;
        this.tags = tags;
        this.date = Information.formatter.format(new Date());
    }

    public void setImage(String image){
        this.image = image;
        this.date = Information.formatter.format(new Date());
    }

    public String getImageName(){
        return this.image;
    }

    public int getID(){
        return this.id;
    }

    //Return Actual image
    public Bitmap getImage(){
        return Information.ImageConverterFromPath(this.image);
    }

    public void setTag(String tag){
        this.tags.add(tag);
        this.date = Information.formatter.format(new Date());
    }

    public List<String> getTags(){
        return this.tags;
    }


    public String getSerielizedTags(){
        StringBuilder str = new StringBuilder();

        for(String s : this.tags){
            str.append(s);
            str.append(", ");
        }
        return str.toString();
    }








}
