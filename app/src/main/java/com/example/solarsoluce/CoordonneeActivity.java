package com.example.solarsoluce;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CoordonneeActivity  extends Activity {
    EditText coordonneeX2;
    EditText coordonneeY2;
    Button coordValide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordonnee);
        coordonneeX2 = findViewById(R.id.coordonneeX2);
        coordonneeY2 = findViewById(R.id.coordonneeY2);
        coordValide = findViewById(R.id.coordValide);
        coordValide.setOnClickListener(arg0 -> {
            String latitude= coordonneeX2.getText().toString();
            String longitude= coordonneeY2.getText().toString();
            boolean b = true;
            try {
                Float f = Float.parseFloat(latitude);
                Float f1 = Float.parseFloat(longitude);
            } catch (NumberFormatException e) {
                b = false;
            }
            if(b == true) {
                float i = Float.parseFloat(latitude);
                float i2 = Float.parseFloat(longitude);
                if (-90 <= i && 90 >= i && -90 <= i2 && 90 >= i2 ) {
                    String message = coordonneeX2.getText().toString() + "," + coordonneeY2.getText().toString();
                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", message);
                    setResult(2, intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Votre latitude ou votre longitude ne respecte pas le Système géodésique WGS 84 (valeur comprise entre -90 et 90 inclus", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Votre latitude ou votre longitude ne correspondent pas à des décimaux ", Toast.LENGTH_LONG).show();
            }
        });
    }
}
