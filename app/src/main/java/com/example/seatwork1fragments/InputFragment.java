package com.example.seatwork1fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class InputFragment extends Fragment {

    EditText item_code_edit, item_desc_edit, unit_price_edit, unit_qty_edit;
    Button submit_btn;
    public static InputFragment newInstance(ArrayList<String> codes) {
        InputFragment inputFragment = new InputFragment();
        Bundle b1 = new Bundle();
        b1.putStringArrayList("codes", codes);
        inputFragment.setArguments(b1);
        return inputFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        submit_btn = view.findViewById(R.id.submit_btn);
        item_code_edit = view.findViewById(R.id.item_code_edit);
        item_desc_edit = view.findViewById(R.id.item_desc_edit);
        unit_price_edit = view.findViewById(R.id.unit_price_edit);
        unit_qty_edit = view.findViewById(R.id.unit_qty_edit);

        ArrayList<String> codes = new ArrayList<>(10);
        if(getArguments() != null){
            codes = getArguments().getStringArrayList("codes");
        }
        if(codes.size() == 0){
            item_code_edit.setText(getCodeString());
        }else{
            item_code_edit.setText(getCodeString(codes));
        }

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item_code_edit.getText().toString().equals("") || item_desc_edit.getText().toString().equals("")
                        || unit_price_edit.getText().toString().equals("") || unit_qty_edit.getText().toString().equals("")){
                    Toast.makeText(getActivity(),"Pls. Complete Details",Toast.LENGTH_SHORT).show();
                }else{
                        MainActivity2 mainActivity2 = (MainActivity2)getActivity();
                        mainActivity2.InputValue(item_code_edit.getText().toString(), item_desc_edit.getText().toString(),
                                unit_price_edit.getText().toString(), unit_qty_edit.getText().toString());
                    Toast.makeText(getActivity(),"Successfully Saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return  view;
    }

    private String getCodeString(ArrayList<String> codesExist) {
        boolean exist = false;
        String codeStr = "";

        do {
            String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder code = new StringBuilder();
            Random rnd = new Random();
            while (code.length() < 8) { // length of the random string.
                int index = (int) (rnd.nextFloat() * CHARS.length());
                code.append(CHARS.charAt(index));
            }
            codeStr = code.toString();

            for (String codeExist : codesExist) {
                if(codeExist.equals(codeStr)){
                    exist = false;
                    break;
                }else {
                    exist = true;
                }
            }
        }while (!exist);
        return codeStr;
    }
    private String getCodeString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        while (code.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            code.append(CHARS.charAt(index));
        }
        String codeStr = code.toString();
        return codeStr;
    }
}