package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    Button newsBackBtn;
    TextView newsTopTxt, newsTitleTxt, newsAuthorTxt, newsDateTxt, newsHeaderTxt, newsContentTxt;
    ImageView newsImg;

    private static final String TAG = "NewsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Hooks
        newsBackBtn = findViewById(R.id.news_back_btn);

        String extraNewsGame = getIntent().getStringExtra("extraNewsGame");
        newsTopTxt = findViewById(R.id.news_top_txt);
        newsTopTxt.setText(extraNewsGame + " News");

        String extraNewsTitle = getIntent().getStringExtra("extraNewsTitle");
        newsTitleTxt = findViewById(R.id.news_title_txt);
        newsTitleTxt.setText(extraNewsTitle);

        String extraNewsAuthor = getIntent().getStringExtra("extraNewsAuthor");
        newsAuthorTxt = findViewById(R.id.news_author_txt);
        newsAuthorTxt.setText(extraNewsAuthor);

        String extraNewsDate = getIntent().getStringExtra("extraNewsDate");
        newsDateTxt = findViewById(R.id.news_date_txt);
        newsDateTxt.setText(extraNewsDate);

        String extraNewsHeader = getIntent().getStringExtra("extraNewsHeader");
        newsHeaderTxt = findViewById(R.id.news_header_txt);
        newsHeaderTxt.setText(extraNewsHeader);

        String extraNewsContent = getIntent().getStringExtra("extraNewsContent");
        newsContentTxt = findViewById(R.id.news_content_txt);
        newsContentTxt.setText(extraNewsContent);

        int extraNewsImg = getIntent().getIntExtra("extraNewsImg", 0);
        newsImg = findViewById(R.id.news_activity_img);
        newsImg.setImageResource(extraNewsImg);

        // Back Button SET TO IF VALORANT GO BACK TO VALORANT IF LEAGUE GO BACK TO LEAGUE
        newsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (extraNewsGame.equals("VALORANT")) {
                    Intent backToPrevious = new Intent(NewsActivity.this, ValorantActivity.class);
                    startActivity(backToPrevious);
                } else if (extraNewsGame.equals("League of Legends")) {
                    Intent backToPrevious = new Intent(NewsActivity.this, LeagueActivity.class);
                    startActivity(backToPrevious);
                } else {
                    Intent backToPrevious = new Intent(NewsActivity.this, MainActivity.class);
                    startActivity(backToPrevious);
                }



            }
        });
    }
}
