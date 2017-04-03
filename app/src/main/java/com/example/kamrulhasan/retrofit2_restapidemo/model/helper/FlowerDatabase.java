package com.example.kamrulhasan.retrofit2_restapidemo.model.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kamrulhasan.retrofit2_restapidemo.model.Flower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamrul hasan on 2/11/2017.
 */

public class FlowerDatabase extends SQLiteOpenHelper {
    private static final String TAG = FlowerDatabase.class.getSimpleName() ;

    public FlowerDatabase(Context context) {
        super(context, Constants.DATABASE.DB_NAME, null, Constants.DATABASE.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Constants.DATABASE.CREATE_TABLE_QUERY);
        }catch (SQLException ex){
            Log.d(TAG, ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constants.DATABASE.DROP_QUERY);
        this.onCreate(db);

    }

    public void  addFlower(Flower flower){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values = new ContentValues();

        values.put(Constants.DATABASE.PRODUCT_ID, flower.getProductId());
        values.put(Constants.DATABASE.CATEGORY, flower.getCategory());
        values.put(Constants.DATABASE.PRICE, flower.getPrice()+"");
        values.put(Constants.DATABASE.INSTRUCTION, flower.getInstructions());
        values.put(Constants.DATABASE.NAME, flower.getName());
        values.put(Constants.DATABASE.PHOTO_URL, flower.getPhoto());
       // values.put(Constants.DATABASE.PHOTO, flower.getPicture());

        db.insert(Constants.DATABASE.TABLE_NAME, null, values);
        db.close();

    }

    public List<Flower> getFlowers(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(Constants.DATABASE.GET_FLOWERS_QUERY,null);

        List<Flower> flowerList =new ArrayList<>();

        if (cursor.getCount() > 0){

            if (cursor.moveToFirst()){
                do{

                }while (cursor.moveToNext());
            }
        }

        return flowerList;
    }
}
