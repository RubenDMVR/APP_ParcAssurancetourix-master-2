package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Main6ActivityPlan extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton btAC6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        this.btAC6 = (ImageButton) findViewById(R.id.idAC6);

        this.btAC6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
        {
            if (v.getId() == R.id.idAC6)
            {
                //passer à la page suivante
                Intent unIntent = new Intent (this, Main3ActivityAcceuil.class);

                this.startActivity(unIntent);
            }






        }
}
