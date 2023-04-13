package com.example.solarsoluce;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RechercheActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.startAcivityForResult(),
            new ActivityResultCallback<ActivityResult>{
                @Override
                public void onActivityResult(activityResult result) {

        }
    }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherchesolar);
        //ELEMENT DE LANCEMENT
        Button accueil = findViewById(R.id.Retour);
        accueil.setOnClickListener(v -> {
            Intent accueilpage = new Intent(RechercheActivity.this, MainActivity.class);
            startActivity(accueilpage);
        });


        ImageButton coordonnee = findViewById(R.id.envoyercoor);
        coordonnee.setOnClickListener(v -> {
            Intent intent = new Intent(RechercheActivity.this, CoordonneeActivity.class);
            activityLauncher.launch

        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        TextView rechercheRetour = findViewById(R.id.rechercheRetour);
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            rechercheRetour.setText(message);
        }
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
