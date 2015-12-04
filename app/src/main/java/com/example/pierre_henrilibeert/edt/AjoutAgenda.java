package com.example.pierre_henrilibeert.edt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AjoutAgenda extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_agenda);
    }

    public void onClick (View view) {
        // Action du Bouton Valider de la page de bienvenue
        //mene a la page acceuil
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

}
