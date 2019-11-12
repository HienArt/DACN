package com.example.appdcapplication.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appdcapplication.Model.Category;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "dataDocument.db";
    private static final int DB_VER = 1;

    public static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context)
    {
        if (instance==null){
            instance = new DBHelper(context);
        }
        return instance;
    }


    public DBHelper(Context context) {
        super(context, DB_NAME, null,DB_VER);
    }


    public List<Category> getAllCategories()
    {
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Category",null);
        List<Category> categories = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast())
            {
                Category category = new Category(cursor.getInt(cursor.getColumnIndex("CategoryID")),
                        cursor.getString(cursor.getColumnIndex("CategoryName")));
                categories.add(category);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return categories;
    }
}
