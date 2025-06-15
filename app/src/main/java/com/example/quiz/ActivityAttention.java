package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAttention extends AppCompatActivity {

    TextView attention, score1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        attention = findViewById(R.id.attention);
        score1 = findViewById(R.id.score1); // 🔧 Correct ici : score1 et non attention

        Intent it = getIntent();
        if (it != null) {
            String res = it.getStringExtra("score");
            if (res != null) {
                score1.setText("Votre score : " + res + "/10");
            }
        }
    }
}
