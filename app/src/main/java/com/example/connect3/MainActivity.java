package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int whichTurn = 0;

    public void onPlayAgain (View view) {

        Button playAgain = (Button)view;
        // If the player clicks the button when invisible, then it will do nothing
        if (playAgain.getVisibility() == View.INVISIBLE) {
            return;
        }

        // Resets all the game pieces
        ImageView piece1 = (ImageView)findViewById(R.id.gamePiece1);
        piece1.setTag("");
        piece1.setImageResource(0);

        ImageView piece2 = (ImageView)findViewById(R.id.gamePiece2);
        piece2.setTag("");
        piece2.setImageResource(0);

        ImageView piece3 = (ImageView)findViewById(R.id.gamePiece3);
        piece3.setTag("");
        piece3.setImageResource(0);

        ImageView piece4 = (ImageView)findViewById(R.id.gamePiece4);
        piece4.setTag("");
        piece4.setImageResource(0);

        ImageView piece5 = (ImageView)findViewById(R.id.gamePiece5);
        piece5.setTag("");
        piece5.setImageResource(0);

        ImageView piece6 = (ImageView)findViewById(R.id.gamePiece6);
        piece6.setTag("");
        piece6.setImageResource(0);

        ImageView piece7 = (ImageView)findViewById(R.id.gamePiece7);
        piece7.setTag("");
        piece7.setImageResource(0);

        ImageView piece8 = (ImageView)findViewById(R.id.gamePiece8);
        piece8.setTag("");
        piece8.setImageResource(0);

        ImageView piece9 = (ImageView)findViewById(R.id.gamePiece9);
        piece9.setTag("");
        piece9.setImageResource(0);


        // Resets some variables and text, makes button invisible again
        whichTurn = 0;
        TextView textView = (TextView)findViewById(R.id.titleText);
        textView.setText("Click Any Square To Start, Red Goes First!");

        playAgain.setVisibility(View.INVISIBLE);
    }

    public boolean checkBoard (String winner)    {

        String sp1 = (String.valueOf(findViewById(R.id.gamePiece1).getTag()));
        String sp2 = (String.valueOf(findViewById(R.id.gamePiece2).getTag()));
        String sp3 = (String.valueOf(findViewById(R.id.gamePiece3).getTag()));
        String sp4 = (String.valueOf(findViewById(R.id.gamePiece4).getTag()));
        String sp5 = (String.valueOf(findViewById(R.id.gamePiece5).getTag()));
        String sp6 = (String.valueOf(findViewById(R.id.gamePiece6).getTag()));
        String sp7 = (String.valueOf(findViewById(R.id.gamePiece7).getTag()));
        String sp8 = (String.valueOf(findViewById(R.id.gamePiece8).getTag()));
        String sp9 = (String.valueOf(findViewById(R.id.gamePiece9).getTag()));


        // Top row win
        if ((sp1.equals(sp2)) && (sp2.equals(sp3)) && (!"".equals(sp1)))  {
            winner = sp1;
            return true;
        }
        // Middle row win
        else if ((sp4.equals(sp5)) && (sp5.equals(sp6)) && (!"".equals(sp4)))    {
            winner = sp4;
            return true;
        }
        // Bottom row win
        else if ((sp7.equals(sp8)) && (sp8.equals(sp9)) && (!"".equals(sp7)))    {
            winner = sp7;
            return true;
        }
        // Left column win
        else if ((sp1.equals(sp4)) && (sp4.equals(sp7)) && (!"".equals(sp1)))    {
            winner = sp1;
            return true;
        }
        // Middle column win
        else if ((sp2.equals(sp5)) && (sp5.equals(sp8)) && (!"".equals(sp2)))    {
            winner = sp2;
            return true;
        }
        // Right column win
        else if ((sp3.equals(sp6)) && (sp6.equals(sp9)) && (!"".equals(sp3)))    {
            winner = sp3;
            return true;
        }
        // Top-left to bottom-right win
        else if ((sp1.equals(sp5)) && (sp5.equals(sp9)) && (!"".equals(sp1)))    {
            winner = sp1;
            return true;
        }
        // Top-Right to bottom-left win
        else if ((sp3.equals(sp5)) && (sp5.equals(sp7)) && (!"".equals(sp3)))    {
            winner = sp3;
            return true;
        }
        else    {
            return false;
        }
    }

    public void onGamePieceClick (View view)    {

        ImageView imageView = (ImageView)view;

        if ((String.valueOf(imageView.getTag()).equals("Red")) || (String.valueOf(imageView.getTag()).equals("Yellow")))  {
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

        String winner = "";

        if (checkBoard(winner)) {
            String winnerText = winner+" WON!";
            Toast.makeText(this, winnerText, Toast.LENGTH_SHORT).show();

            Button playAgain = (Button)findViewById(R.id.playAgain);
            playAgain.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
