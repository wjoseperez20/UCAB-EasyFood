package com.easyfood.easyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyfood.easyfood.Aplicacion.EasyFoodApp;
import com.easyfood.easyfood.Logica.EasyFood;
import com.easyfood.easyfood.Modelo.Producto;

public class MainActivity extends AppCompatActivity {

    ImageView imagenProducto1, imagenProducto2, imagenProducto3, imagenProducto4,
            imagenProducto5, imagenProducto6, imagenProducto7, imagenProducto8,
            imagenProducto9, imagenProducto10;

    TextView nombreProducto1, nombreProducto2, nombreProducto3, nombreProducto4,
            nombreProducto5, nombreProducto6, nombreProducto7, nombreProducto8,
            nombreProducto9, nombreProducto10;

    //Logica principal de la aplicación.
    EasyFood _easyFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        _easyFood = EasyFoodApp.getEasyFood();

        Init();
        SetListeners();
        InicializarProductos();
        AsignarProductos();

    }

    private void Init() {

        imagenProducto1 = findViewById(R.id.imagen_producto_1);
        imagenProducto2 = findViewById(R.id.imagen_producto_2);
        imagenProducto3 = findViewById(R.id.imagen_producto_3);
        imagenProducto4 = findViewById(R.id.imagen_producto_4);
        imagenProducto5 = findViewById(R.id.imagen_producto_5);
        imagenProducto6 = findViewById(R.id.imagen_producto_6);
        imagenProducto7 = findViewById(R.id.imagen_producto_7);
        imagenProducto8 = findViewById(R.id.imagen_producto_8);
        imagenProducto9 = findViewById(R.id.imagen_producto_9);
        imagenProducto10 = findViewById(R.id.imagen_producto_10);

        nombreProducto1 = findViewById(R.id.nombre_1);
        nombreProducto2 = findViewById(R.id.nombre_2);
        nombreProducto3 = findViewById(R.id.nombre_3);
        nombreProducto4 = findViewById(R.id.nombre_4);
        nombreProducto5 = findViewById(R.id.nombre_5);
        nombreProducto6 = findViewById(R.id.nombre_6);
        nombreProducto7 = findViewById(R.id.nombre_7);
        nombreProducto8 = findViewById(R.id.nombre_8);
        nombreProducto9 = findViewById(R.id.nombre_9);
        nombreProducto10 = findViewById(R.id.nombre_10);

    }

    /*
        Asigna la imagen y texto por defecto a los 10 productos próximos a seleccionar.
    */
    private void InicializarProductos() {
        imagenProducto1.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto2.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto3.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto4.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto5.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto6.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto7.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto8.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto9.setImageResource(R.drawable.ic_photo_empty);
        imagenProducto10.setImageResource(R.drawable.ic_photo_empty);

        nombreProducto1.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto2.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto3.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto4.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto5.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto6.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto7.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto8.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto9.setText(getResources().getString(R.string.producto_seleccione));
        nombreProducto10.setText(getResources().getString(R.string.producto_seleccione));

    }

    /*
        Asigna el proceso que se ejecutará al activar el longClick en cada imagen.
    */
    private void SetListeners() {
        imagenProducto1.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto2.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto3.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto4.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto5.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto6.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto7.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto8.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto9.setOnLongClickListener(eventoEliminarProducto);
        imagenProducto10.setOnLongClickListener(eventoEliminarProducto);

    }

    /*
        Según el ImageView que active el evento LongClick se elimina el producto respectivo por su índice (0 - 9)
    */
    View.OnLongClickListener eventoEliminarProducto = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            switch (v.getId()) {
                case R.id.imagen_producto_1:
                    EliminarProducto(0);
                    break;
                case R.id.imagen_producto_2:
                    EliminarProducto(1);
                    break;
                case R.id.imagen_producto_3:
                    EliminarProducto(2);
                    break;
                case R.id.imagen_producto_4:
                    EliminarProducto(3);
                    break;
                case R.id.imagen_producto_5:
                    EliminarProducto(4);
                    break;
                case R.id.imagen_producto_6:
                    EliminarProducto(5);
                    break;
                case R.id.imagen_producto_7:
                    EliminarProducto(6);
                    break;
                case R.id.imagen_producto_8:
                    EliminarProducto(7);
                    break;
                case R.id.imagen_producto_9:
                    EliminarProducto(8);
                    break;
                case R.id.imagen_producto_10:
                    EliminarProducto(9);
                    break;
            }
            return true;
        }
    };


    /*
        Muestra el mensaje de producto eliminado mediante un Toast.
    */
    private void ToastProductoEliminado() {
        Toast.makeText(getApplicationContext(), "Producto eliminado con éxito.", Toast.LENGTH_SHORT).show();
    }

    /*
        Muestra el mensaje de error al eliminar un producto mediante un Toast.
    */
    private void ToastErrorEliminar() {
        Toast.makeText(getApplicationContext(), "Espacio disponible para agregar un producto.", Toast.LENGTH_SHORT).show();
    }

    /*
        Método para eliminar el producto de la lista de productos por su índice y reasignar los productos restantes nuevamente.
    */
    private void EliminarProducto(int indice) {

        if (_easyFood.EliminarProducto(indice)) {
            InicializarProductos();
            AsignarProductos();
            ToastProductoEliminado();
        } else
            ToastErrorEliminar();
    }

    /*
        Si la cantidad de productos no excede el límite, inicia el segundo activity para seleccionar el producto a ser agregado.
    */
    public void AgregarProducto(View view) {

        if (_easyFood.ValidarAgregarProducto()) {
            Intent intent = new Intent(this, ProductosActivity.class);
            startActivityForResult(intent, 1);
        } else
            Toast.makeText(getApplicationContext(), "Capacidad máxima de productos alcanzada.", Toast.LENGTH_SHORT).show();
    }


    /*
        Una vez seleccionado el producto en la segunda activity, lo asigna a la lista de productos seleccionados.
    */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                if (_easyFood.GetListaProductos().size() > 0) {
                    AsignarProductos();
                    Toast.makeText(getApplicationContext(), "Producto agregado exitosamente.", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "No se selecciono un producto.", Toast.LENGTH_SHORT).show();
            }

        }

    }

    /*
        Dependiendo del indice del producto en la lista de productos seleccionados, lo asigna a la imagen y texto respectivo.
    */
    private void AsignarProductos() {
        for (int i = 0; i < _easyFood.GetListaProductos().size(); i++) {
            Producto producto = _easyFood.GetProducto(i);
            switch (i) {
                case 0:
                    SetProducto(imagenProducto1, nombreProducto1, producto.GetImagen(), producto.GetNombre());
                    break;
                case 1:
                    SetProducto(imagenProducto2, nombreProducto2, producto.GetImagen(), producto.GetNombre());
                    break;
                case 2:
                    SetProducto(imagenProducto3, nombreProducto3, producto.GetImagen(), producto.GetNombre());
                    break;
                case 3:
                    SetProducto(imagenProducto4, nombreProducto4, producto.GetImagen(), producto.GetNombre());
                    break;
                case 4:
                    SetProducto(imagenProducto5, nombreProducto5, producto.GetImagen(), producto.GetNombre());
                    break;
                case 5:
                    SetProducto(imagenProducto6, nombreProducto6, producto.GetImagen(), producto.GetNombre());
                    break;
                case 6:
                    SetProducto(imagenProducto7, nombreProducto7, producto.GetImagen(), producto.GetNombre());
                    break;
                case 7:
                    SetProducto(imagenProducto8, nombreProducto8, producto.GetImagen(), producto.GetNombre());
                    break;
                case 8:
                    SetProducto(imagenProducto9, nombreProducto9, producto.GetImagen(), producto.GetNombre());
                    break;
                case 9:
                    SetProducto(imagenProducto10, nombreProducto10, producto.GetImagen(), producto.GetNombre());
                    break;
                default:
                    Log.d("ERROR", "Capacidad máxima de productos");
            }
        }
    }

    private void SetProducto(ImageView Image, TextView Text, int ImagenProducto, String NombreProducto) {
        Image.setImageResource(ImagenProducto);
        Text.setText(NombreProducto);
    }
}
