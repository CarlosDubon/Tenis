package com.example.carlos.tenis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView displayA;
    private TextView displayB;
    private TextView wins;
    private TextView gameA;
    private TextView gameB;
    private TextView setA;
    private TextView setB;
    private Button reset;

    private Button A;
    private Button B;
    private int pointA=0;
    private int pointB=0;
    private int gA=0;
    private int gB=0;
    private int sA=0;
    private int sB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayA = findViewById(R.id.pointsA);
        displayB = findViewById(R.id.pointsB);
        setA = findViewById(R.id.setA);
        setB = findViewById(R.id.setB);
        wins = findViewById(R.id.win);
        A = findViewById(R.id.pointA);
        B = findViewById(R.id.pointB);
        gameA = findViewById(R.id.gameA);
        gameB = findViewById(R.id.gameB);
        reset = findViewById(R.id.resetAll);


        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pointA < 5) {
                    pointA++;
                }
                if(pointA == 4 && pointB == 4){
                    pointA --;
                    pointB --;
                    displayB.setText("40");
                }
                switch (pointA){
                    case 1:
                        displayA.setText("15");
                        break;
                    case 2:
                        displayA.setText("30");
                        break;
                    case 3:
                        displayA.setText("40");
                        break;
                    case 4:
                        displayA.setText("Adv.");
                        break;
                }

                if((Math.abs(pointA-pointB))>=2 && pointA >= 4){
                    if(gA<=3) {
                        gA++;
                    }
                    gameA.setText(gA+"");
                    gameB.setText(gB+"");
                    reset();
                }

                if(Math.abs(gA-gB)>=1 && gA+gB>=2){
                    sA++;
                    setA.setText(sA+"");
                    setB.setText(sB+"");
                    reset();
                    resetGame();

                }

                if(Math.abs(sA-sB)>=1 && sA+sB>=2){
                    wins.setText("PLAYER A WINS");
                    reset();
                    resetGame();
                    reset.setVisibility(View.VISIBLE);

                }


            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pointB < 5) {
                    pointB++;
                }
                if(pointA == 4 && pointB == 4){
                    pointA --;
                    pointB --;
                    displayA.setText("40");
                }
                switch (pointB){
                    case 1:
                        displayB.setText("15");
                        break;
                    case 2:
                        displayB.setText("30");
                        break;
                    case 3:
                        displayB.setText("40");
                        break;
                    case 4:
                        displayB.setText("Adv.");
                        break;
                }
                if((Math.abs(pointA-pointB))>=2 && pointB >= 4){
                    if(gB<=3) {
                        gB++;
                    }
                    gameA.setText(gA+"");
                    gameB.setText(gB+"");
                    reset();
                }

                if(Math.abs(gA-gB)>=1 && gA+gB>=2 ){
                    sB++;
                    setA.setText(sA+"");
                    setB.setText(sB+"");
                    reset();
                    resetGame();

                }

                if(Math.abs(sA-sB)>=1 && sA+sB>=2){
                    wins.setText("PLAYER B WINS");
                    reset();
                    resetGame();
                    reset.setVisibility(View.VISIBLE);
                }



            }
        });
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                reset();
                resetGame();
                wins.setText("");
                sA=0;
                sB=0;
                setA.setText(sA+"");
                setB.setText(sB+"");
                reset.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void reset(){
        pointA =0;
        pointB=0;
        displayA.setText("0");
        displayB.setText("0");
    }
    public void resetGame(){
        gA =0;
        gB=0;
        gameA.setText(gA+"");
        gameB.setText(gB+"");
    }

}
