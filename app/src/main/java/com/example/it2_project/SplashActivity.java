package com.example.it2_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        final int welcomeScreenDisplay = 2000;

        Thread welcomeThread = new Thread() {
            int wait = 0;
            @Override
            public void run() {
                try {
                    super.run();
                    /**
                     * use while to get the splash time. Use sleep() to increase
                     * the wait variable for every 100L.
                     */
                    while (wait < welcomeScreenDisplay) {
                        sleep(100);
                        wait += 100;
                    }
                } catch (Exception e) {
                    System.out.println("EXc=" + e);
                } finally {

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        welcomeThread.start();

    }
}


