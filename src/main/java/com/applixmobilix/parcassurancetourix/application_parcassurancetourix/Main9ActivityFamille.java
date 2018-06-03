package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main9ActivityFamille extends AppCompatActivity implements View.OnClickListener
{
    private Button btRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9_famille);

        this.btRetour = (Button) findViewById(R.id.idRetour2);
        this.btRetour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.idRetour2)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main4ActivityAttraction.class);

            this.startActivity(unIntent);
        }

    }
}
