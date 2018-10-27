package com.easyfood.easyfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.easyfood.easyfood.Aplicacion.EasyFoodApp;
import com.easyfood.easyfood.Logica.EasyFood;

public class ProductosActivity extends AppCompatActivity {


    private EasyFood _easyFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

    }
}
