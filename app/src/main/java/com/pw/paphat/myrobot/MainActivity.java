package com.pw.paphat.myrobot;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private TextView textView,textView2;
    private SeekBar seekBar;
    private int anInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView);
//        textView2 = (TextView) findViewById(R.id.textView2);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //SeekBar controller
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//when change will want to do?

                seekBar.setMax(1000);
                anInt = progress;
                textView.setText(Integer.toString(anInt)); // change interger to string



                //uploadIntegertoDweet(anInt);


            }// onProgress

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//when start will want to do

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //textView2.setText(Integer.toString(anInt));
                Log.d("RobotVI", "This is my message = "+ anInt);
                uploadIntegertoDweet(anInt);

            }
        });


    }   //Main Method

    private void uploadIntegertoDweet(int anInt) {

        UpLoadValue upLoadValue = new UpLoadValue(MainActivity.this); //ต่อท่อ

        upLoadValue.execute(anInt); //ส่งค่า


    }// upload

    private class UpLoadValue extends AsyncTask<Integer, Void, String> {

        //Explicit
        private Context context;
        private static final String urlSTRING = "https://dweet.io/dweet/for/Rcsa?Servo1=";

        public UpLoadValue(Context context) {
            this.context = context;
        }   //Constructor

        @Override
        protected String doInBackground(Integer... params) {


            try {

                String urlDweet = urlSTRING + Integer.toString(params[0]);

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();

                Request request = builder.url(urlDweet).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string(); //change body to string



            } catch (Exception e) {
                Log.d("RobotV2", "e donInBack ==> " + e.toString());


                return null;
            }

//            return null;
        }// doInBackground

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("RobotV2", "Result JSON ==>" + s);

        }   //onPost



    } // UpLoadValue

}   //Main Class
