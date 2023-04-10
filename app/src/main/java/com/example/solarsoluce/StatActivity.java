package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class StatActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsolar);
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
