package com.github.alviannn.insorma;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.models.Transaction;
import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.Date;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private Product product;

    private EditText productQuantity;
    private TextView productTotalPrice;
    private Button buyBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        int position = this.getIntent().getIntExtra(SharedData.PRODUCT_POSITION_KEY, -1);
        if (position == -1) {
            finish();
            return;
        }

        product = SharedData.PRODUCT_LIST.get(position);

        ImageView productImage = findViewById(R.id.product_img);
        TextView productName = findViewById(R.id.product_name);
        TextView productRating = findViewById(R.id.product_rating);
        TextView productPrice = findViewById(R.id.product_price);

        productQuantity = findViewById(R.id.product_quantity);
        productTotalPrice = findViewById(R.id.product_total_price);
        buyBtn = findViewById(R.id.buy_btn);

        productImage.setImageResource(product.getImageId());
        productName.setText(product.getName());
        productRating.setText("Rating: " + product.getRating() + " / 5.0");
        productPrice.setText("$" + product.getPrice());

        productQuantity.setText("1");
        this.updateTotalPrice();

        productQuantity.addTextChangedListener(this);
        buyBtn.setOnClickListener(this);
    }

    private int getProductQuantity() {
        String rawText = productQuantity.getText().toString();
        try {
            return Integer.parseInt(rawText);
        } catch (NumberFormatException ignored) {
        }

        return -1;
    }

    @SuppressLint("SetTextI18n")
    private void updateTotalPrice() {
        int quantity = this.getProductQuantity();

        if (quantity < 1) {
            productTotalPrice.setTextColor(this.getColor(R.color.danger));
            productTotalPrice.setText("Invalid total price");
        } else {
            int totalPrice = quantity * product.getPrice();

            productTotalPrice.setTextColor(this.getColor(R.color.primary));
            productTotalPrice.setText("$" + totalPrice);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view != buyBtn) {
            return;
        }

        User user = SharedData.CURRENT_USER;
        int quantity = this.getProductQuantity();

        if (quantity < 1) {
            Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        user.getTransactions().add(new Transaction(product, quantity, new Date()));
        Toast.makeText(this, "Successfully bought product", Toast.LENGTH_SHORT).show();

        this.finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        this.updateTotalPrice();
    }

}