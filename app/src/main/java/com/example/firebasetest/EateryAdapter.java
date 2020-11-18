package com.example.firebasetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EateryAdapter  extends RecyclerView.Adapter<EateryAdapter.EateryHolder> {
    //We create an arrayLst for our class where we hold the attributes.
    ArrayList<Accounts> list;

    // create an constructor for arrayList. Use generate/constructor/select arrayList
    public EateryAdapter(ArrayList<Accounts> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public EateryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eaterycard,parent, false);
        EateryHolder holder = new EateryHolder(v); //take v like parameter
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EateryHolder holder, int position) {
        holder.tv.setText(list.get(position).getFn());
        Picasso.get().load(list.get(position).getUrl()).fit().into(holder.iv);
        //We have to import our Picasso Library

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EateryHolder extends RecyclerView.ViewHolder
    {
        //create impostors for image view adn text view to be used in EateryHolder.class
        ImageView iv;
        TextView tv;

        public EateryHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_card);
            tv = itemView.findViewById(R.id.tv_card);
        }
    }
}
