package com.example.pierre_henrilibeert.edt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class agenda extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, AjoutAgenda.class);
        startActivity(intent);
    }
}
