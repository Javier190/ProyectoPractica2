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

import org.w3c.dom.Text;

import java.util.ArrayList;

//Programa Completo que realice solo para poder prepaparme para la prueba. Contiene CRUD, uso de 2 adapters para Listviews con layouts Personalziados
//Clase AdminSQLite donde van el CRUD

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


        admin = new AdminSQLite(getApplicationContext());
        admin.abrirBaseDeDatos();
    }

    public void limpiar(View view) {
        et1.setText(null);
        et2.setText(null);
        et3.setText(null);
        et4.setText(null); }

    public void insertar(View view){
        admin.insertarDatos(et1.getText().toString() , et2.getText().toString(),
                Integer.parseInt(et3.getText().toString()), et4.getText().toString());
        admin.abrirBaseDeDatos();
        limpiar(view);
        Toast.makeText(this, "Datos Ingresados !", Toast.LENGTH_SHORT).show(); }

    public void modificar(View view){
        Persona persona = new Persona();
        persona.setNombre(et1.getText().toString());
        persona.setApellido(et2.getText().toString());
        persona.setEdad(Integer.parseInt(et3.getText().toString()));
        persona.setSexo(et4.getText().toString());

        admin.modificarDatos(persona);
        limpiar(view);
        Toast.makeText(this, "Datos Modificados", Toast.LENGTH_SHORT).show(); }

    public void eliminar(View view){   //aca solamente se nesecita el nombre porque es la PK
        Persona persona = new Persona();
        persona.setNombre(et1.getText().toString());

        admin.eliminarDatos(persona);

        limpiar(view);
        Toast.makeText(this, "Datos Borrados !", Toast.LENGTH_SHORT).show(); }

    public void seleccionar(View view){

        ArrayList<Persona> personas = admin.seleccionDatos();

        ArrayList<String> nombresString = new ArrayList<String>();  //tuve que crear un nuevo arraylist de Tipo String y ahi almaceno los valores para asi poder usar el adapter.

        for (int i=0; i < personas.size(); i++) {
            nombresString.add(personas.get(i).getNombre()+ "       " + personas.get(i).getApellido() + "       " + personas.get(i).getEdad()+ "       " + personas.get(i).getSexo()); }

        //CODIGO EXTRA PARA USAR EL ADAPTER DE FORMA DIFERENTE
        //ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, Persona.personas);

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresString);

        listview1.setAdapter(adapter);
        Toast.makeText(this, "Mostrando Datos", Toast.LENGTH_SHORT).show();
    }

    public void truncarTabla(View view) { admin.truncarTabla("USUARIO"); }
}