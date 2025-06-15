package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityScore extends AppCompatActivity {

    TextView msg, score;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        msg = findViewById(R.id.msg);
        score = findViewById(R.id.score);

        Intent it = getIntent();
        if (it != null) {
            res = it.getStringExtra("score");
            score.setText("Votre Score est: " + res + "/10");

            // ➕ Ajout du test de score après avoir l'affiché
            if (res != null) {
                try {
                    float floatScore = Float.parseFloat(res);
                    if (floatScore < 5) {
                        Intent i = new Intent(ActivityScore.this, ActivityAttention.class);
                        startActivity(i);
                        finish(); // optionnel : ferme la page actuelle
                    }
                } catch (NumberFormatException e) {
                    // Score mal formaté
                    e.printStackTrace();
                }
            }
        }
    }
}
