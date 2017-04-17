package com.example.dakshpatel.writeandread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.dakshpatel.writeandread.Database.MyDBHandler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button) findViewById(R.id.album);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity( new Intent(getApplicationContext(),CreateAlbum.class));
                }

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        final MyDBHandler database = new MyDBHandler(this,null,null,3);

        final ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,database.getAlbums());
        list.setAdapter(listAdapter);
    }
}
