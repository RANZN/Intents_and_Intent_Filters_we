package com.ranzan.intentsandintentfilterswe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondPage extends AppCompatActivity {
private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        show = findViewById(R.id.tvShow);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        show.setText(userName);
    }
}