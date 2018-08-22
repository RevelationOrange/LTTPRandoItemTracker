package com.example.revelationorange.lttprandoitemtracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private static int idStart = 100;
    private static int idCounter = idStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private static int getNextID() { return idCounter++; }

    private static ImageButton makeImgButton(Context c) {
        ImageButton retButton = new ImageButton(c);
        retButton.setId(getNextID());
        return retButton;
    }
}
