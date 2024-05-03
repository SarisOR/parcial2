package com.example.parcial2;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtContraseña;
    Button btnIniciar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    String dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnIniciar = findViewById(R.id.btnIniciar);

        sharedPreferences = getSharedPreferences(dataUser, modoPrivate);
        editor = sharedPreferences.edit();
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if(!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
            finish();
        }
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString();
                String contraseña = edtContraseña.getText().toString();
                if (usuario.equals("") || contraseña.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor llenar los campos ", Toast.LENGTH_SHORT).show();
                else {
                    editor.putString("user", usuario);
                    editor.commit();
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();}
            }
        });
    }
}