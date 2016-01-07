package com.example.pierre_henrilibeert.edt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EDTiutlens extends Activity implements AdapterView.OnItemSelectedListener {

    // Déclaration des variables
    private String departement = "";
    private String groupe = "";

    // Déclaration du fichier préférences
    SharedPreferences settings;

    // Déclaration des spinner
    private Spinner mySpinnerDepartements;
    private Spinner mySpinnerGroupes;
    private Button myButtonValdier;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getActionBar().hide();

        setContentView(R.layout.activity_edtiutlens);

        // On récup les préférences de l'utilisateur
        settings = getSharedPreferences("Mes préférences", Context.MODE_PRIVATE);
        departement = settings.getString("dep", "null");
        groupe = settings.getString("group", "null");

        // S'il a déjà des préférences on redirige tout de suite vers l'accueil
        if(departement != "null" && groupe != "nul") {
            Intent intent = new Intent(EDTiutlens.this, Acceuil.class);
            startActivity(intent);
        }

        // On relit les widgets avec le bon élément du layout
        mySpinnerDepartements = (Spinner) findViewById(R.id.spinnerDepartements);
        mySpinnerGroupes = (Spinner) findViewById(R.id.spinnerGroupes);
        myButtonValdier = (Button) findViewById(R.id.boutonValider);

        // On déclare et assigne l'adapter pour le spinner Département
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.departement_array, android.R.layout.simple_spinner_item);
        mySpinnerDepartements.setAdapter(adapter);

        // On ajoute un écouteur de sélection au spinner Département
        mySpinnerDepartements.setOnItemSelectedListener(this);

        // On ajoute un écouteur de click sur le bouton valider
        myButtonValdier.setOnClickListener(myClickListener);

    }

    // Action du Bouton Valider de la page de bienvenue
    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Recup la valeur du département
            departement = String.valueOf(mySpinnerDepartements.getSelectedItem());
            Log.d("Departement ", departement);

            // Recup la valeur du groupe
            groupe = String.valueOf(mySpinnerGroupes.getSelectedItem());
            Log.d("Groupe ", groupe);

            // On enregistre les préférences
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("dep", departement);
            edit.putString("group", groupe);
            edit.apply();

            // On redirige vers la page d'accueil
            Intent intent = new Intent(EDTiutlens.this, Acceuil.class);
            startActivity(intent);
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        // On récup la valeur du spinner Département
        departement = String.valueOf(mySpinnerDepartements.getSelectedItem());

        // On déclare un adapter pour le spinner Groupe
        ArrayAdapter adapter_groupe;

        // En fonction du département choisi, on actualise le spinner Groupe avec les bonnes données
        switch (departement){
            case "GEA":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_GEA_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "GEA-APP":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_GEA_APP_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "INFO":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_INFO_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "MMI":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_MMI_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "TC":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_TC_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "APPR":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_APPR_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            case "LA":
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_LA_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
            default:
                adapter_groupe = ArrayAdapter.createFromResource(this, R.array.groupe_GEA_array, android.R.layout.simple_spinner_item);
                mySpinnerGroupes.setAdapter(adapter_groupe);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
