package com.example.androidb.superquick.adapters;

import android.content.Context;
import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidb.superquick.General.UserSessionData;
import com.example.androidb.superquick.R;
import com.example.androidb.superquick.activities.ShoppingListContentActivity;
import com.example.androidb.superquick.entities.ProductInShoppingList;
import com.example.androidb.superquick.entities.ProductInSuper;
import com.example.androidb.superquick.entities.Super;
import com.parse.ParseObject;

import java.util.List;

public class SuperListAdapter extends BaseAdapter {
    List<Super> supers;
    Context context;
    int shoppingListId;


    public SuperListAdapter(List<Super> supers, Context context,int shoppingListId) {
        this.supers = supers;
        this.context = context;
        this.shoppingListId=shoppingListId;
    }

    @Override
    public int getCount() {
        return supers.size();
    }

    @Override
    public Object getItem(int position) {
        return supers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.single_super,null);
        TextView singleSuper=(TextView)convertView.findViewById(R.id.singleSuper);
        singleSuper.setText(supers.get(position).getSuperName());
        TextView totalPriceTextView=(TextView)convertView.findViewById(R.id.totalPriceTextView);
        float totalPrice=ProductInSuper.shoppingListCostInSuper(supers.get(position).getSuperId(),shoppingListId);
        totalPriceTextView.setText(String.valueOf(totalPrice));
        ProductInSuper.shoppingListCostInSuper(supers.get(position).getSuperId(),shoppingListId);
        singleSuper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSessionData.ChosenSuper(supers.get(position).getSuperId());
            }
        });
        return convertView;
    }
}

