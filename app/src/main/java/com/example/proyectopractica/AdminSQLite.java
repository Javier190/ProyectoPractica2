package com.example.proyectopractica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;

public class AdminSQLite extends SQLiteOpenHelper {

    public AdminSQLite(Context context){super(context, "DB_Javier", null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table personas ("+
                "nombre varchar(100)" +
                ",apellido varchar(100)"+
                ",edad int"+
                ",sexo varchar(1))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Abrir base de datos.
    public SQLiteDatabase abrirBaseDeDatos()  {
        return getReadableDatabase();
    }

    //*****************CRUD**********// Para los 3 primeros metodos hay que poner writable pq vamos a modificar la data. escribir en ella.

    public void modificarDatos(Persona persona){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "UPDATE personas SET nombre='%s', apellido='%s', edad=%d, sexo='%s' " +
                        "WHERE nombre='%s';", persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getSexo(), persona.getNombre());
        db.execSQL(sql);
        db.close();
    }
 //Ojo este metodo insertar tambien pudo haber sido hecho con parametro de entrada un objeto tipo usuario, como aparece arriba en modificar.

    public void insertarDatos(String nombre, String apellido, int edad, String sexo){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "insert into personas (nombre, apellido, edad, sexo) " +
                        "values ('%s','%s','%d','%s');",nombre, apellido, edad, sexo);
        db.execSQL(sql);
        db.close();
    }

    public void eliminarDatos(Persona persona){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format(
                "DELETE FROM personas " +
                        "WHERE nombre='%s';", persona.getNombre());
        db.execSQL(sql);
        db.close();
    }

    public ArrayList <Persona> seleccionDatos(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c;
        ArrayList<Persona> personas = new ArrayList<Persona>();

        c = db.rawQuery("select * from personas", null);

        if (c.moveToFirst()) {
            do {
                personas.add(new Persona(c.getString(0), c.getString(1), c.getInt(2), c.getString(3)));
            } while(c.moveToNext());
        }
        db.close();
        return personas;
    }

    public void truncarTabla(String tabla) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + tabla);
        db.close();
    }

}
