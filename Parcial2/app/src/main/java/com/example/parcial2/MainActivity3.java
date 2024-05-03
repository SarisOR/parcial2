package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity {

    Button btnCerrar;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txtNombre, txtPrograma;
    ImageView img_personaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnCerrar = findViewById(R.id.btnCerrar);
        txtNombre = findViewById(R.id.txtNombre);
        txtPrograma = findViewById(R.id.txtPrograma);
        img_personaje = findViewById(R.id.img_personaje);
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("personaje_nombre");
            String programa = intent.getStringExtra("personaje_programa");
            String imagen = intent.getStringExtra("personaje_imagen");
            txtNombre.setText(nombre);
            txtPrograma.setText(programa);
            Picasso.get().load(imagen).into(img_personaje);
            btnCerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences configuration = getApplicationContext().getSharedPreferences(dataUser, modoPrivate);
                    configuration.edit().clear().commit();
                    Intent i = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}