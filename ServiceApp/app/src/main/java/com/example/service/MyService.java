package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        Toast.makeText(this, "Service created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public  void onStart(Intent intent , int startid){
        Toast.makeText(this, "Service started",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this, "Service ended",Toast.LENGTH_SHORT).show();
    }
}
