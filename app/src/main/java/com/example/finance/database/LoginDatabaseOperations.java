package com.example.finance.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LoginDatabaseOperations {
    private Connection connection = null;
    private String username;
    private String password;

    public LoginDatabaseOperations(Connection connection, String username, String password) {
        this.connection = connection;
        this.username = username;
        this.password = password;
    }

    public LoginDatabaseOperations(Connection connection) {
        this.connection = connection;
    }

    public LoginDatabaseOperations() {
    }

    public boolean addUser(){
        SQLiteDatabase sqLiteDatabase = connection.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Connection.COLUMN_USERNAME, "Admin");
        contentValues.put(Connection.COLUMN_PASSWORD, "Admin");

        long success = sqLiteDatabase.insert(Connection.TABLE_USERS, null, contentValues);

        if(success!=-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean fetchUser(){
        SQLiteDatabase sqLiteDatabase = connection.getReadableDatabase();
        String sql = "SELECT * FROM " + Connection.TABLE_USERS + " WHERE " + Connection.COLUMN_USERNAME + " = '" + username + "' AND " + Connection.COLUMN_PASSWORD + " = '" + password + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        connection.close();
        if(cursor!=null){
            return true;
        }
        else{
            return false;
        }

    }
}
