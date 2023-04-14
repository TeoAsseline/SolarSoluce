package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> valeursListe;
    public static ListAdaptateur adapterListe;

    SQL s = new SQL(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Panneau p1 = new Panneau(1,"MK1 verticale","Thermique",
                "Le capteur solaire thermique MK1 fabriqué par Heliofrance est certifié Solar Keymark et peut être utilisé pour la production d'eau chaude sanitaire des maisons individuelles",
                2700,0, 6);
        Panneau p2 = new Panneau(2,"DualSun Flash 500Wc","Thermique",
                "Optimisé grâce à des cellules monocristallines à haut rendement et un verre antireflet qui vous garantit des performances optimales",
                2025,0, 4.5);
        Panneau p3 = new Panneau(3,"AE Solar 500Wc monocristallin","Photovoltaïque",
                "Le panneau solaire 500W AE Solar est un module monocristallin le plus puissant du marché photovoltaïque au monde",
                3150,0, 7);
        Panneau p4 = new Panneau(4,"SOLAIRE 270W POLYCRISTALLIN - VICTRON ENERGY","Photovoltaïque",
                "Le panneau solaire polycristallin 270W BlueSolar de Victron Energy est assemblé dans un cadre robuste en aluminium",
                2250,0, 5);
        Panneau p5 = new Panneau(5,"TIGER PRO 545W HALF-CUT SILVER FRAME","Photovoltaïque",
                "Il est doté de 144 cellules avec une structure demi-coupés pour maximiser la quantité de lumière afin d'augmenter la quantité d'énergie produite",
                3375,0, 7.5);
        s.insertPanneau(p1);
        s.insertPanneau(p2);
        s.insertPanneau(p3);
        s.insertPanneau(p4);
        s.insertPanneau(p5);
        setContentView(R.layout.activity_main);
        //ELEMENT DE LANCEMENT
        ListView listepanneau = findViewById(R.id.listepanneau);
        RadioButton typePhoto = findViewById(R.id.type1);
        RadioButton typeThermo = findViewById(R.id.type2);
        valeursListe=new ArrayList<>();

        valeursListe.add("AE Solar 500Wc monocristallin");
        valeursListe.add("SOLAIRE 270W POLYCRISTALLIN - VICTRON ENERGY");
        valeursListe.add("TIGER PRO 545W HALF-CUT SILVER FRAME");
        adapterListe = new ListAdaptateur(this,valeursListe);
        listepanneau.setAdapter(adapterListe);

        typePhoto.setOnClickListener(v -> {
            valeursListe.clear();
            valeursListe.add("AE Solar 500Wc monocristallin");
            valeursListe.add("SOLAIRE 270W POLYCRISTALLIN - VICTRON ENERGY");
            valeursListe.add("TIGER PRO 545W HALF-CUT SILVER FRAME");
            adapterListe = new ListAdaptateur(this,valeursListe);
            listepanneau.setAdapter(adapterListe);
        });
        typeThermo.setOnClickListener(v -> {
            valeursListe.clear();
            valeursListe.add("MK1 verticale");
            valeursListe.add("DualSun Flash 500Wc");
            adapterListe = new ListAdaptateur(this,valeursListe);
            listepanneau.setAdapter(adapterListe);
        });

        Button infosolar = findViewById(R.id.infosolar);

        infosolar.setOnClickListener(v -> {
            Intent info = new Intent(MainActivity.this,InfoActivity.class);
            startActivity(info);
        });

        //Listener ListView
        listepanneau.setOnItemClickListener((adapterView, view, i, l) -> {
            String valeur= (String) adapterView.getItemAtPosition(i);
            Intent recherche = new Intent(MainActivity.this,RechercheActivity.class);
            recherche.putExtra("name",valeur);
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