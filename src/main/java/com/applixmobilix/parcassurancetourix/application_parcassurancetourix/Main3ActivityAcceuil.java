package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Main3ActivityAcceuil extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btAttraction;
    private ImageButton btRestaurant;
    private ImageButton btPlan;
    private ImageButton btConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.btAttraction = (ImageButton)findViewById(R.id.idAttraction);
        this.btRestaurant = (ImageButton)findViewById(R.id.idRestaurant);
        this.btPlan = (ImageButton)findViewById(R.id.idPlan);
        this.btConnexion = (ImageButton)findViewById(R.id.idConnexion);

        this.btAttraction.setOnClickListener(this);
        this.btRestaurant.setOnClickListener(this);
        this.btPlan.setOnClickListener(this);
        this.btConnexion.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idAttraction)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main4ActivityAttraction.class);

            this.startActivity(unIntent);
        }
        else if (v.getId() == R.id.idRestaurant)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main5ActivityRestau.class);

            this.startActivity(unIntent);
        }
        else if (v.getId() == R.id.idPlan)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main6ActivityPlan.class);

            this.startActivity(unIntent);
        }
        else if (v.getId() == R.id.idConnexion)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main7ActivityConnexion.class);

            this.startActivity(unIntent);
        }


    }
}
