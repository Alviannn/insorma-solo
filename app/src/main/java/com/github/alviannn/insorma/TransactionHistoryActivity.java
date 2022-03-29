package com.github.alviannn.insorma;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.abstracts.AbstractMenuActivity;
import com.github.alviannn.insorma.adapters.TransactionHistoryItemAdapter;
import com.github.alviannn.insorma.models.Transaction;
import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class TransactionHistoryActivity extends AbstractMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        User user = SharedData.CURRENT_USER;
        List<Transaction> transactions = user.getTransactions();

        RecyclerView transactionsRecycler = findViewById(R.id.recycler_transactions);
        TextView noTransactionsText = findViewById(R.id.no_transactions_text);

        TransactionHistoryItemAdapter adapter = new TransactionHistoryItemAdapter(transactions, this);

        transactionsRecycler.setAdapter(adapter);
        transactionsRecycler.setLayoutManager(new LinearLayoutManager(this));

        if (transactions.isEmpty()) {
            noTransactionsText.setVisibility(View.VISIBLE);
            transactionsRecycler.setVisibility(View.GONE);
        } else {
            noTransactionsText.setVisibility(View.GONE);
            transactionsRecycler.setVisibility(View.VISIBLE);
        }
    }

}