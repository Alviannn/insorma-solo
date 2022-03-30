package com.github.alviannn.insorma;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.adapters.ProductItemAdapter;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String username = this.getIntent().getStringExtra(SharedData.CURRENT_USERNAME_KEY);
        this.setTitle("Welcome, " + username);

        List<Product> productList = SharedData.PRODUCT_LIST;
        RecyclerView productsRecycler = findViewById(R.id.recycler_products);
        TextView noProductsText = findViewById(R.id.no_product_text);

        ProductItemAdapter adapter = new ProductItemAdapter(productList, this);

        productsRecycler.setAdapter(adapter);
        productsRecycler.setLayoutManager(new LinearLayoutManager(this));

        if (productList.isEmpty()) {
            noProductsText.setVisibility(View.VISIBLE);
            productsRecycler.setVisibility(View.GONE);
        } else {
            noProductsText.setVisibility(View.GONE);
            productsRecycler.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_navigation, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.home_item:
                return true;
            case R.id.transaction_item:
                intent = new Intent(this, TransactionHistoryActivity.class);
                break;
            case R.id.profile_item:
                intent = new Intent(this, ProfileActivity.class);
                break;
        }

        if (intent != null) {
            String username = this.getIntent().getStringExtra(SharedData.CURRENT_USERNAME_KEY);

            intent.putExtra(SharedData.CURRENT_USERNAME_KEY, username);
            this.startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Toast.makeText(this, resultCode, Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
    }
}