package com.example.foododeringapp.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foododeringapp.DBHelper;
import com.example.foododeringapp.DetailActivity;
import com.example.foododeringapp.Models.OdersModel;
import com.example.foododeringapp.OrderActivity;
import com.example.foododeringapp.R;

import java.util.ArrayList;

public class OderAdapter extends RecyclerView.Adapter<OderAdapter.viewHolder>{

    ArrayList<OdersModel> list;
    Context context;

    public OderAdapter(ArrayList<OdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.oder_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OdersModel model = list.get(position);
        holder.oder_image.setImageResource(model.getOderImage());
        holder.oder_name.setText(model.getSoldItemName());
        holder.oder_number.setText(model.getOderNumber());
        holder.oder_price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOderNumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context)
                .

                    setTitle("Delete Item")
                        .

                    setMessage("Are you sure you want to delete item")
                        .

                    setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialog,int which){
                            DBHelper helper = new DBHelper(context);
                            if (helper.deleteOrder(model.getOderNumber()) > 0) {
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView oder_image;
        TextView oder_number,oder_price,oder_name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            oder_image = itemView.findViewById(R.id.oder_image);
            oder_number = itemView.findViewById(R.id.oder_number);
            oder_price = itemView.findViewById(R.id.oder_price);
            oder_name = itemView.findViewById(R.id.oder_name);

        }
    }
}
