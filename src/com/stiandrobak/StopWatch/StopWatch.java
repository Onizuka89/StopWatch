package com.stiandrobak.StopWatch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.os.Handler;
import android.widget.TextView;

public class StopWatch extends Activity{
    /**
     * Called when the activity is first created.
     */
    private static boolean running = false;
    private static long startTime = 0;
    private static Handler handler = new Handler();
    private final static String TAG = "StopWatchClass";
    private TextView hour;
    private TextView minutes;
    private TextView seconds;
    private TextView milliseconds;
    private Runnable timer = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Running");
            TimeConverter timeConverter = new TimeConverter(System.currentTimeMillis() - startTime);
            hour.setText(TimeConverter.twoDigits(timeConverter.getHours()));
            minutes.setText(TimeConverter.twoDigits(timeConverter.getMinutes()));
            seconds.setText(TimeConverter.twoDigits(timeConverter.getSeconds()));
            milliseconds.setText(TimeConverter.threeDigits(timeConverter.getMilliseconds()));
            handler.postDelayed(this, 100);
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        hour = (TextView)findViewById(R.id.hours);
        minutes = (TextView)findViewById(R.id.minutes);
        seconds = (TextView) findViewById(R.id.seconds);
        milliseconds = (TextView)findViewById(R.id.milliseconds);

        Button button = (Button) findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running){
                    startTime = System.currentTimeMillis();
                    timer.run();
                    running = true;
                }else{
                    handler.removeCallbacks(timer);
                    running = false;
                }
            }
        });
    }

}
