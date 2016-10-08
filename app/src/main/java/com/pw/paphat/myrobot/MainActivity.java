package com.pw.paphat.myrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private SeekBar seekBar;
    private int anInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //SeekBar controller
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//when change will want to do?


                anInt = progress;
                textView.setText(Integer.toString(anInt)); // change interger to string


            }// onProgress

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//when start will want to do

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }   //Main Method
}   //Main Class
