package com.easyfood.easyfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imagen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        SetListeners();

    }

    private  void Init(){
        imagen1 = findViewById(R.id.imagen_producto_1);
        imagen1.setImageResource(R.drawable.desayuno_1);
    }
    private void SetListeners(){
        imagen1.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), "Eliminar producto", Toast.LENGTH_SHORT).show();

                return true;
            }

        });
    }
}
