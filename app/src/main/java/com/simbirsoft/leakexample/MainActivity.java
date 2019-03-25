package com.simbirsoft.leakexample;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.simbirsoft.leakexample.activity.AsyncTaskActivity;
import com.simbirsoft.leakexample.activity.HandlerActivity;
import com.simbirsoft.leakexample.activity.InnerClassActivity;
import com.simbirsoft.leakexample.activity.RxActivity;
import com.simbirsoft.leakexample.activity.StaticActivity;
import com.simbirsoft.leakexample.activity.ThreadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareActionBar();
        prepareButtons();
    }

    private void prepareActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    private void prepareButtons() {
        Button btnHandlerActivity = findViewById(R.id.btn_handler_activity);
        btnHandlerActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, HandlerActivity.class)));
        Button btnAsyncTaskActivity = findViewById(R.id.btn_async_task_activity);
        btnAsyncTaskActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AsyncTaskActivity.class)));
        Button btnInnerClassActivity = findViewById(R.id.btn_inner_class_activity);
        btnInnerClassActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, InnerClassActivity.class)));
        Button btnThreadActivity = findViewById(R.id.btn_thread_activity);
        btnThreadActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ThreadActivity.class)));
        Button btnStaticActivity = findViewById(R.id.btn_static_activity);
        btnStaticActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, StaticActivity.class)));
        Button btnRxActivity = findViewById(R.id.btn_rx_activity);
        btnRxActivity.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, RxActivity.class)));
    }
}
