package com.example.project_cart_checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private RecyclerView rv;
    private CartItemAdapter adapter;
    private ArrayList<Book> items;

    private LinearLayout cardInfo;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        rv = (RecyclerView) findViewById(R.id.myRecycler);
        items = new ArrayList<>();

        items.add(new Book("Maybe Someday", "$35.17", R.drawable.maybe_someday));
        items.add(new Book("Spinning Silver", "$35.17", R.drawable.spinning_silver));

        adapter = new CartItemAdapter(this, items, false);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);

        DividerItemDecoration divider = new DividerItemDecoration(rv.getContext(), layout.getOrientation());
        divider.setDrawable(getDrawable(R.drawable.gradient_divider));
        rv.addItemDecoration(divider);

        cardInfo = (LinearLayout) findViewById(R.id.cardInfo);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // akid lazem yeb2a fi hena kalam ya5od el input ba2a w y7oto fl database w yfadi el cart kman
                // w tab3an yet2aked en mafi4 baynat na2sa..
                Intent i = new Intent(CheckoutActivity.this, CheckoutDoneActivity.class);
                startActivity(i);

            }
        });
    }

    public void editPayOptions(View v){

        switch(v.getId()){
            case(R.id.cash):
                cardInfo.setVisibility(View.GONE);
                break;
            case(R.id.payNow):
                cardInfo.setVisibility(View.VISIBLE);
                cardInfo.setFocusable(true);
                cardInfo.setFocusableInTouchMode(true);
                cardInfo.requestFocus();
                break;
        }

    }
}