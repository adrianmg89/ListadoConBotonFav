package com.example.admin.listadoconbotonfav;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by admin on 08/01/2018.
 */

public class BaseDeDatos {

    static Context context;
    static SQLiteOpenHelper sq;

    public static SQLiteDatabase start(Context c){
        sq = new SQLiteOpenHelper(c,"AgendaContactos2",null,1) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                String tabla_contactos = "CREATE TABLE 'Contactos' (\n"+
                        "'id' INTEGER PRIMARY KEY,\n"+
                        "'nombre' TEXT,\n"+
                        "'telefono' TEXT\n"+
                        ");";
                sqLiteDatabase.execSQL(tabla_contactos);
            }
            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            }
        };
        SQLiteDatabase bbdd = sq.getWritableDatabase();
        return bbdd;
    }

    public static ArrayList<Persona> mostrarContactos(Context contexto) {
        context=contexto;
        ArrayList<Persona> listaContactos = new ArrayList<>();
        String todo = "select id,nombre,telefono from Contactos";
        SQLiteDatabase bbdd = start(context);
        Cursor cursor = bbdd.rawQuery(todo,null);

        while(cursor.moveToNext()){
            int id = Integer.parseInt(cursor.getString(0));
            String n = cursor.getString(1);
            String t = cursor.getString(2);
            Persona p = new Persona(n,t,id);
            listaContactos.add(p);
        }
        return listaContactos;
    }

    public static void insertarContacto(Persona p){
        String n = p.getNombre();
        String t = p.getTelefono();
        String insertar = "INSERT INTO Contactos (nombre,telefono) VALUES ('"+n+"','"+t+"');";
        SQLiteDatabase bbdd = start(context);
        bbdd.execSQL(insertar);

    }
    public static void borrarContacto(int id){

    }
}
