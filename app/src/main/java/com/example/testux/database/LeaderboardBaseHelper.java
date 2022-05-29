package com.example.testux.database;

import android.content.Context;

public class LeaderboardBaseHelper extends DataBaseHelper {


    public LeaderboardBaseHelper(Context context) {
        super(context, "Leaderboard", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS Leaderboard ("+
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Gamemode" + " VARCHAR(255) NOT NULL," +
                "Name" + " VARCHAR(255) NOT NULL," +
                "Score" + " INTEGER NOT NULL " +
                ")";
    }

    @Override
    public String getDeleteSql() {
        return "DROP TABLE Leaderboard";
    }
}
