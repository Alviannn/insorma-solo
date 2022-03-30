package com.github.alviannn.insorma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    public void onClick(View view) {
        if (view == loginBtn) {
//            String email = emailField.getText().toString();
//            String password = passwordField.getText().toString();
//
//            if (email.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT)
//                        .show();
//                return;
//            }
//
//            User foundUser = this.findUser(email);
//            if (foundUser == null) {
//                Toast.makeText(this, "Cannot find user", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (!foundUser.getPassword().equals(password)) {
//                Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT)
//                        .show();
//                return;
//            }
//
//            SharedData.CURRENT_USER = foundUser;
            Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show();

            User user = SharedData.USER_LIST.get(0);
            Intent intent = new Intent(this, HomeActivity.class);

            intent.putExtra(SharedData.CURRENT_USERNAME_KEY, user.getUsername());
            startActivity(intent);
        } else if (view == createAccountBtn) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

}