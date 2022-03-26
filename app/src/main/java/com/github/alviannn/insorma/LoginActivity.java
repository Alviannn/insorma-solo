package com.github.alviannn.insorma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.github.alviannn.insorma.models.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final List<User> registeredUsers = new ArrayList<>();

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
        createAccountBtn = findViewById(R.id.new_account_btn);

        loginBtn.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);
    }

    @Nullable
    private User findUser(String email, String password) {
        for (User user : registeredUsers) {
            boolean sameEmail = user.getEmail().equals(email);
            boolean samePassword = user.getPassword().equals(password);

            if (sameEmail && samePassword) {
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

            // TODO: switch to home page
        } else if (view == createAccountBtn) {
            // TODO: switch to register page
        }
    }

}