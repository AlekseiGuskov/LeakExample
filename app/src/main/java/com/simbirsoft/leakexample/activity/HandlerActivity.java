package com.simbirsoft.leakexample.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.simbirsoft.leakexample.R;

public class HandlerActivity extends AppCompatActivity {

    private TextView textView;

    private byte[] bytes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        textView = findViewById(R.id.textView);

        textView.setText(getClass().getSimpleName());

        bytes = new byte[1024 * 1024 * 3];

        MyHandler handler = new MyHandler();
        handler.sendEmptyMessage(0);
    }

    public class MyHandler extends Handler {
        private int counter;

        public MyHandler() {
            counter = 0;
        }

        @Override
        public void handleMessage(Message msg) {
            if (textView != null) {
                textView.setText(String.valueOf(counter++));
            }

            this.sendEmptyMessageDelayed(0, 1000);
        }
    }
}
