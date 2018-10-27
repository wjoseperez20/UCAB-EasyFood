package com.easyfood.easyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.easyfood.easyfood.Aplicacion.EasyFoodApp;
import com.easyfood.easyfood.Logica.EasyFood;

public class MainActivity extends AppCompatActivity {

    ImageView imagenProducto1;
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

    }

    private void Init() {
        imagenProducto1 = findViewById(R.id.imagen_producto_1);
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
        Intent intent = new Intent(this, ProductosActivity.class);
        startActivityForResult(intent, 1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                if (_easyFood.GetListaProductos().size() > 0)
                    Toast.makeText(getApplicationContext(), "Producto Seleccionado: " + _easyFood.GetListaProductos().get(0).GetNombre(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "No se selecciono un producto", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
