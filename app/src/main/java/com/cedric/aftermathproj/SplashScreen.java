package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2000;
    SharedPreferences sp;
    Animation animation;
    ImageView splashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // Animation
        animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash_anim);

        // Hooks
        splashLogo = findViewById(R.id.splash_logo);
        splashLogo.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Shared Preferences
                sp = getSharedPreferences("SessionID", MODE_PRIVATE);
                boolean isFirstTime = sp.getBoolean("isFirstTime", true);
                if (isFirstTime) {
                    // Setting isFirstTime to False
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFirstTime", false);
                    editor.commit();

                    // Redirect to Intent after SPLASH_SCREEN seconds.
                    Intent onBoardingActivity = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(onBoardingActivity);
                    finish();
                } else {
                    Intent mainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }
        }, SPLASH_SCREEN);
    }
}