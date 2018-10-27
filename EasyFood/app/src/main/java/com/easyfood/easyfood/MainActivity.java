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

    private void InicializarProductos(){
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

    private void SetListeners() {
        imagenProducto1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(getApplicationContext(), "Eliminar producto", Toast.LENGTH_SHORT).show();
                return true;
            }

        });
    }

    public void AgregarProducto(View view) {

        if(_easyFood.ValidarAgregarProducto())
        {
            Intent intent = new Intent(this, ProductosActivity.class);
            startActivityForResult(intent, 1);
        }
        else
            Toast.makeText(getApplicationContext(), "Capacidad máxima de productos alcanzada.", Toast.LENGTH_SHORT).show();
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                if (_easyFood.GetListaProductos().size() > 0){
                    AsignarProductos();
                    Toast.makeText(getApplicationContext(), "Producto agregado exitosamente.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No se selecciono un producto.", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void AsignarProductos(){
        for(int i = 0; i < _easyFood.GetListaProductos().size(); i++) {
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

    private void SetProducto(ImageView Image, TextView Text, int ImagenProducto, String NombreProducto){
        Image.setImageResource(ImagenProducto);
        Text.setText(NombreProducto);
    }
}
