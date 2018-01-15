package com.example.admin.listadoconbotonfav;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by admin on 08/01/2018.
 */

public class DialogInsertar extends DialogFragment{
    OyenteDialog oyente;

    public interface OyenteDialog{
        public void insertarPersona (Persona c);
    }

    public Dialog onCreateDialog (Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View vista = inflater.inflate(R.layout.insertar_contacto,null);

        //Los botones de los Dialog tiene que gestionarlos el builder porque así al clicarlos hará el dismiss(cerrar Dialog)
        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombre = ((EditText)vista.findViewById(R.id.et_nombre)).getText().toString();
                String telefono = ((EditText)vista.findViewById(R.id.et_telefono)).getText().toString();
                oyente = (OyenteDialog) getActivity();
                oyente.insertarPersona(new Persona(nombre,telefono,999));
                Log.v("Guardado contacto ", nombre);
            };
        });
        builder.setView(vista);
        return builder.create();
    }
}
