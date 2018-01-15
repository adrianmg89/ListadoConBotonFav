package com.example.admin.listadoconbotonfav;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogInsertar.OyenteDialog,DialogBorrarPersona.AvisarBorrado{
    ListView listado;
    FloatingActionButton anadir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listado = (ListView)findViewById(R.id.lista);
        anadir = (FloatingActionButton)findViewById(R.id.btnAnadir);

        ArrayList<Persona> listaPersona = BaseDeDatos.mostrarContactos(this);
        ListAdapter adaptador = new AdaptadorVistaContacto(listaPersona,getBaseContext(),getFragmentManager());
        listado.setAdapter(adaptador);

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInsertar ins = new DialogInsertar();
                ins.show(getFragmentManager(),"Añadir contacto");
            }
        });
    }

    @Override
    public void insertarPersona(Persona c) {
        BaseDeDatos.insertarContacto(c);

        ArrayList<Persona> listaPersona = BaseDeDatos.mostrarContactos(this);
        ListAdapter adaptador = new AdaptadorVistaContacto(listaPersona,getBaseContext(),getFragmentManager());
        listado.setAdapter(adaptador);

    }

    @Override
    public void borrarContacto(int id) {
        BaseDeDatos.borrarContacto(id);
    }
}
