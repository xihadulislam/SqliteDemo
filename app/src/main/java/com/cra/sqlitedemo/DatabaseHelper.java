package com.cra.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {



   public final  static int VERSION = 1;
    public final static String DATABASE_NAME= "mydb";
    public final static String TABLE_NAME= "mytable";


    public  final  static  String Name = "name";
    public  final  static  String Address = "address";
    public  final  static  String Phone = "phone";
    public  final  static  String Id = "id";


    Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT,phone TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public long insertData(String name, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Name, name);
        cv.put(Address, address);
        cv.put(Phone, phone);
        long ts = db.insert(TABLE_NAME, null, cv);

        return ts;
    }



    public Cursor getData() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return result;

    }


    public int delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int value = db.delete(TABLE_NAME, Name + "= ?", new String[]{id});
        return value;
    }


    public long updatedata( String id, String name, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Name, name);
        cv.put(Address, address);
        cv.put(Phone, phone);

        long ts = db.update(TABLE_NAME,cv,Id + "= ?", new String[]{id});

        return ts;
    }




}

