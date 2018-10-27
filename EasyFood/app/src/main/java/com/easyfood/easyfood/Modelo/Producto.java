package com.easyfood.easyfood.Modelo;

public class Producto {
    private String _nombre;
    private Categoria _categoria;
    private int _imagen;

    public Producto(String nombre, Categoria categoria, int imagen){
        this._nombre = nombre;
        this._categoria = categoria;
        this._imagen = imagen;
    }

    public String GetCategoria(){
        return this._categoria.toString();
    }

    public String GetNombre(){
        return this._nombre;
    }

    public int GetImagen(){
        return this._imagen;
    }


}
