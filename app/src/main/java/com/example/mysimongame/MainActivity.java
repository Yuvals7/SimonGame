package com.example.mysimongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        long timerDuration = TimeUnit.MINUTES.toMillis(3);
        long ticksInterval = 10;

        new CountDownTimer(timerDuration, ticksInterval) {
            long millis = 1000;
            @Override
            public void onTick(long millisUntilFinished) {
                millis=millis - ticksInterval;
                if (millis==0)
                    millis= 1000;

                String timerText = String.format(Locale.getDefault(),"%02d:%02d:%03d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
                        millis

                );

                textView.setText(timerText);
            }

            @Override
            public void onFinish() {
                textView.setText("finished");
            }
        }.start();
    }
}