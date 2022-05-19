package com.example.mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView result;
    private Button playAgein,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result=findViewById(R.id.resultscore);
        playAgein=findViewById(R.id.playagain);
        exit=findViewById(R.id.exit);

        Intent intent=getIntent();
        int Intentresult=intent.getIntExtra("result",0);
        result.setText("Score : "+String.valueOf(Intentresult));


        playAgein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


    }
}