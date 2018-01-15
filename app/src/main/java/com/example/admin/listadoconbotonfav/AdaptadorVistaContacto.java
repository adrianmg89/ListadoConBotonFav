package com.example.admin.listadoconbotonfav;

import android.app.FragmentManager;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 08/01/2018.
 */

public class AdaptadorVistaContacto implements ListAdapter {

    ArrayList<Persona> listaContactos;
    Context context;
    FragmentManager fm;
    public AdaptadorVistaContacto(ArrayList<Persona> listaContactos,Context context,FragmentManager fm){
    this.listaContactos = listaContactos;
    this.context = context;
    this.fm = fm;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return listaContactos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaContactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //Relaccionas la vista dnd se introduce la informacion del contacto (la que despues se mete a la lista)
        View vista = inflater.inflate(R.layout.vista_contacto,viewGroup,false);
        final Persona p = listaContactos.get(i);

        TextView nombre = (TextView) vista.findViewById(R.id.tvNombre);
        TextView telefono = (TextView) vista.findViewById(R.id.tvTele);
        ImageButton btnBorrar = vista.findViewById(R.id.btn_borrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBorrarPersona bp = new DialogBorrarPersona();

                Bundle argumentos = new Bundle();
                argumentos.putInt("id",p.getId());
                bp.setArguments(argumentos);
                bp.show(fm,"Borrar "+p.getNombre());
            }
        });
        nombre.setText(p.getNombre());
        telefono.setText(p.getTelefono());

        return vista;
    }

    @Override
    public int getItemViewType(int i) {
        return listaContactos.size();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return listaContactos.isEmpty();
    }
}
