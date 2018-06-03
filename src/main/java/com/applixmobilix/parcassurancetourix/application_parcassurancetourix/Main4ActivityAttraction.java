package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Main4ActivityAttraction extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btAttracForte;
    private ImageButton btAttracFamille;
    private ImageButton btAttracPetits;
    private ImageButton btAC1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        this.btAttracForte = (ImageButton)findViewById(R.id.idAForte);
        this.btAttracFamille = (ImageButton)findViewById(R.id.idAFamille);
        this.btAttracPetits = (ImageButton)findViewById(R.id.idAPetits);
        this.btAC1 = (ImageButton)findViewById(R.id.idAC1);



        this.btAttracForte.setOnClickListener(this);
        this.btAttracFamille.setOnClickListener(this);
        this.btAttracPetits.setOnClickListener(this);
        this.btAC1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idAForte)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main8ActivityForte.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idAFamille)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main9ActivityFamille.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idAPetits)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main10ActivityPetit.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idAC1)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main3ActivityAcceuil.class);

            this.startActivity(unIntent);
        }


    }
}
