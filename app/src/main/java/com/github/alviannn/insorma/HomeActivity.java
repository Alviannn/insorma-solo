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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.adapters.ProductItemAdapter;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User user = SharedData.CURRENT_USER;
        this.setTitle("Welcome, " + user.getUsername());

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
        Intent intent;

        switch (item.getItemId()) {
            case R.id.home_item:
                return true;
            case R.id.transaction_item:
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