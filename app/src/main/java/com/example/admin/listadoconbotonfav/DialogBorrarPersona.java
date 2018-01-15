package com.example.admin.listadoconbotonfav;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by admin on 11/01/2018.
 */

public class DialogBorrarPersona extends DialogFragment{

    AvisarBorrado oyente;

    public interface AvisarBorrado{
        public void borrarContacto(int id);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        oyente = (AvisarBorrado)getActivity();
        Bundle argumentos = this.getArguments();
        String nombre = argumentos.getString("nombre");
        final int id = argumentos.getInt("id");
        builder.setMessage("¿Borrar contacto "+nombre+"?");
        builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                oyente.borrarContacto(id);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
