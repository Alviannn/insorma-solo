package com.github.alviannn.insorma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.github.alviannn.insorma.adapters.ProductItemAdapter;
import com.github.alviannn.insorma.shared.SharedData;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView productsRecycler = findViewById(R.id.recycler_products);
        ProductItemAdapter adapter = new ProductItemAdapter(SharedData.PRODUCT_LIST);

        productsRecycler.setAdapter(adapter);
        productsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

}