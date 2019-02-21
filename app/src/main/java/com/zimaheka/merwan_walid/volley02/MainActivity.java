package com.zimaheka.merwan_walid.volley02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void recherche (View view) {

        final TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        String id = editText.getText().toString().trim();
        String url = "http://zemahek.000webhostapp.com/recherche_mobile.php?id=" + id;

        Response.Listener<Administrateur> administrateurListener = new Response.Listener<Administrateur>(){

            @Override
            public void onResponse( Administrateur response ){

                textView.setText(response.nom +" "+response.prenom );
                Toast.makeText(getApplicationContext() , response.email , Toast.LENGTH_LONG).show();
            }

        } ;

            Requete requete = new Requete<>(url , Administrateur.class ,administrateurListener , null) ;
            RequestQueue requestQueue =  Volley.newRequestQueue(this) ;
            requestQueue.add(requete) ;
    }

    }
