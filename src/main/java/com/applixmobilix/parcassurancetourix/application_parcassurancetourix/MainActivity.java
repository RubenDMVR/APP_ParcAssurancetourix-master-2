package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btEntrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btEntrer = (Button)findViewById(R.id.idEntrer);
        this.btEntrer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idEntrer)
        {

            //passer à la page suivante
            Intent unIntent = new Intent (this, Main3ActivityAcceuil.class);

            this.startActivity(unIntent);


        }

    }
}
