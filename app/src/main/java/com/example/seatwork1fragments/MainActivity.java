package com.example.seatwork1fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button input_btn;
    Button view_btn;
    Button modify_item_price_btn;
    Button modify_item_qty_btn;
    Button remove_item_btn;
    Button display_author_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_btn = findViewById(R.id.input_btn);
        view_btn = findViewById(R.id.view_btn);
        modify_item_price_btn = findViewById(R.id.modify_item_price_btn);
        modify_item_qty_btn = findViewById(R.id.modify_item_qty_btn);
        remove_item_btn = findViewById(R.id.remove_item_btn);
        display_author_btn = findViewById(R.id.display_author_btn);

        input_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "input_btn");
                startActivity(myIntent);
            }
        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "View_btn");
                startActivity(myIntent);
            }
        });
        modify_item_price_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "modify_item_price_btn");
                startActivity(myIntent);
            }
        });
        modify_item_qty_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "modify_item_qty_btn");
                startActivity(myIntent);
            }
        });
        remove_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "remove_item_btn");
                startActivity(myIntent);
            }
        });
        display_author_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("fragment_value", "display_author_btn");
                startActivity(myIntent);
            }
        });
    }
}