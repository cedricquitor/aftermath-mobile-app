package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button loginBtn;
    DatabaseHelper myDatabase;
    SharedPreferences sp;
    String usernameSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        loginBtn = (Button) findViewById(R.id.login_btn);

        myDatabase = new DatabaseHelper(this);

        sp = getSharedPreferences("SessionID", Context.MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Fill all the required fields.", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean resultCheckUserPass = myDatabase.checkUsernamePassword(user, pass);
                    if (resultCheckUserPass == true) {
                        usernameSession = username.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("loginSession", usernameSession);
                        editor.putBoolean("isLoggedIn", true);
                        editor.commit();
                        Intent redirectHomepage = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(redirectHomepage);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid username and/or password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}