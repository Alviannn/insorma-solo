package com.github.alviannn.insorma.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.ProductDetailActivity;
import com.github.alviannn.insorma.R;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class ProductItemAdapter extends RecyclerView.Adapter<ProductItemAdapter.ViewHolder> {

    private final List<Product> productList;
    private final Activity activity;

    public ProductItemAdapter(List<Product> productList, Activity activity) {
        this.productList = productList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.productImage.setImageResource(product.getImageId());
        holder.productName.setText(product.getName());
        holder.productPrice.setText("$" + product.getPrice());
        holder.productRating.setText("Rating: " + product.getRating() + " / 5.0");
        holder.productDetailBtn.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ProductDetailActivity.class);
            String username = activity.getIntent().getStringExtra(SharedData.CURRENT_USERNAME_KEY);

            intent.putExtra(SharedData.CURRENT_USERNAME_KEY, username);
            intent.putExtra(SharedData.PRODUCT_POSITION_KEY, position);

            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView productImage;
        private final TextView productName, productRating, productPrice;
        private final TextView productDetailBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_img);

            productName = itemView.findViewById(R.id.product_name);
            productRating = itemView.findViewById(R.id.product_rating);
            productPrice = itemView.findViewById(R.id.product_price);

            productDetailBtn = itemView.findViewById(R.id.product_detail_btn);
        }

    }

}
