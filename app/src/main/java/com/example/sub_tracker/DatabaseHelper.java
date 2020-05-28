package com.example.sub_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "subsDB.db";
    public static final String TABLE_NAME = "subs_table";
    public static final String SUBNAME = "Subname";
    public static final String ID = "ID";
    public static final String PRICE = "Price";
    public static final String EMAIL = "Email";
    public static final String CARD = "Card";
    public static final String STARTDATE = "StartDate";
    public static final String ENDDATE = "EndDate";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +
                TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SUBNAME + "TEXT," +
                PRICE + " INTEGER," +
                EMAIL + " TEXT," +
                CARD + " TEXT," +
                STARTDATE + " DATE," +
                ENDDATE + " DATE)" + ")";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    //Adding to the DB
    public void addSub(Sub sub) {
        ContentValues values = new ContentValues();
        values.put(SUBNAME, sub.getSubname());
        values.put(PRICE, sub.getPrice());
        values.put(EMAIL, sub.getEmail());
        values.put(CARD, sub.getCard());
        values.put(STARTDATE, sub.getStartdate());
        values.put(ENDDATE, sub.getEnddate());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Finding on the DB based on its name
    public Sub findSub(String Subname) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                SUBNAME + "= '" + Subname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Sub sub = new Sub();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            sub.setID(Integer.parseInt(cursor.getString(0)));
            sub.setSubname(cursor.getString(1));
            sub.setPrice(Integer.parseInt(cursor.getString(2)));
            sub.setEmail(cursor.getString(3));
            sub.setCard(cursor.getString(4));
            sub.setStartdate(cursor.getString(5));
            sub.setEnddate(cursor.getString(6));
            cursor.close();
        } else {
            sub = null;
        }
        db.close();
        return sub;
    }

    //Delete from DB
    public boolean deleteSub(String Subname) {
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                SUBNAME + " = '" + Subname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Sub sub = new Sub();
        if (cursor.moveToFirst()) {
            sub.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(Subname, ID + " = ?",
                    new String[] { String.valueOf(sub.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}
