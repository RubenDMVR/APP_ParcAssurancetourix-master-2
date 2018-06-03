package com.applixmobilix.parcassurancetourix.application_parcassurancetourix;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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

public class Main7ActivityConnexion extends AppCompatActivity implements View.OnClickListener
{
    private static User leUser ;
    private Button btSeConnecter ;
    private ImageButton btAC7;

    private EditText txtEmail, txtMdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7_connexion);


        this.btSeConnecter = (Button) findViewById(R.id.idConnecter);
        this.btAC7 = (ImageButton) findViewById(R.id.idAC7);



        this.btSeConnecter.setOnClickListener(this);
        this.btAC7.setOnClickListener(this);


        this.txtEmail = (EditText) findViewById(R.id.idEmail);
        this.txtMdp = (EditText) findViewById(R.id.idMdp);


    }


    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.idAC7)
        {
            //passer à la page suivante
            Intent unIntent = new Intent (this, Main3ActivityAcceuil.class);

            this.startActivity(unIntent);
        }


        if (v.getId() == R.id.idConnecter)
        {
// Vérification de la connexion via l'API PHP
            String email = this.txtEmail.getText().toString();
            String mdp = this.txtMdp.getText().toString();

            final User unUser = new User(email, mdp,  "");

            final Main7ActivityConnexion ma = this;

            // Execution de la tâche Asynchrone
            Thread unT = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    // Instanciation de la tâche Asynchrone
                    VerifConnexion uneConnexion = new VerifConnexion();
                    uneConnexion.execute(unUser);

                    // Test de la vérification de la connexion
                    // On utilise une synchronisation du Thread P.F avec le P.P
                    //  ajouter un retard d'attente
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException exp){
                        Log.e("erreur", "attente");
                    }
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            if(leUser == null)
                            {
                                Toast.makeText(ma, "Vérifier vos identifiants", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                               /* Toast.makeText(ma, "Bienvenue " + leUser.getNom(), Toast.LENGTH_LONG).show();*/
                                Intent unIntent = new Intent(ma, Index.class);
                                unIntent.putExtra("email", leUser.getEmail());
                                startActivity(unIntent);
                            }
                        }
                    });
                }
            });

            // Lancement du processus fils
            unT.start();
        }
    }


    public static User getLeUser() {
        return leUser;
    }

    public static void setLeUser(User leUser) {
        Main7ActivityConnexion.leUser = leUser;
    }




}


/***** Classe Asynchrone Task *****/

class VerifConnexion extends AsyncTask<User, Void, User>
{

    @Override
    protected User doInBackground(User... users)
    {
        String url = "http://192.168.43.248:8888/android/verifconnexion.php";
        String resultat = null;
        User unUser = users[0];
        User userConnecte = null;

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

            Log.e("connexion", "reussie");
            // Envoi des paramètres
            String  parametres = "email=" + unUser.getEmail();
            parametres += "&mdp=" + unUser.getMdp();

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
            exp.printStackTrace();
        }

        // Parsing en Json
        if(resultat != null)
        {
            try
            {
                JSONArray tabJson = new JSONArray(resultat);
                JSONObject unObjet = tabJson.getJSONObject(0);
                int nb = unObjet.getInt("nb");
                if(nb >= 1)
                {

                    userConnecte = new User(
                            unUser.getId_personne(),
                            unUser.getEmail(),
                            unUser.getMdp(),
                            unUser.getDroits()
                    );

                   /* userConnecte = new User(
                            unUser.getEmail(),
                            unUser.getMdp(),
                            unObjet.getString("nom"),
                            unObjet.getString("prenom")
                    );*/
                }
            }
            catch(JSONException exp)
            {
                Log.e("Erreur : ", "Impossible de parser : " + resultat);
            }
        }

        return userConnecte;
    }

    @Override
    protected void onPostExecute(User user)
    {
        Main7ActivityConnexion.setLeUser(user);
    }
}