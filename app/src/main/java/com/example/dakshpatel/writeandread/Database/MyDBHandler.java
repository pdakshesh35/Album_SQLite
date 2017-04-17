package com.example.dakshpatel.writeandread.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dakshpatel.writeandread.Album.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dakshpatel on 4/16/17.
 */

public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "Album.db";
    private static final String TABLE_TITLE = "albums";
    private static final String COLUMN_ALBUM = "album";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_TAGS = "tags";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_ID = "id";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_TITLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ALBUM + " TEXT, " +
                    COLUMN_IMAGE + " TEXT , " +
                    COLUMN_TAGS + " TEXT , " +
                    COLUMN_DATE + " TEXT  " +
                    ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TITLE);
        onCreate(db);

    }

    public void add(Image image){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ALBUM, image.getName());
        values.put(COLUMN_IMAGE, image.getImageName());
        values.put(COLUMN_TAGS, image.getSerielizedTags());
        values.put(COLUMN_DATE, image.getDate());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TITLE,null,values);

        db.close();

    }

    public void setTags(Image image) {
            String query = "UPDATE " + TABLE_TITLE +
                    " SET " + COLUMN_TAGS + " =\"" + image.getSerielizedTags() + " \", " +
                              COLUMN_DATE + " =\"" + image.getDate() + " \" " +
                    " WHERE " + COLUMN_ID + " =\"" + image.getID() + "\";";

            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(query);
            db.close();
    }

    public void deleteAll(){
        List<String> albums = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_TITLE);
    }

    public List<String> getAlbums(){
        List<String> albums = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT DISTINCT("+ COLUMN_ALBUM +") FROM '"+ TABLE_TITLE +"';";
        Cursor c = db.rawQuery(query,null);

        try {
            while (c.moveToNext()) {
                if(c.getString(c.getColumnIndex(COLUMN_ALBUM)) != null){
                   albums.add(c.getString(c.getColumnIndex(COLUMN_ALBUM)));


                }
            }
        } finally {
            c.close();
        }


        db.close();
        return albums;

    }

    public boolean isAlbumExist(String album){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_TITLE +
                " WHERE " + COLUMN_ALBUM + "=\"" +  album + "\";";
        Cursor c = db.rawQuery(query,null);

        try {
            while (c.moveToNext()) {
                if(c.getString(c.getColumnIndex(COLUMN_ALBUM)) != null){

                    return  true;
                 }
            }
        } finally {
            c.close();
        }

            return false;
    }





}
