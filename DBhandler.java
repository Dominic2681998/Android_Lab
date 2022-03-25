package com.example.checktestsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBhandler extends SQLiteOpenHelper {


    public DBhandler(Context context) {
        super(context,"testdbb",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists trial(first varchar(10),second varchar(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertData(String s1, String s2)
    {
        SQLiteDatabase sq=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("first",s1);
        cv.put("second",s2);
        long rid=sq.insert("trial",null,cv);
        return rid;
    }
    public String getdata()
    {
        SQLiteDatabase sl= getWritableDatabase();
        String columns[]={"first","second"};
        Cursor cr =sl.rawQuery("select *from trial",null);
        StringBuffer buffer=new StringBuffer();
        while(cr.moveToNext())
        {
            String firstname=cr.getString(0);
            String secondname=cr.getString(1);
            buffer.append(firstname + " "+ secondname+"\n");
        }
        return buffer.toString();
    }
}
