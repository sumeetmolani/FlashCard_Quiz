package com.example.flashcardquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button play,setting,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.btn_play);
        setting=findViewById(R.id.btn_setting);
        exit=findViewById(R.id.btn_exit);
        play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, playActivity.class);
           startActivity(intent);
            finish();
        }
    });
    setting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           Intent intent = new Intent(MainActivity.this, settingActivity.class);
            startActivity(intent);
        finish();
        }
    });
    exit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            finishAffinity();
            System.exit(0);
        }
    });
    }
}