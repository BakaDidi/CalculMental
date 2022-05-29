package com.example.testux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonpartie = findViewById(R.id.button_partie);
        buttonpartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityModeJeu();
            }
        });
        Button button_scoreboard = findViewById(R.id.button_scoreboard);
        button_scoreboard.setOnClickListener((view -> OpenViewLeaderboardActivity()));
    }

    private void OpenViewLeaderboardActivity(){
        Intent intent = new Intent(this, ViewLeaderboardActivity.class);
        startActivity(intent);
    }

    private void openActivityModeJeu() {
        Intent intent = new Intent(this, ModeJeuActivity.class);
        startActivity(intent);
    }
}