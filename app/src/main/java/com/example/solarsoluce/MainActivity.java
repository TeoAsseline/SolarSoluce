package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> valeursListe;
    public static ListAdaptateur adapterListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ELEMENT DE LANCEMENT
        ListView listepanneau = findViewById(R.id.listepanneau);
        valeursListe=new ArrayList<>();
        valeursListe.add("TEST");
        adapterListe = new ListAdaptateur(this,valeursListe);
        listepanneau.setAdapter(adapterListe);
        Button infosolar = findViewById(R.id.infosolar);

        infosolar.setOnClickListener(v -> {
            Intent info = new Intent(MainActivity.this,InfoActivity.class);
            startActivity(info);
        });

        //Listener ListView
        listepanneau.setOnItemClickListener((adapterView, view, i, l) -> {
            String valeur= (String) adapterView.getItemAtPosition(i);
            Intent recherche = new Intent(MainActivity.this,RechercheActivity.class);
            startActivity(recherche);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menusolar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        //récupère id du bouton du menu
        switch (item.getItemId()){
            case R.id.infomenu:
                Intent informations = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(informations);
                break;
            case R.id.quitter:
                System.exit(0);
                break;
            case R.id.aide:
                Intent aide = new Intent(MainActivity.this,AideActivity.class);
                startActivity(aide);
                break;
            case R.id.accueil:
                Intent accueil = new Intent(MainActivity.this,MainActivity.class);
                startActivity(accueil);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}