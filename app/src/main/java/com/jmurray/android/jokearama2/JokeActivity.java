package com.jmurray.android.jokearama2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String jokeName = intent.getStringExtra("JokeName");

        mTextView = (TextView) findViewById(R.id.joke_name);

        mTextView.setText(jokeName);
    }
}
