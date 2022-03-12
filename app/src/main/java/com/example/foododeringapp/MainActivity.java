package com.example.foododeringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.foododeringapp.Adapter.MainAdapter;
import com.example.foododeringapp.Models.MainModel;
import com.example.foododeringapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("       Order your Food");

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));
        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));
        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));
        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));
        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));
        list.add(new MainModel(R.drawable.burger,"Burger","8","Cheese Burger"));
        list.add(new MainModel(R.drawable.pizza,"pizza","8","Cheese pizza"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.mainRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.mainRecycler.setLayoutManager(linearLayoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}