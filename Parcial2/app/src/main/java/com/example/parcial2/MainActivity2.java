package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener{

    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txtUser;
    String dato;
    RecyclerView rcv_personajes;
    List<Personaje> personajeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtUser = findViewById(R.id.txtUser);
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if (!dato.equals("0"))
            txtUser.setText(dato);
        else
            txtUser.setText("No hay información");

        rcv_personajes = findViewById(R.id.rcv_personajes);

        Personaje per1 = new Personaje("https://okdiario.com/img/2019/04/06/el-futuro-de-octavia-blake-en-the-100.jpg", "Octavia Blake", "The 100");
        Personaje per2 = new Personaje("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqqlLlhCRSeUwpCatv7W_0Fdq2Kgz295n_h9w5SGeY6w&s", "Blair Waldorf", "Gossip Girl");
        Personaje per3 = new Personaje("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKpKe6vHqnnKwBWyd4VE_zQF_q_DLC8VhIlz7NGVhUrQ&s", "Chuck Bass", "Gossip Girl");
        Personaje per4 = new Personaje("https://ew.com/thmb/Td47EZ5kYY2mkuWKzPOMZuPHKW4=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/blindspot_0-1-1469475ac42647bc817d68c16250b264.jpg", "Jane Doe", "Blindspot");
        Personaje per5 = new Personaje("https://www.michael-giso.com/wp-content/uploads/2021/01/Hervey-Specter-Suit.jpg", "Harvey Specter", "Swits");

        personajeList.add(per1);
        personajeList.add(per2);
        personajeList.add(per3);
        personajeList.add(per4);
        personajeList.add(per5);

        rcv_personajes.setLayoutManager(new LinearLayoutManager(this));
        rcv_personajes.setAdapter(new UsuarioAdaptador(personajeList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(personajeList);
        rcv_personajes.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Personaje personaje) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("personaje_nombre", personaje.getNombre());
        i.putExtra("personaje_programa", personaje.getPrograma());
        i.putExtra("personaje_imagen", personaje.getImagen());
        startActivity(i);
        finish();
    }
}