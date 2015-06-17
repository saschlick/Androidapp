package com.example.sascha.zinzeszins;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    Button berechnen;
    Button chart;
    public EditText kapital;
    public EditText laufzeit;
    public EditText zinssatz;
    double kapitalwert=0;
    double laufzeitwert=0;
    double zinssatzwert=0;
    double ergebnis=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        berechnen=(Button)findViewById(R.id.button);


        chart=(Button)findViewById(R.id.button2);


        kapital = (EditText) findViewById(R.id.kapital);
        laufzeit = (EditText) findViewById(R.id.laufzeit);
        zinssatz = (EditText) findViewById(R.id.zinssatz);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickChart(View view){
        Graph line = new Graph();
        Intent lineIntent = line.getIntent(this);
        startActivity(lineIntent);


    }

    public void onClickBerechnung(View view) {
        //TODO : Chart Anzeige verschönern
        //TODO : Zahlen von Eingabe auf neue Seite übergeben
        //TODO : Einlesen der Werte in neue Funktion gliedern
            AlertDialog alert= new AlertDialog.Builder(this).create();
            zinssatzwert = Double.parseDouble(zinssatz.getText().toString());
            laufzeitwert = Double.parseDouble(laufzeit.getText().toString());
            kapitalwert = Double.parseDouble(kapital.getText().toString());

            ergebnis=kapitalwert * (Math.pow((1+zinssatzwert/100),laufzeitwert ));
            ergebnis = Math.round(100.0 * ergebnis) / 100.0;
            alert.setMessage("Ihr Endkapital sind " +ergebnis + " Euro");
            alert.show();
        }
}
