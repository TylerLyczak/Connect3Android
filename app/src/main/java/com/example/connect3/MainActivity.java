package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int whichTurn = 0;

    public void onGamePieceClick (View view)    {

        ImageView imageView = (ImageView)view;

        //Log.i("Piece: ", String.valueOf(imageView.getId()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
