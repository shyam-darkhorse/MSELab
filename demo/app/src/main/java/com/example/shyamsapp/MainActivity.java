package com.example.shyamsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toastButton = findViewById(R.id.button);
        toastButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"Button pressed",Toast.LENGTH_SHORT).show();
                Intent nextPage = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(nextPage);
            }
        });
    }
}
