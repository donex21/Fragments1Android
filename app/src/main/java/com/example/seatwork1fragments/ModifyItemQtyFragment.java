package com.example.seatwork1fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class ModifyItemQtyFragment extends Fragment {

    Button submit_new_qty_btn;
    EditText new_Item_qty;
    Spinner spinner_codes;
    String selected_code = "";

    public static ModifyItemQtyFragment newInstance(ArrayList<String> codes) {
        ModifyItemQtyFragment modifyItemQtyFragment = new ModifyItemQtyFragment();
        Bundle b1 = new Bundle();
        b1.putStringArrayList("codes", codes);
        modifyItemQtyFragment.setArguments(b1);
        return modifyItemQtyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modify_item_qty, container, false);
        submit_new_qty_btn = view.findViewById(R.id.submit_new_qty_btn);
        new_Item_qty = view.findViewById(R.id.new_Item_qty);
        spinner_codes = view.findViewById(R.id.spinner_codes);

        ArrayList<String> codes = new ArrayList<>(10);
        if(getArguments() != null){
            codes = getArguments().getStringArrayList("codes");
        }

        ArrayAdapter<String> adaptercodes = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, codes);
        adaptercodes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_codes.setAdapter(adaptercodes);
        spinner_codes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_code = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit_new_qty_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(new_Item_qty.getText().toString().equals("")){
                    Toast.makeText(getActivity(),"Pls. Input New Quantity",Toast.LENGTH_SHORT).show();
                }else{
                    MainActivity2 mainActivity2 = (MainActivity2)getActivity();
                    mainActivity2.modifyItemQty(selected_code, new_Item_qty.getText().toString());
                    Toast.makeText(getActivity(),"Quantity Successfully Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  view;
    }
}