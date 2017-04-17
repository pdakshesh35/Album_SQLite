package com.example.dakshpatel.writeandread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dakshpatel.writeandread.Album.Image;
import com.example.dakshpatel.writeandread.Database.MyDBHandler;

import java.util.ArrayList;
import java.util.List;

import static com.example.dakshpatel.writeandread.Model.Information.displayText;

/**
 * Created by dakshpatel on 4/16/17.
 */

public class CreateAlbum extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        //SHOW back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Database
        final MyDBHandler database = new MyDBHandler(this,null,null,3);
        //elements
        final EditText album = (EditText)findViewById(R.id.editText2);
        Button add = (Button)findViewById(R.id.album);


        add.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //Check if textfield is empty or not
                if(!album.getText().toString().isEmpty()) {
                    //check if album already exists or not
                    if(!database.isAlbumExist(album.getText().toString())) {
                        List<String> tags = new ArrayList<String>();
                        tags.add("");

                        Image data = new Image(album.getText().toString(), " ", tags);
                        database.add(data);
                        album.setText("");
                        CreateAlbum.super.onBackPressed();
                        displayText(getApplicationContext(), "Done!");
                    } else {
                        CharSequence text = "Album already exists!";
                       displayText(getApplicationContext(),text);

                    }
                } else {
                    CharSequence text = "Album name is empty";
                    displayText(getApplicationContext(),text);
                }
            }
        });
    }


    /**
     * Back button action
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }



}
