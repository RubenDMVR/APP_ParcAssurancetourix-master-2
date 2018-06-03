package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Main5ActivityRestau extends AppCompatActivity implements View.OnClickListener
{

    private ImageButton btAC5;
    private ImageButton btMenuLac;
    private ImageButton btMenuMarionnette;
    private ImageButton btMenuPlaza;
    private ImageButton btMenuPolynesie;
    private ImageButton btMenuTaverne;
    private ImageButton btMenuGaulois;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        this.btAC5 = (ImageButton)findViewById(R.id.idAC5);
        this.btMenuLac = (ImageButton) findViewById(R.id.idLac);
        this.btMenuMarionnette = (ImageButton) findViewById(R.id.idMarionnette);
        this.btMenuPlaza = (ImageButton) findViewById(R.id.idPlaza);
        this.btMenuPolynesie = (ImageButton) findViewById(R.id.idPolynesie);
        this.btMenuTaverne = (ImageButton) findViewById(R.id.idTaverne);
        this.btMenuGaulois = (ImageButton) findViewById(R.id.idGaulois);



        this.btAC5.setOnClickListener(this);
        this.btMenuLac.setOnClickListener(this);
        this.btMenuMarionnette.setOnClickListener(this);
        this.btMenuPlaza.setOnClickListener(this);
        this.btMenuPolynesie.setOnClickListener(this);
        this.btMenuTaverne.setOnClickListener(this);
        this.btMenuGaulois.setOnClickListener(this);




    }




    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.idAC5)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main3ActivityAcceuil.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idLac)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuLac.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idMarionnette)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuMarionnette.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idPlaza)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuplaza.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idPolynesie)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuPolynesie.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idTaverne)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuTaverne.class);

            this.startActivity(unIntent);
        }
        if (v.getId() == R.id.idGaulois)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, MainActivityMenuGaulois.class);

            this.startActivity(unIntent);
        }


    }
}

