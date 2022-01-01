package com.cedric.aftermathproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText email, fname, lname, username, password, repassword;
    Button signUpBtn, signInBtn;
    DatabaseHelper myDatabase;

    public Boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        String passwordValidation = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(passwordValidation);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Hooks
        email = (EditText) findViewById(R.id.register_email);
        fname = (EditText) findViewById(R.id.register_fname);
        lname = (EditText) findViewById(R.id.register_lname);
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        repassword = (EditText) findViewById(R.id.register_repassword);
        signUpBtn = (Button) findViewById(R.id.signup_btn);
        signInBtn = (Button) findViewById(R.id.back_to_login_btn);

        myDatabase = new DatabaseHelper(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = email.getText().toString();
                String firstName = fname.getText().toString();
                String lastName = lname.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (emailAddress.equals("") || firstName.equals("") || lastName.equals("") || user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Fill all the required fields.", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        if (password.getText().toString().length() >= 8 && isValidPassword(password.getText().toString())) {
                            // Check if username exists.
                            Boolean usernameCheckResult = myDatabase.checkUsername(user);
                            if (usernameCheckResult == false) {
                                Boolean registrationResult = myDatabase.insertData(emailAddress, firstName, lastName, user, pass);
                                if (registrationResult == true) {
                                    Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                                    Intent registerSuccess = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(registerSuccess);
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(RegisterActivity.this, "Username already exist.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this,"Password must contain at least a small character, capital character, number, and special character. It must be at least 8 characters.",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password does not match.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceedLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(proceedLogin);
            }
        });
    }
}