package com.example.solarsoluce;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class CoordonneeActivity  extends Activity {
    EditText coordonneeX2;
    Button coordValide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordonnee);
        coordonneeX2 =(EditText)findViewById(R.id.coordonneeX2);
        coordValide =(Button)findViewById(R.id.coordValide);
        coordValide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String message= coordonneeX2.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();//finishing activity
            }
        });
    }
}
