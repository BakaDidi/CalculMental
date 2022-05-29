package com.example.testux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeJeuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modejeu);
        Button buttonclassic = findViewById(R.id.button_classic);
        buttonclassic.setOnClickListener((view -> openActivityClassic()));

        Button buttontraining = findViewById(R.id.button_training);
        buttontraining.setOnClickListener((view -> openActivityEntrainement()));


    }
    private void openActivityClassic() {
        Intent intent = new Intent(this, ClassiqueActivity.class);
        startActivity(intent);
    }
    private void openActivityEntrainement() {
        Intent intent = new Intent(this, EntrainementActivity.class);
        startActivity(intent);
    }


}