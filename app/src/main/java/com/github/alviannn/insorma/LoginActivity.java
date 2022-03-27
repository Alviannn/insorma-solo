package com.github.alviannn.insorma;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailField, passwordField;
    private Button loginBtn, createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // I only want the white/day mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        emailField = findViewById(R.id.email_address);
        passwordField = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);
        createAccountBtn = findViewById(R.id.create_account_btn);

        loginBtn.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);
    }

    @Nullable
    private User findUser(String email, String password) {
        for (User user : SharedData.REGISTERED_USERS) {
            boolean sameEmail = user.getEmail().equals(email);

            if (sameEmail) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void onClick(View view) {
        if (view == loginBtn) {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            User foundUser = this.findUser(email, password);
            if (foundUser == null) {
                Toast.makeText(this, "Cannot find user", Toast.LENGTH_SHORT).show();
                return;
            }
            if (foundUser.getPassword().equals(password)) {
                Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show();
        } else if (view == createAccountBtn) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

}