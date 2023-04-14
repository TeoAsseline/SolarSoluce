package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class StatActivity extends AppCompatActivity{

    Panneau panneau = new Panneau();
    SQL s = new SQL(StatActivity.this);
    Random random = new Random();
    double ensoleillement;
    double productionDouble;
    String production;
    String productionMoyenne;
    String productionMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsolar);
        panneau= s.getOnePanneauByName(getIntent().getStringExtra("name"));
        ensoleillement = 300+random.nextInt(300);
        productionDouble = ensoleillement*panneau.getRendement();
        if(productionDouble>panneau.getProdmax()){
            panneau.setProdmax(productionDouble);
            s.updatePanneau(panneau);
        }

        TextView prod = findViewById(R.id.afficheprodcoord);
        TextView prodMoyenne = findViewById(R.id.afficheprodmoy);
        TextView prodMax = findViewById(R.id.afficheprodmax);

        production = ""+productionDouble;
        productionMoyenne= ""+panneau.getProdmoy();
        productionMax= ""+panneau.getProdmax();

        prod.setText(production+" kWh");
        prodMoyenne.setText(productionMoyenne+" kWh");
        prodMax.setText(productionMax+" kWh");
        //ELEMENT DE LANCEMENT
        Button recherche = findViewById(R.id.retour);
        recherche.setOnClickListener(v -> {
            Intent recherchepage = new Intent(StatActivity.this,RechercheActivity.class);
            startActivity(recherchepage);
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
                Intent informations = new Intent(StatActivity.this,InfoActivity.class);
                startActivity(informations);
                break;
            case R.id.quitter:
                System.exit(0);
                break;
            case R.id.aide:
                Intent aide = new Intent(StatActivity.this,AideActivity.class);
                startActivity(aide);
                break;
            case R.id.accueil:
                Intent accueil = new Intent(StatActivity.this,MainActivity.class);
                startActivity(accueil);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
