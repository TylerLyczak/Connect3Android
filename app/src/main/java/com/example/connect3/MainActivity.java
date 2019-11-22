package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int whichTurn = 0;

    public void onGamePieceClick (View view)    {

        ImageView imageView = (ImageView)view;

        if ((String.valueOf(imageView.getTag()) == "Red") || (String.valueOf(imageView.getTag()) == "Yellow"))  {
            Toast.makeText(this, "Piece Already Selected", Toast.LENGTH_SHORT).show();
            return;
        }

        // Red players turn
        if (whichTurn == 0) {
            imageView.setImageResource(R.drawable.red);
            imageView.setTag("Red");

            TextView textView = (TextView)findViewById(R.id.titleText);
            textView.setText("Yellow's Turn");

            whichTurn++;
        }
        // Yellow Turn
        else    {
            imageView.setImageResource(R.drawable.yellow);
            imageView.setTag("Yellow");

            TextView textView = (TextView)findViewById(R.id.titleText);
            textView.setText("Red's Turn");

            whichTurn = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
