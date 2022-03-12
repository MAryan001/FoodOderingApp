package com.example.foododeringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foododeringapp.Models.OdersModel;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "myDataBase.db";
    final static int DBVersion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders "+
                        "(id integer primary key ," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "quantity int," +
                        "image int," +
                        "description text," +
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("Drop table if exists orders");
        onCreate(sqLiteDatabase);

    }
    public boolean insertOrders(String name,String phone, int image, int price,String description,String foodName,int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodName",foodName);
        values.put("quantity",quantity);
        long id = database.insert("orders",null,values);
        if (id <= 0){
            return false;
        }else {
            return true;
        }
    }
    public ArrayList<OdersModel> getOrders() {
        ArrayList<OdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodName,image,price From Orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OdersModel model = new OdersModel();
                model.setOderNumber(cursor.getInt(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setPrice(cursor.getInt(2) + "");
                model.setOderImage(cursor.getInt(3));
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * From Orders where id = "+ id, null);

        if (cursor != null)
            cursor.moveToNext();

        return cursor;
    }
    public boolean updateOrders(String name,String phone, int image, int price,String description,String foodName,int quantity,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodName",foodName);
        values.put("quantity",quantity);
        long row = database.update("orders",values,"id"+id,null);
        if (row <= 0){
            return false;
        }else {
            return true;
        }
    }
    public int deleteOrder (String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id = "+id,null);
    }
}
