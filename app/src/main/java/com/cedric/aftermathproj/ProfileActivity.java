package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    DatabaseHelper myDatabase;
    Button userBackBtn, logoutBtn;
    TextView profileEmail, profileName, profileUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Hooks
        userBackBtn = (Button) findViewById(R.id.user_back_btn);
        logoutBtn = (Button) findViewById(R.id.profile_logout_btn);
        profileEmail = (TextView) findViewById(R.id.news_title_txt);
        profileName = (TextView) findViewById(R.id.profile_name_data);
        profileUsername = (TextView) findViewById(R.id.profile_username_data);

        // Retrieving Data
        myDatabase = new DatabaseHelper(this);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("SessionID", Context.MODE_PRIVATE);
        Cursor cursor = myDatabase.viewData(sp.getString("loginSession", ""));
        StringBuilder retrievedEmail = new StringBuilder();
        while (cursor.moveToNext()) {
            profileEmail.setText(cursor.getString(0));
            profileName.setText(cursor.getString(1) + " " + cursor.getString(2));
            profileUsername.setText(cursor.getString(3));
        }

        // Back Button
        userBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToHome = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(backToHome);
            }
        });

        // Logout Button
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(ProfileActivity.this, LoginActivity.class);
                Toast.makeText(ProfileActivity.this, "User successfully logged out.", Toast.LENGTH_SHORT).show();
                SharedPreferences sp = getApplicationContext().getSharedPreferences("SessionID", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("loginSession");
                editor.putBoolean("isLoggedIn", false);
                editor.commit();
                startActivity(loginActivity);
            }
        });
    }
}