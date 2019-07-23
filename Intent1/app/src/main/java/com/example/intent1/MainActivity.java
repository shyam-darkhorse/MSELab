package com.example.intent1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCaller(View v){
        EditText e = findViewById(R.id.editText);
        Uri u = Uri.parse("tel:" + e.getText().toString());
        Intent i = new Intent(Intent.ACTION_DIAL, u);
        startActivity(i);
    }

    public void openSearch(View v) throws UnsupportedEncodingException {
        EditText query = findViewById(R.id.editText);
        String escapedQuery = URLEncoder.encode(query.getText().toString(), "UTF-8");
        Uri uri = Uri.parse("http://www.google.com/#q=" + escapedQuery);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

