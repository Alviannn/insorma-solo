package com.github.alviannn.insorma;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.abstracts.AbstractMenuActivity;
import com.github.alviannn.insorma.adapters.ProductItemAdapter;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class HomeActivity extends AbstractMenuActivity {

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

}