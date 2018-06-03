package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityMenuTaverne extends AppCompatActivity implements View.OnClickListener
{

    private Button btRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_taverne);

        this.btRetour = (Button) findViewById(R.id.idRetour8);
        this.btRetour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.idRetour8)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main5ActivityRestau.class);

            this.startActivity(unIntent);
        }

    }
}