package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Index extends AppCompatActivity implements View.OnClickListener
{
    private Button btRetour, btMesParcours;
    private String email;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        this.btRetour = (Button) findViewById(R.id.id_retour_index);
        this.btMesParcours = (Button) findViewById(R.id.id_mes_parcours);

        this.btRetour.setOnClickListener(this);
        this.btMesParcours.setOnClickListener(this);

        email = this.getIntent().getStringExtra("email");

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.id_retour_index :
            {
                Intent unIntent = new Intent(this, Main7ActivityConnexion.class);
                startActivity(unIntent);
            }
            break;


            case R.id.id_mes_parcours :
            {
                Intent unIntent = new Intent(this, MesParcours.class);
                unIntent.putExtra("email", email);
                startActivity(unIntent);
            }
            break;
        }
    }
}
