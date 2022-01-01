package com.cedric.aftermathproj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Accounts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(email Text primary key, fname Text, lname Text, username Text, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");
    }

    // Data Insertion method.
    public Boolean insertData(String email, String fname, String lname, String username, String password) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDatabase.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Check if username already exist method.
    public Boolean checkUsername(String username) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Check
    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor viewData(String userSession) {
        SQLiteDatabase myDatabase = this.getReadableDatabase();
        Cursor cursor = myDatabase.rawQuery("select * from users where username='" + userSession + "'", null);
        return cursor;
    }
}
