package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView num_outpout,quest_outpout;
    Button ch1,ch2,ch3,suivant;

    List<Question> liste=new ArrayList<>();
    int indice=0;
    float score=0.0f;

    @SuppressLint("Missing")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num_outpout=findViewById(R.id.number_qst_outpout);
        quest_outpout=findViewById(R.id.quest_outpout);
        ch1=findViewById(R.id.ch1);
        ch2=findViewById(R.id.ch2);
        ch3=findViewById(R.id.ch3);
        suivant=findViewById(R.id.suivant);
        remplirList();
        chargerQuestion();
        chargernumberQuest();

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(indice,1);
                if (indice < (liste.size() - 1)) {
                    indice++;
                    chargerQuestion();
                    chargernumberQuest();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"fin de test SCORE"+score,Toast.LENGTH_LONG).show();
                    Intent it;
                    if (score < 5) {
                        it = new Intent(MainActivity.this, ActivityAttention.class);
                    } else {
                        it = new Intent(MainActivity.this, ActivityScore.class);
                    }
                    it.putExtra("score", "" + score); // ✅ clé correcte
                    startActivity(it);

                }
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(indice,2);
                if (indice < (liste.size() - 1)) {
                    indice++;
                    chargerQuestion();
                    chargernumberQuest();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"fin de test SCORE"+score,Toast.LENGTH_LONG).show();
                    Intent it;
                    if (score < 5) {
                        it = new Intent(MainActivity.this, ActivityAttention.class);
                    } else {
                        it = new Intent(MainActivity.this, ActivityScore.class);
                    }
                    it.putExtra("score", "" + score); // ✅ clé correcte
                    startActivity(it);

                }
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(indice,3);
                if (indice < (liste.size() - 1)) {
                    indice++;
                    chargerQuestion();
                    chargernumberQuest();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"fin de test SCORE"+score,Toast.LENGTH_LONG).show();
                    Intent it;
                    if (score < 5) {
                        it = new Intent(MainActivity.this, ActivityAttention.class);
                    } else {
                        it = new Intent(MainActivity.this, ActivityScore.class);
                    }
                    it.putExtra("score", "" + score); // ✅ clé correcte
                    startActivity(it);

                }
            }
        });


        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(indice,-1);
                if (indice < (liste.size() - 1)) {
                    indice++;
                    chargerQuestion();
                    chargernumberQuest();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"fin de test SCORE"+score,Toast.LENGTH_LONG).show();
                    Intent it;
                    if (score < 5) {
                        it = new Intent(MainActivity.this, ActivityAttention.class);
                    } else {
                        it = new Intent(MainActivity.this, ActivityScore.class);
                    }
                    it.putExtra("score", "" + score); // ✅ clé correcte
                    startActivity(it);

                }

            }

        });





    }

    void remplirList() {
        liste.add(new Question(
                "Quel langage est principalement utilisé pour le développement côté serveur Web ?",
                "PHP", "HTML", "CSS", 1));

        liste.add(new Question(
                "Quel système d'exploitation est utilisé principalement pour les smartphones ?",
                "Linux", "Android", "iOS", 2));

        liste.add(new Question(
                "Que signifie BDD dans le contexte informatique ?",
                "Base de Données", "Bonne Définition", "Boîte de Dialogue", 1));

        liste.add(new Question(
                "Quel langage est utilisé pour structurer une page Web ?",
                "CSS", "HTML", "JavaScript", 2));

        liste.add(new Question(
                "Quel langage permet d’ajouter des interactions sur une page Web ?",
                "JavaScript", "SQL", "XML", 1));
    }

    void chargerQuestion(){
    if (liste.size()>0){
        quest_outpout.setText(liste.get(indice).getQues());
        ch1.setText(liste.get(indice).getChoix1());
        ch2.setText(liste.get(indice).getChoix2());
        ch3.setText(liste.get(indice).getChoix3());

    }
    }

    void chargernumberQuest(){
        num_outpout.setText("Question "+(indice+1)+"/"+liste.size());
    }

    void verifierReponse(int ind,int choixuser){
        Question q=liste.get(ind);
        if(q!=null)
        if (q.getReponse()==choixuser){
            score=score+2;
        }


    }
}