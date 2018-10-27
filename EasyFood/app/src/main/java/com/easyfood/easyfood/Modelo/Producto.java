package com.easyfood.easyfood.Modelo;

public class Producto {
    private String _nombre;
    private int _imagen;

    public Producto(String nombre, int imagen){
        this._nombre = nombre;
        this._imagen = imagen;
    }

    public String GetNombre(){
        return this._nombre;
    }

    public int GetImagen(){
        return this._imagen;
    }


}
