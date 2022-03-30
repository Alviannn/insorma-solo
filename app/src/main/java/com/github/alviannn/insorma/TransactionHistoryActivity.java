package com.github.alviannn.insorma;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.alviannn.insorma.adapters.TransactionHistoryItemAdapter;
import com.github.alviannn.insorma.models.Transaction;
import com.github.alviannn.insorma.models.User;
import com.github.alviannn.insorma.shared.SharedData;

import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        String username = this.getIntent().getStringExtra(SharedData.CURRENT_USERNAME_KEY);
        User user = SharedData.findUser(username, null);
        assert user != null;

        List<Transaction> transactions = user.getTransactions();

        RecyclerView transactionsRecycler = findViewById(R.id.recycler_transactions);
        TextView noTransactionsText = findViewById(R.id.no_transactions_text);

        TransactionHistoryItemAdapter adapter = new TransactionHistoryItemAdapter(transactions);

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