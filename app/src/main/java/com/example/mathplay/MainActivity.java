package com.example.mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button add,sub,multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.buttonAdd);
        sub=findViewById(R.id.buttonSub);
        multi=findViewById(R.id.buttonMulti);
        Intent intent=new Intent(MainActivity.this,Add.class);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("value","add");
                startActivity(intent);
                finish();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("value","sub");
                startActivity(intent);
                finish();

            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("value","multi");
                startActivity(intent);
                finish();
            }
        });



    }
}