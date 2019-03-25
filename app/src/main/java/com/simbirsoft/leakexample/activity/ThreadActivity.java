package com.simbirsoft.leakexample.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.simbirsoft.leakexample.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getClass().getSimpleName());
        new MyThread().start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }
}
