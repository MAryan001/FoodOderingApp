package com.example.foododeringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foododeringapp.Adapter.OderAdapter;
import com.example.foododeringapp.Models.MainModel;
import com.example.foododeringapp.Models.OdersModel;
import com.example.foododeringapp.databinding.ActivityOderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<OdersModel> list = helper.getOrders();




        OderAdapter adapter = new OderAdapter(list,this);
        binding.oderRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.oderRecycler.setLayoutManager(layoutManager);
    }
}