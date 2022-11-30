package com.example.project_cart_checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rv;
    private CartItemAdapter adapter;
    private ArrayList<Book> items;

    private Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        rv = (RecyclerView) findViewById(R.id.myRecycler);
        items = new ArrayList<>();

        items.add(new Book("Maybe Someday", "$35.17", R.drawable.maybe_someday));
        items.add(new Book("Spinning Silver", "$35.17", R.drawable.spinning_silver));

        adapter = new CartItemAdapter(this, items, true);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);

        DividerItemDecoration divider = new DividerItemDecoration(rv.getContext(), layout.getOrientation());
        divider.setDrawable(getDrawable(R.drawable.gradient_divider));
        rv.addItemDecoration(divider);


        checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(i);
            }
        });

    }


}