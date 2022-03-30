package com.github.alviannn.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView username;
    private Button editProfileBtn, saveBtn, logoutBtn, deleteAccountBtn;
    private EditText usernameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView email = findViewById(R.id.email_address);
        TextView phone = findViewById(R.id.phone);

        username = findViewById(R.id.username);
        usernameEdit = findViewById(R.id.username_edit);

        editProfileBtn = findViewById(R.id.edit_profile_btn);
        saveBtn = findViewById(R.id.save_btn);
        logoutBtn = findViewById(R.id.logout_btn);
        deleteAccountBtn = findViewById(R.id.delete_account_btn);

        User user = SharedData.CURRENT_USER;

        email.setText(user.getEmail());
        username.setText(user.getUsername());
        phone.setText(user.getPhone());

        editProfileBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        deleteAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        User user = SharedData.CURRENT_USER;

        if (view == editProfileBtn) {
            editProfileBtn.setVisibility(View.GONE);
            username.setVisibility(View.GONE);

            saveBtn.setVisibility(View.VISIBLE);
            usernameEdit.setVisibility(View.VISIBLE);

            usernameEdit.setText(user.getUsername());
        } else if (view == saveBtn) {
            String newUsername = usernameEdit.getText().toString();

            User foundUser = SharedData.doesUserExists(newUsername, null);
            if (foundUser != null && foundUser != user) {
                Toast.makeText(
                        this,
                        "This username is already being used",
                        Toast.LENGTH_SHORT)
                .show();
                return;
            }

            user.setUsername(newUsername);
            usernameEdit.setText("");
            username.setText(newUsername);

            editProfileBtn.setVisibility(View.VISIBLE);
            username.setVisibility(View.VISIBLE);

            saveBtn.setVisibility(View.GONE);
            usernameEdit.setVisibility(View.GONE);
        } else if (view == logoutBtn) {
            SharedData.CURRENT_USER = null;
            this.finish();
        } else if (view == deleteAccountBtn) {
            SharedData.USER_LIST.remove(user);
            SharedData.CURRENT_USER = null;

            this.finish();
        }
    }

}