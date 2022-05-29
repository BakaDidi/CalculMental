package com.example.testux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testux.MainActivity;
import com.example.testux.R;
import com.example.testux.database.LeaderboardBaseHelper;

import java.util.ArrayList;

public class ViewLeaderboardActivity extends AppCompatActivity {

    LeaderboardBaseHelper db;

    ListView userList;

    ArrayList<String> scores;
    ArrayAdapter<String> adapter;

    LinearLayout register_Layout;

    Button add_data;
    EditText add_name;
    TextView add_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scores = new ArrayList<>();

        db = new LeaderboardBaseHelper(this);

        userList = findViewById(R.id.userList);

        add_data = (Button) findViewById(R.id.button_addData);
        add_name = (EditText) findViewById(R.id.editText_addName);
        add_score = (TextView) findViewById(R.id.textView_addScore);

        register_Layout = (LinearLayout) findViewById(R.id.register_Layout);
        register_Layout.setVisibility(View.VISIBLE);
        String score = getIntent().getStringExtra("Score");
        String gamemode = getIntent().getStringExtra("Gamemode");
        viewData();
    }

    private void returnToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void viewData() {
        register_Layout.setVisibility(View.GONE);
        Cursor cursor = db.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, getString(R.string.nodata), Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                scores.add(cursor.getString(1) + " : " + cursor.getString(2) + " - " + cursor.getString(3) + " " +getString(R.string.points));
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scores);
            userList.setAdapter(adapter);
        }
    }

}