package com.example.dakshpatel.writeandread.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by dakshpatel on 4/15/17.
 */

public class Information {

     public static DateFormat formatter = new SimpleDateFormat("EEE, MMM d, ''yy - h:mm a");

    public static String filename = "Admin.json";

    /**
     * Convert Path to image
     * @param path -> image Path
     * @return image as Bitmap
     */
    public static Bitmap ImageConverterFromPath(String path){
        File imageFile = new File(path);
        Bitmap image = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        return image;
    }

    //JSON keys
    public  static String NAME_KEY = "name";
    public static String ALBUM_KEY = "com/example/dakshpatel/writeandread/Album";
    public static String IMAGE_KEY = "images";
    public static String TAGS_KEY = "tags";
    public static String DATE_KEY = "date";


    public static void displayText(Context context, CharSequence text){

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text, duration);
        toast.show();
    }

}
