package com.github.alviannn.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private User currentUser;

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

        String currentUsername = this.getIntent().getStringExtra(SharedData.CURRENT_USERNAME_KEY);
        currentUser = SharedData.findUser(currentUsername, null);
        assert currentUser != null;

        email.setText(currentUser.getEmail());
        username.setText(currentUser.getUsername());
        phone.setText(currentUser.getPhone());

        editProfileBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        deleteAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = this.getIntent();

        if (view == editProfileBtn) {
            editProfileBtn.setVisibility(View.GONE);
            username.setVisibility(View.GONE);

            saveBtn.setVisibility(View.VISIBLE);
            usernameEdit.setVisibility(View.VISIBLE);

            usernameEdit.setText(currentUser.getUsername());
        } else if (view == saveBtn) {
            String newUsername = usernameEdit.getText().toString();

            User foundUser = SharedData.findUser(newUsername, null);
            if (foundUser != null && foundUser != currentUser) {
                Toast.makeText(
                        this,
                        "This username is already being used",
                        Toast.LENGTH_SHORT)
                .show();
                return;
            }

            currentUser.setUsername(newUsername);
            usernameEdit.setText("");
            username.setText(newUsername);

            intent.putExtra(SharedData.CURRENT_USERNAME_KEY, newUsername);
            this.setResult(SharedData.USER_CHANGE_CODE, intent);

            editProfileBtn.setVisibility(View.VISIBLE);
            username.setVisibility(View.VISIBLE);

            saveBtn.setVisibility(View.GONE);
            usernameEdit.setVisibility(View.GONE);
        } else if (view == logoutBtn) {
            intent.removeExtra(SharedData.CURRENT_USERNAME_KEY);

            this.setResult(SharedData.USER_CHANGE_CODE, intent);
            this.finish();
        } else if (view == deleteAccountBtn) {
            SharedData.USER_LIST.remove(currentUser);

            intent.removeExtra(SharedData.CURRENT_USERNAME_KEY);

            this.setResult(SharedData.USER_CHANGE_CODE, intent);
            this.finish();
        }
    }

}