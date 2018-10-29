package com.easyfood.easyfood.Logica;


import android.util.Log;

import com.easyfood.easyfood.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class EasyFood {

    //Lista de productos seleccionados.
    private List<Producto> _productosSeleccionados;


    private Producto _productoSeleccionado;

    public EasyFood() {
        this._productosSeleccionados = new ArrayList<>();
    }

    public List<Producto> GetListaProductos() {
        return this._productosSeleccionados;
    }

    /*
        Crea la instancia del objeto producto y lo agrega a la lista de productos seleccionados
     */
    public void CrearProducto(String Nombre, int Imagen) {
        this._productoSeleccionado = new Producto(Nombre, Imagen);
        this._productosSeleccionados.add(_productoSeleccionado);
    }

    /*
        Obtiene la instancia del objeto Producto según el índice de posición en la lista de productos seleccionados.
    */
    public Producto GetProducto(int posicion) {
        Producto retorno = null;

        try {
            retorno = this._productosSeleccionados.get(posicion);
        } catch (Exception e) {
            Log.d("OBTENER PRODUCTO", e.getMessage());
        }

        return retorno;

    }

    /*
        Valida si es posible agregar un nuevo producto, capacidad máxima de 10 productos.
    */
    public Boolean ValidarAgregarProducto() {
        Boolean valido = true;

        if (_productosSeleccionados.size() > 9)
            valido = false;

        return valido;
    }

    /*
        Si el índice tiene un valor válido entre 0 y la cantidad de elementos en la lista,
            elimina la instancia del objeto Producto en el índice respectivo.
    */
    public Boolean EliminarProducto(int indice) {
        Boolean retorno = false;

        if (indice >= 0 && indice < _productosSeleccionados.size()) {
            _productosSeleccionados.remove(indice);
            retorno = true;
        }

        return retorno;

    }
}
