package com.example.akalwadi.texttomorse;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public EditText ettext;
    public Button converttomorse;
    public TextView etshowmorse;
    String phno;
    String convertedText;
    String normaltext;
    String convertedfrommorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ettext = (EditText) findViewById(R.id.ettext);
        converttomorse = (Button) findViewById(R.id.btnconvert);
        etshowmorse = (TextView) findViewById(R.id.etshowmorse);

        converttomorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertmorse();
            }
        });
    }

    public void convertmorse(){
        String textToConvert = ettext.getText().toString();
        convertedText = MorseCode.alphaToMorse(textToConvert);
        etshowmorse.setVisibility(View.VISIBLE);
        etshowmorse.setText(convertedText);
    }
}
