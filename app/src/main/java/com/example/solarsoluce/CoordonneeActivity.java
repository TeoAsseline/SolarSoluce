package com.example.solarsoluce;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
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
            String message= coordonneeX2.getText().toString()+","+coordonneeY2.getText().toString();
            Intent intent=new Intent();
            intent.putExtra("MESSAGE",message);
            setResult(2,intent);
            finish();//finishing activity
        });
    }
}
