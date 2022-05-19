package com.example.mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.Random;

public class Add extends AppCompatActivity {



    private TextView score,life,time,quastion;
    private int scoreint=0,lifeint=3,timeint=60;
    private TextInputEditText answer;
    private Button ok,next;

    private Random random=new Random();
    int number1,number2;
    int sonuc;
    String c;

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS=60000;
    Boolean timer_runnig;
    long time_left_in_milis=START_TIMER_IN_MILIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent=getIntent();
        c=intent.getStringExtra("value");

        score=findViewById(R.id.score);
        life=findViewById(R.id.life);
        time=findViewById(R.id.time);

        quastion=findViewById(R.id.quastion);
        answer=findViewById(R.id.answer);

        ok=findViewById(R.id.buttonok);
        next=findViewById(R.id.buttonnext);


        game();




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1=answer.getText().toString();

                pauseTimer();

                if (answer1.equals(String.valueOf(sonuc)))
                {
                    scoreint++;
                    score.setText(String.valueOf(scoreint));
                    game();
                }
                else{
                    lifeint--;
                    life.setText(String.valueOf(lifeint));
                    game();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetTimer();
                    game();


            }
        });

    }

    public void gameContinue()
    {
        number1=random.nextInt(100 );
        number2=random.nextInt(100 );

    }
    public void game(){
        gameContinue();
        answer.setText("");
        if (lifeint==0){
            Intent intent1=new Intent(Add.this,Result.class);
            intent1.putExtra("result",scoreint);
            startActivity(intent1);
            finish();
        }
        else {

            if (c.equals("add")) {

                quastion.setText(number1 + " + " + number2);
                sonuc = number1 + number2;

            } else if (c.equals("sub")) {
                if (number1 > number2) {
                    quastion.setText(number1 + " - " + number2);
                    sonuc = number1 - number2;
                } else {
                    quastion.setText(number2 + " - " + number1);
                    sonuc = number2 - number1;
                }

            } else if (c.equals("multi")) {
                quastion.setText(number1 + " * " + number2);
                sonuc = number1 * number2;
            }
            startTimer();
        }
    }
    public void startTimer(){
        timer=new CountDownTimer(time_left_in_milis,1000) {
            @Override
            public void onTick(long l) {
                time_left_in_milis=l;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_runnig=false;
                pauseTimer();
                resetTimer();
                updateText();
                lifeint=lifeint-1;
                life.setText(String.valueOf(lifeint));
                quastion.setText("Time is up!");
            }
        }.start();
        timer_runnig=true;
    }

    public void updateText(){
        int second=(int)(time_left_in_milis/1000)%60;
        String time_left=String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }
    public void pauseTimer()
    {
        timer.cancel();
        timer_runnig=false;
    }
    public void resetTimer(){
        time_left_in_milis=START_TIMER_IN_MILIS;
        updateText();
    }

}