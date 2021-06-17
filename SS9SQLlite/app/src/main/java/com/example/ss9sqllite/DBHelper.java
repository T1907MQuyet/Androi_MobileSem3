package com.example.ss9sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "User.db";
    public static final String TABLE_NAME = "TBL_USER";
    public static final int DB_VERSION = 1;

    public static  String ID = "id";
    public static String NAME = "name";
    public static String GENDER = "gender";
    public static String DES ="des";

    public DBHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_NAME+"("+
                ID+" INTEGER PRIMARY KEY, "+
                NAME+" TEXT, "+
                GENDER+ " TEXT, "+
                DES+ " TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public String insertDB(String user,String gender, String des)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, user);
        cv.put(GENDER, gender);
        cv.put(DES,des);
        long isSuccess = db.insert(TABLE_NAME,null,cv);
       if (isSuccess == -1 )
       {
           return "Add Fail";
       }
       db.close();
       return "Add success";
    }

    public Cursor getAllUser()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME;
        Cursor c = db.rawQuery(sql,null);
        return c;
    }

    public String updateUser(int id, String user, String gender, String des)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME,user);
        cv.put(GENDER,gender);
        cv.put(DES,des);
        long isSuccess = db.update(TABLE_NAME,cv,ID+ " = ?",new String[]{id+""});
        if (isSuccess>0)
        {
            return "Update Success";
        }
        else
        {
            db.close();
            return "Update fail";
        }
    }

    public String deleteUser(int user_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long isSuccess = db.delete(TABLE_NAME,"id="+user_id,null);
        if (isSuccess>0)
        {
            return "Update Success";
        }
        else
        {
            return "Update fail";
        }
    }

}
