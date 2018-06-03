package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MesParcours extends AppCompatActivity implements View.OnClickListener
{
    private ListView lvListe;
    private Button btRetour;
    private String email;

    private static ArrayList<Parcours> mesParcours = null;

    public static ArrayList<Parcours> getMesParcours()
    {
        return mesParcours;
    }

    public static void setMesParcours(ArrayList<Parcours> mesParcours)
    {
        MesParcours.mesParcours = mesParcours;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_parcours);

        this.email = this.getIntent().getStringExtra("email");
        this.lvListe = (ListView) findViewById(R.id.id_liste);
        this.btRetour = (Button) findViewById(R.id.id_retour);

        this.btRetour.setOnClickListener(this);
        final MesParcours me = this;


        // Création d'un processus fils pour récupérer les parcours
        Thread unT = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                GetParcours uneExec = new GetParcours();
                uneExec.execute(email);

                // Affichage des résultats dans la ListView
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ArrayList<String> laListe = new ArrayList<String>();
                        if(mesParcours != null)
                        {
                            for (Parcours unParcours : mesParcours)
                            {
                                laListe.add(unParcours.toString());
                            }

                            ArrayAdapter unAdapter = new ArrayAdapter(me, android.R.layout.simple_list_item_1, laListe);
                            lvListe.setAdapter(unAdapter);
                        }
                    }
                });
            }
        });

        unT.start();
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.id_retour)
        {
            Intent unIntent = new Intent(this, Index.class);
            this.startActivity(unIntent);
        }
    }
}


/***** Classe Asynchrone *****/

class GetParcours extends AsyncTask<String, Void, ArrayList<Parcours>>
{

    @Override
    protected ArrayList<Parcours> doInBackground(String... emails)
    {
        String url = "http://192.168.43.248:8888/android/mesParcours.php";
        String resultat = null;
        String email = emails[0];
        ArrayList<Parcours> lesParcours = new ArrayList<Parcours>();

        try
        {
            URL uneUrl = new URL(url);
            HttpURLConnection uneUrlConnection = (HttpURLConnection)uneUrl.openConnection();

            // On fixe la méthode Get
            uneUrlConnection.setRequestMethod("GET");

            // On ouvre l'envoi et la réception des données
            uneUrlConnection.setDoInput(true);
            uneUrlConnection.setDoOutput(true);

            // On fixe les temps de connexion et d'attente
            uneUrlConnection.setReadTimeout(10000);
            uneUrlConnection.setConnectTimeout(15000);

            // On se connecte
            uneUrlConnection.connect();


            // Envoi des paramètres
            String  parametres = "email=" + email;

            // Ecriture des paramètres dans un fichier de sortie
            OutputStream fichier = uneUrlConnection.getOutputStream();
            BufferedWriter unBuffer = new BufferedWriter(new OutputStreamWriter(fichier, "UTF-8"));

            // Ecriture des paramètres
            unBuffer.write(parametres);

            // On vide le buffer
            unBuffer.flush();
            unBuffer.close();
            fichier.close();

            // Lecture de la chaine Json a partir du fichier de lecture
            InputStream fichier2 = uneUrlConnection.getInputStream();
            BufferedReader unBuffer2 = new BufferedReader(new InputStreamReader(fichier2, "UTF-8"));

            // On défini une chaine dynamique qui lit les chaines Json du fichier
            StringBuilder sb = new StringBuilder();
            String ligne = null;
            while ((ligne = unBuffer2.readLine()) != null)
            {
                sb.append(ligne);
            }
            unBuffer2.close();
            fichier2.close();
            resultat = sb.toString();
            Log.e("Resultat : ", resultat);

        }
        catch(IOException exp)
        {
            Log.e("Erreur : ", "Connexion impossible à " + url);
        }

        // Parsing en Json
        if(resultat != null)
        {
            try
            {
                JSONArray tabJson = new JSONArray(resultat);
                for(int i = 0; i< tabJson.length(); i++)
                {
                    JSONObject unObjet = tabJson.getJSONObject(i);

                    Parcours unParcours = new Parcours(
                            unObjet.getString("libelle"),
                            unObjet.getString("duree"),
                            unObjet.getString("nom_attraction"),
                            unObjet.getString("nom_retaurant")

                            );

                    lesParcours.add(unParcours);
                }
            }
            catch(JSONException exp)
            {
                Log.e("Erreur : ", "Impossible de parser : " + resultat);
            }
        }

        return lesParcours;
    }

    @Override
    protected void onPostExecute(ArrayList<Parcours> parcours)
    {
        MesParcours.setMesParcours(parcours);
    }
}
