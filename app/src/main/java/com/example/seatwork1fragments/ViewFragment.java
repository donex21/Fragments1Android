package com.example.seatwork1fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ViewFragment extends Fragment {

    TextView item_code_text, item_desc_text, item_price_text, item_qty_text, total_price_text;

    public static ViewFragment newInstance(String code, String desc, String price, String qty) {
        ViewFragment viewFragment = new ViewFragment();
        Bundle b1 = new Bundle();
        b1.putString("code", code);
        b1.putString("desc", desc);
        b1.putString("price", price);
        b1.putString("qty", qty);
        viewFragment.setArguments(b1);
        return viewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        item_code_text = view.findViewById(R.id.item_code_text);
        item_desc_text = view.findViewById(R.id.item_desc_text);
        item_price_text = view.findViewById(R.id.item_price_text);
        item_qty_text = view.findViewById(R.id.item_qty_text);
        total_price_text = view.findViewById(R.id.total_price_text);
        if(getArguments()!= null){
            String qty = getArguments().getString("qty");
            String price =  getArguments().getString("price");
            float total_price = Float.parseFloat(price) * Float.parseFloat(qty);
            item_code_text.setText("Item Code: " + getArguments().getString("code"));
            item_desc_text.setText("Item Desc.: " + getArguments().getString("desc"));
            item_price_text.setText("Unit Price: " + price);
            item_qty_text.setText("Unit Quantity: " + qty );
            total_price_text.setText("Total Price: Php" + String.valueOf(total_price));

        }
        return  view;
    }
}