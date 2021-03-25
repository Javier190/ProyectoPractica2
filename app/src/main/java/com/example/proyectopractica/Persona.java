package com.example.proyectopractica;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;


    //CODIGO EXTRA CON DATOS YA GENERADOS DE UN PRINCIPIO SACADO DE LA APP DE TIENDA. sIRVE PARA UNA APP DE TIENDA PQ YA ESTAN CREADOS LOS PRODUCTOS DE ANTES. nO ES PARA INGRESAR USUARIOS POR EJEMPLO.
   /* public static final Persona personas[] = {
            new Persona("Eren", "Jaeger", 27, "M"),
            new Persona("Levi", "Ackerman", 29, "M"),
    }; */





    public Persona(){}

    public Persona(String nombre, String apellido, int edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) { this.sexo = sexo; }


    //CODIGO EXTRA
    @Override
    public String toString() {
        return this.nombre;
    }
}

