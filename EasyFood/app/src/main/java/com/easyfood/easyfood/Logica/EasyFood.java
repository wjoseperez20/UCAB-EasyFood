package com.easyfood.easyfood.Logica;


import android.util.Log;

import com.easyfood.easyfood.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class EasyFood {

    private List<Producto> _productosSeleccionados;
    private Producto _productoSeleccionado;

    public EasyFood() {
        this._productosSeleccionados = new ArrayList<>();
    }

    public List<Producto> GetListaProductos() {
        return this._productosSeleccionados;
    }

    public void CrearProducto(String Nombre, int Imagen) {
        this._productoSeleccionado = new Producto(Nombre, Imagen);
        this._productosSeleccionados.add(_productoSeleccionado);
    }

    public Producto GetProducto(int posicion){
        Producto retorno = null;

        try
        {
            retorno = this._productosSeleccionados.get(posicion);
        }
        catch (Exception e)
        {
            Log.d("OBTENER PRODUCTO", e.getMessage());
        }

        return  retorno;

    }

    public Boolean ValidarAgregarProducto(){
        Boolean valido = true;

        if(_productosSeleccionados.size() > 9)
            valido = false;

        return  valido;
    }
}
