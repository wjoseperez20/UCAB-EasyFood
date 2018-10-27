package com.easyfood.easyfood.Logica;


import com.easyfood.easyfood.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class EasyFood {

    private List<Producto> _productosSeleccionados;

    public EasyFood() {
        this._productosSeleccionados = new ArrayList<>();
    }

    public void Init() {

    }

    public List<Producto> GetListaProductos() {
        return this._productosSeleccionados;
    }

    public void CrearProducto(String Nombre, int Imagen) {
        Producto almuerzo = new Producto(Nombre, Imagen);
        this._productosSeleccionados.add(almuerzo);
    }
}
