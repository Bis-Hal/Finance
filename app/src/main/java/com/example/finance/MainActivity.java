package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar.setProgress(1);

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {

                for(int i =0;i<3;i++){
                    progressBar.incrementProgressBy(33);
                    SystemClock.sleep(500);
                }

                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);

            }
        });
        thread.start();
    }

}