package com.example.project_cart_checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder>{


    private Context context;
    private List<Book> bookList;
    private static boolean priceBlue = false;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, price;
        ImageView cover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView)  itemView.findViewById(R.id.price);
            if(priceBlue){
                price.setTextColor(0xff05aaff);
            }
            cover = (ImageView) itemView.findViewById(R.id.cover);
        }
    }

    public CartItemAdapter(Context c, List<Book> bookList, boolean blue){
        this.context = c;
        this.bookList = bookList;
        this.priceBlue = blue;

    }


    @NonNull
    @Override
    public CartItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.ViewHolder holder, int position) {

        Book r = bookList.get(position);
        holder.title.setText(r.getTitle());
        holder.price.setText(r.getPrice());
        holder.cover.setImageResource(r.getCoverId());

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
