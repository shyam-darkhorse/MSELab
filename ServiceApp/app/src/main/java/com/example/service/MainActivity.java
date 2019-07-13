package com.example.service;

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
        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this,MyService.class));
                //Toast.makeText(MainActivity.this, "Service started",Toast.LENGTH_SHORT).show();
            }
        });
        Button stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this,MyService.class));
                //Toast.makeText(MainActivity.this, "Service stopped",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
