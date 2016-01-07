package com.example.pierre_henrilibeert.edt;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.View;

public class menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, Acceuil.class);
        startActivity(intent);
    }
    public void onClick2(View view) {
        Intent intent = new Intent(this, agenda.class);
        startActivity(intent);
    }
    public void onClick3(View view) {
        Intent intent = new Intent(this, AjoutAgenda.class);
        startActivity(intent);
    }
}
