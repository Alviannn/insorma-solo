package com.github.alviannn.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailField, usernameField, phoneField, passwordField;
    private Button createAccountBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailField = findViewById(R.id.email_address);
        usernameField = findViewById(R.id.username);
        phoneField = findViewById(R.id.phone_number);
        passwordField = findViewById(R.id.password);

        createAccountBtn = findViewById(R.id.create_account_btn);
        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == loginBtn) {
            finish();
        } else if (view == createAccountBtn) {
            String email = emailField.getText().toString();
            String username = usernameField.getText().toString();
            String phone = phoneField.getText().toString();
            String password = passwordField.getText().toString();

            String errorMessage = "";

            boolean emailValid = email.matches("^[a-zA-Z\\d._-]{3,}@[a-zA-Z\\d._-]{3,}\\.com$");
            boolean usernameValid = username.matches("^.{3,20}$");
            boolean passwordValid = password.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).+${8,}");

            List<User> users = SharedData.USER_LIST;

            if (email.isEmpty() || username.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                errorMessage = "All fields must be filled";
            } else if (!emailValid) {
                errorMessage = "Email should contain '@' and ends with '.com'";
            }  else if (!usernameValid) {
                errorMessage = "Username must be between 3 to 20 characters long";
            }  else if (!passwordValid) {
                errorMessage =
                        "Password must be alphanumeric (has alphabet and number), " +
                        "and must be 8 characters or more";
            } else if (SharedData.doesUserExists(email, username) != null) {
                errorMessage = "Email and username must be unique";
            }

            if (!errorMessage.isEmpty()) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User(email, username, phone, password);
            users.add(user);

            Toast.makeText(
                    this,
                    "Account is successfully registered",
                    Toast.LENGTH_SHORT).show();

            this.finish();
        }
    }

}