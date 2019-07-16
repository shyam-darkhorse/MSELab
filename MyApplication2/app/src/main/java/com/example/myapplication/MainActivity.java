package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch s1 = findViewById(R.id.switch1);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this,"Wifi Enabled",Toast.LENGTH_SHORT).show();

                } else {
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this,"Wifi Disabled",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (s1.isChecked()) {
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
        } else {
            WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(false);
        }

    }
    private BroadcastReceiver WifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int WifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            Switch s2 = findViewById(R.id.switch1);
            switch (WifiState) {

                case WifiManager.WIFI_STATE_ENABLED: {
                    Toast.makeText(context,"Wifi enabled",Toast.LENGTH_LONG).show();
                    s2.setChecked(true);
                }
                break;

                case WifiManager.WIFI_STATE_ENABLING: {
                    Toast.makeText(context,"Wifi enabling",Toast.LENGTH_LONG).show();
                }
                break;

                case WifiManager.WIFI_STATE_DISABLED: {
                    Toast.makeText(context,"Wifi disabled",Toast.LENGTH_LONG).show();
                    s2.setChecked(false);
                }
                break;

                case WifiManager.WIFI_STATE_DISABLING: {
                }
                break;

                case WifiManager.WIFI_STATE_UNKNOWN: {
                }
                break;
            }
        } };

    protected void onResume(){
        super.onResume();
        registerReceiver(WifiReceiver, new IntentFilter( WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    protected void onPause(){
        super.onPause();
        unregisterReceiver(WifiReceiver);
    }
}
