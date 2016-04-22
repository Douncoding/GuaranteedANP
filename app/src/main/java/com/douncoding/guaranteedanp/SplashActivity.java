package com.douncoding.guaranteedanp;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        Log.d("CHECK", "density:" + display.density + "//dpi:" + display.densityDpi);

        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
