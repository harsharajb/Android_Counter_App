package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewObj;
    Button startbtn,stopbtn,clearbtn;
    Handler handler=new Handler();
    int i=0;
    private final Runnable myThread = new Runnable() {
        @Override
        public void run() {
               textViewObj.setText(" "+i);
               handler.postDelayed(this,1000);
               i++;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewObj = findViewById(R.id.textView3);
        startbtn = findViewById(R.id.button);
        stopbtn = findViewById(R.id.button2);
        clearbtn = findViewById(R.id.clrbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(myThread,0);

            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(myThread);
            }
        });
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                textViewObj.setText(""+i);
            }
        });


    }

}