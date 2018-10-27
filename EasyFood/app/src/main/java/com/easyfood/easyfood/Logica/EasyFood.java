package com.easyfood.easyfood.Logica;

import android.content.Context;


import com.easyfood.easyfood.Modelo.Categoria;
import com.easyfood.easyfood.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class EasyFood {

    private List<Producto> _productosSeleccionados;

    public EasyFood(){
        this._productosSeleccionados = new ArrayList<>();
    }

    public void Init(){

    }

    public List<Producto> GetListaProductos(){
        return this._productosSeleccionados;
    }

    public void CrearAlmuerzo(String Nombre, int Imagen){
        Producto almuerzo = new Producto(Nombre, Categoria.ALMUERZO, Imagen);
        this._productosSeleccionados.add(almuerzo);
    }

    public void CrearDesayuno(String Nombre, int Imagen){
        Producto desayuno = new Producto(Nombre, Categoria.DESAYUNO, Imagen);
        this._productosSeleccionados.add(desayuno);
    }

    public void CrearPostre(String Nombre, int Imagen){
        Producto postre = new Producto(Nombre, Categoria.POSTRE, Imagen);
        this._productosSeleccionados.add(postre);
    }
}
