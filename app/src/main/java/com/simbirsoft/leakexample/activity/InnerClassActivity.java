package com.simbirsoft.leakexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.simbirsoft.leakexample.R;

public class InnerClassActivity extends AppCompatActivity {

    private static InnerClass innerClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(getClass().getSimpleName());

        if (innerClass == null) {
            innerClass = new InnerClass();
        }
    }

    public class InnerClass {

    }
}
