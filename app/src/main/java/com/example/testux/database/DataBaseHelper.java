package com.example.testux.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class DataBaseHelper extends SQLiteOpenHelper {
    private final int dataBaseVersion;
    private final String dataBaseName;

    public DataBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, null, dataBaseVersion);

        this.dataBaseName = dataBaseName;
        this.dataBaseVersion = dataBaseVersion;
    }

    protected abstract String getCreationSql();
    protected abstract String getDeleteSql();

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreationSql());
//        db.execSQL(getDeleteSql());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(getDeleteSql());
        onCreate(db);
    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean insertData (String gamemode, String name, int score)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Gamemode", gamemode);
        contentValues.put("Score", score);

        long result = db.insert("Leaderboard", null, contentValues);

        return result != -1; // Si result = -1 , la donnée n'est pas envoyée
    }

    public Cursor viewData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Leaderboard ORDER BY Score DESC";

        return db.rawQuery(query, null);
    }
}