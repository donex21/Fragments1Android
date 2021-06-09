package com.example.seatwork1fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Fragment inputFragment, viewFragment, modifyItemPriceFragment, modifyItemQtyFragment, displayAuthorFragment, removeItemFragment;
    Button back_btn;
    static ArrayList<ItemList> items = new ArrayList<>(10);
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back_btn = findViewById(R.id.back_btn);
        inputFragment = new InputFragment();
        viewFragment = new ViewFragment();
        modifyItemPriceFragment = new ModifyItemPriceFragment();
        modifyItemQtyFragment =new ModifyItemQtyFragment();
        removeItemFragment =new RemoveItemFragment();
        displayAuthorFragment = new DisplayAuthorFragment();

        Intent intent = getIntent();
        String fName = intent.getStringExtra("fragment_value");

        ArrayList<String> codes = new ArrayList<>(10);
        for ( ItemList item: items) {
            codes.add(item.getItemCode());
        }

        if(fName.equals("input_btn")){

            inputFragment = InputFragment.newInstance(codes);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, inputFragment).commit();
        }else if(fName.equals("View_btn")){
            if(items.size() == 0){
                Toast.makeText(MainActivity2.this,"No item in the List",Toast.LENGTH_SHORT).show();
            }else{
                ItemList item = items.get(items.size() -1);
                String itemcode = item.getItemCode();
                String itemdesc = item.getItem_desc();
                String itemprice = item.getPrice();
                String itemqty = item.getQty();
                viewFragment = ViewFragment.newInstance(itemcode, itemdesc, itemprice, itemqty);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, viewFragment).commit();
            }

        }else if(fName.equals("modify_item_price_btn")){
            modifyItemPriceFragment = ModifyItemPriceFragment.newInstance(codes);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, modifyItemPriceFragment).commit();
        }else if(fName.equals("modify_item_qty_btn")){
            modifyItemQtyFragment = ModifyItemQtyFragment.newInstance(codes);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, modifyItemQtyFragment).commit();
        }
        else if(fName.equals("remove_item_btn")){
            items.clear();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, removeItemFragment).commit();
        }
        else if(fName.equals("display_author_btn")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, displayAuthorFragment).commit();
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void InputValue(String code, String desc, String price, String qty){
        items.add(new ItemList(code, desc, price, qty));
    }

    public void modifyItemPrice(String code, String new_price){
       for(int i = 0; i < items.size(); i++){
           if(items.get(i).getItemCode().equals(code)){
               items.get(i).setPrice(new_price);
           }
       }
    }

    public void modifyItemQty(String code, String new_qty){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItemCode().equals(code)){
                items.get(i).setQty(new_qty);
            }
        }
    }
}