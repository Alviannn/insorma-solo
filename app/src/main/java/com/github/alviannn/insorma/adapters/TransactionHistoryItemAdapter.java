package com.github.alviannn.insorma.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.R;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.models.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TransactionHistoryItemAdapter extends RecyclerView.Adapter<TransactionHistoryItemAdapter.ViewHolder> {

    private final List<Transaction> transactionList;
    private final DateFormat dateFormat;

    public TransactionHistoryItemAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
        this.dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.transaction_history_item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        Product product = transaction.getProduct();

        holder.transactionId.setText("ID: " + transaction.getId());
        holder.productName.setText("Name: " + product.getName());
        holder.productQuantity.setText("Quantity: " + transaction.getQuantity());
        holder.productTotalPrice.setText("Total price: $" + transaction.getTotalPrice());
        holder.purchaseDate.setText(dateFormat.format(transaction.getTransactionDate()));
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView transactionId;
        private final TextView productName, productQuantity, productTotalPrice;
        private final TextView purchaseDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            transactionId = itemView.findViewById(R.id.transaction_id);

            productName = itemView.findViewById(R.id.product_name);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            productTotalPrice = itemView.findViewById(R.id.product_total_price);

            purchaseDate = itemView.findViewById(R.id.purchase_date);
        }

    }

}
