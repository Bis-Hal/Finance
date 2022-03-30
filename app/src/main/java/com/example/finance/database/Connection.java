package com.example.finance.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_U_ID = "U_ID";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    private Context context;

    public Connection(@Nullable Context context) {
        super(context, "Finance.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
        System.out.println("Failed");
        UserCreate();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void UserCreate(){
        LoginDatabaseOperations loginDatabaseOperations = new LoginDatabaseOperations(this);
        if(loginDatabaseOperations.addUser()){
            Toast.makeText(context, "Created", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
