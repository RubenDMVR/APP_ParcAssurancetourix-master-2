package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main8ActivityForte extends AppCompatActivity implements View.OnClickListener
{
    private Button btRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8_af);

        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.btRetour.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.idRetour)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main4ActivityAttraction.class);

            this.startActivity(unIntent);
        }

    }
}
