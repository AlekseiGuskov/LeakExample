package com.simbirsoft.leakexample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.simbirsoft.leakexample.R;

public class StaticActivity extends AppCompatActivity {

    public static Activity activity = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getClass().getSimpleName());

        if (activity == null) {
            activity = this;
        }
    }
}
