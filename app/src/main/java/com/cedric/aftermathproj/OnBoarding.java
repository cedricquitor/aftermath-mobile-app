package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView onboardingLoginTxt;
    TextView[] dots;
    Button letsGetStartedBtn, onboardingLoginBtn, skipBtn, nextBtn;
    Animation animation;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        // Removing Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hooks
        onboardingLoginTxt = findViewById(R.id.onboarding_login_txt);
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        onboardingLoginBtn = (Button) findViewById(R.id.login_btn);
        letsGetStartedBtn = (Button) findViewById(R.id.get_started_btn);
        skipBtn = (Button) findViewById(R.id.skip_btn);
        nextBtn = (Button) findViewById(R.id.next_btn);

        // Call SliderAdapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(OnBoarding.this, MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPos + 1);
            }
        });

        letsGetStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivity = new Intent(OnBoarding.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });

        onboardingLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginActivity = new Intent(OnBoarding.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }

    private void addDots(int position) {
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dark_gray));

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.primary_color));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            // currentPos = Screen Position
            currentPos = position;

            if (position == 0) {
                letsGetStartedBtn.setVisibility(View.INVISIBLE);
                onboardingLoginTxt.setVisibility(View.INVISIBLE);
                onboardingLoginBtn.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                letsGetStartedBtn.setVisibility(View.INVISIBLE);
                onboardingLoginTxt.setVisibility(View.INVISIBLE);
                onboardingLoginBtn.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                letsGetStartedBtn.setVisibility(View.INVISIBLE);
                onboardingLoginTxt.setVisibility(View.INVISIBLE);
                onboardingLoginBtn.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                letsGetStartedBtn.setAnimation(animation);
                letsGetStartedBtn.setVisibility(View.VISIBLE);
                onboardingLoginTxt.setAnimation(animation);
                onboardingLoginTxt.setVisibility(View.VISIBLE);
                onboardingLoginBtn.setAnimation(animation);
                onboardingLoginBtn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}