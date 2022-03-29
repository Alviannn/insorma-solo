package com.github.alviannn.insorma.abstracts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.alviannn.insorma.R;
import com.github.alviannn.insorma.TransactionHistoryActivity;

public abstract class AbstractMenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_navigation, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        // TODO: add current activity check

        switch (item.getItemId()) {
            case R.id.home_item:
                Toast.makeText(this, "Home page, it is", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.trasaction_item:
                intent = new Intent(this, TransactionHistoryActivity.class);
                startActivity(intent);
                return true;
            case R.id.profile_item:
                Toast.makeText(this, "Profile page, it is", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
