package com.example.sub_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "subsDB.db";
    public static final String TABLE_NAME = "subs_table";
    public static final String ID = "_id";
    public static final String SUBNAME = "Subname";
    public static final String PRICE = "Price";
    public static final String EMAIL = "Email";
    public static final String CARD = "Card";
    public static final String STARTDATE = "StartDate";
    public static final String ENDDATE = "EndDate";
    public static final String COLOR = "Color";
    public static final String NOTIF = "Notif";

    public DatabaseHelper(@Nullable Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SUBNAME + " TEXT," +
                PRICE + " INTEGER," +
                EMAIL + " TEXT," +
                CARD + " TEXT," +
                STARTDATE + " TEXT," +
                ENDDATE + " TEXT," +
                COLOR + " TEXT," +
                NOTIF + " TEXT" + ")";
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
        values.put(COLOR, sub.get_color());
        values.put(NOTIF, sub.getNotif());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateSub(Sub sub){
        ContentValues values = new ContentValues();
        values.put(SUBNAME, sub.getSubname());
        values.put(PRICE, sub.getPrice());
        values.put(EMAIL, sub.getEmail());
        values.put(CARD, sub.getCard());
        values.put(STARTDATE, sub.getStartdate());
        values.put(ENDDATE, sub.getEnddate());
        values.put(NOTIF, sub.getNotif());
       SQLiteDatabase db = this.getWritableDatabase();
       db.update(TABLE_NAME, values, "_id=" + sub.getID(), null);
       db.close();
    }

    // Finding on the DB based on its name
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
            sub.set_color(cursor.getString(7));
            sub.setNotif(cursor.getString(8));
            cursor.close();
        } else {
            sub = null;
        }
        db.close();
        return sub;
    }

    //Delete from DB
    public boolean deleteSub(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ID + "=" + id, null) > 0;
    }

    public ArrayList<Sub> load(){
        ArrayList<Sub> subs = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor =
                db.rawQuery(query, null);

        int rows = cursor.getCount();
        cursor.moveToFirst();

        for(int i = 0; i < rows; i++){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            String email = cursor.getString(3);
            String card = cursor.getString(4);
            String startDate = cursor.getString(5);
            String endDate = cursor.getString(6);
            String color = cursor.getString(7);
            String notif = cursor.getString(8);
            Sub sub = new Sub(id, name, price, email, card, startDate, endDate, color, notif);
            subs.add(sub);
            cursor.moveToNext();
        }

        return subs;
    }

}
