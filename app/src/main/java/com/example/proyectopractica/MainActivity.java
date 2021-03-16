package com.example.proyectopractica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ListView listview1;
    private ListView listview2;
    private ListView listview3;
    private ListView listview4;

    AdminSQLite admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);
        listview1 = (ListView) findViewById(R.id.listview1);
        listview2 = (ListView) findViewById(R.id.listview2);
        listview3 = (ListView) findViewById(R.id.listview3);
        listview4 = (ListView) findViewById(R.id.listview4);

        admin = new AdminSQLite(getApplicationContext());
        admin.abrirBaseDeDatos();
    }

    public void limpiar(View view) {
        et1.setText(null);
        et2.setText(null);
        et3.setText(null);
        et4.setText(null);
    }

    public void insertar(View view){
        admin.insertarDatos(et1.getText().toString() , et2.getText().toString(),
                Integer.parseInt(et3.getText().toString()), et4.getText().toString());
        admin.abrirBaseDeDatos();
        limpiar(view);
        Toast.makeText(this, "Datos Ingresados", Toast.LENGTH_SHORT).show();

    }

    public void modificar(View view){
        Persona persona = new Persona();
        persona.setNombre(et1.getText().toString());
        persona.setApellido(et2.getText().toString());
        persona.setEdad(Integer.parseInt(et3.getText().toString()));
        persona.setSexo(et4.getText().toString());

        admin.modificarDatos(persona);
        limpiar(view);
        Toast.makeText(this, "Datos Modificados", Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View view){   //aca solamente se nesecita el nombre porque es la PK
        Persona persona = new Persona();
        persona.setNombre(et1.getText().toString());

        admin.eliminarDatos(persona);

        limpiar(view);
        Toast.makeText(this, "Datos Borrados !", Toast.LENGTH_SHORT).show();
    }



    public void seleccionar(View view){

        ArrayList<Persona> personas = admin.seleccionDatos();

        ArrayList<String> nombresString = new ArrayList<String>();  //tuve que crear un nuevo arraylist de Tipo String y ahi almaceno los valores para asi poder usar el adapter.
        ArrayList<String> apellidosString = new ArrayList<String>();
        ArrayList<String> edadString = new ArrayList<String>();
        ArrayList<String> sexoString = new ArrayList<String>();

        //O Puedo hacer un tablelayout y dentro 4 listviews y ahi usar 4 adapters distintos para 4 arraylists

        //Traer nombres SI tengo menos datos que los que estoy seleccionando la APP se cae.
        nombresString.add(personas.get(1).getNombre());
        nombresString.add(personas.get(2).getNombre());
        nombresString.add(personas.get(3).getNombre());
        nombresString.add(personas.get(4).getNombre());
        nombresString.add(personas.get(5).getNombre());
        nombresString.add(personas.get(6).getNombre());


        //Traer Apellidos
        apellidosString.add(personas.get(1).getApellido());
        apellidosString.add(personas.get(2).getApellido());
        apellidosString.add(personas.get(3).getApellido());
        apellidosString.add(personas.get(4).getApellido());
        apellidosString.add(personas.get(5).getApellido());
        apellidosString.add(personas.get(6).getApellido());


        edadString.add(String.valueOf(personas.get(1).getEdad()));
        edadString.add(String.valueOf(personas.get(2).getEdad()));
        edadString.add(String.valueOf(personas.get(3).getEdad()));
        edadString.add(String.valueOf(personas.get(4).getEdad()));
        edadString.add(String.valueOf(personas.get(5).getEdad()));
        edadString.add(String.valueOf(personas.get(6).getEdad()));


        sexoString.add(personas.get(1).getSexo());
        sexoString.add(personas.get(2).getSexo());
        sexoString.add(personas.get(3).getSexo());
        sexoString.add(personas.get(4).getSexo());
        sexoString.add(personas.get(5).getSexo());
        sexoString.add(personas.get(6).getSexo());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresString);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, apellidosString);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, edadString);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sexoString);


        listview1.setAdapter(adapter);
        listview2.setAdapter(adapter1);
        listview3.setAdapter(adapter2);
        listview4.setAdapter(adapter3);


        Toast.makeText(this, "Mostrando Datos", Toast.LENGTH_SHORT).show();


        //MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item_cuatro_columnas,nombresString);
        //listview1.setAdapter(myAdapter);
    }

    public void truncarTabla(View view) {
        admin.truncarTabla("USUARIO");
    }
}