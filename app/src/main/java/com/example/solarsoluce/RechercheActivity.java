package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RechercheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherchesolar);
        //ELEMENT DE LANCEMENT
        Button accueil = findViewById(R.id.Retour);
        accueil.setOnClickListener(v -> {
            Intent accueilpage = new Intent(RechercheActivity.this,MainActivity.class);
            startActivity(accueilpage);
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
                Intent informations = new Intent(RechercheActivity.this,InfoActivity.class);
                startActivity(informations);
                break;
            case R.id.quitter:
                System.exit(0);
                break;
            case R.id.aide:
                Intent aide = new Intent(RechercheActivity.this,AideActivity.class);
                startActivity(aide);
                break;
            case R.id.accueil:
                Intent accueil = new Intent(RechercheActivity.this,MainActivity.class);
                startActivity(accueil);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
