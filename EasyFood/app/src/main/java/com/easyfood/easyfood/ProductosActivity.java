package com.easyfood.easyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.easyfood.easyfood.Aplicacion.EasyFoodApp;
import com.easyfood.easyfood.Aplicacion.PagerAdapter;
import com.easyfood.easyfood.Logica.EasyFood;

public class ProductosActivity extends AppCompatActivity {


    //Logica principal de la aplicación.
    private EasyFood _easyFood;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        InitToolBar();
        InitTabLayout();
        InitPageAdapter();

        _easyFood = EasyFoodApp.getEasyFood();
    }

    private void InitToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void InitTabLayout() {
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void InitPageAdapter() {
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    /*
        Este metodo se inicia al darle click a una imagen de la lista de desayunos.
        Crea el producto según la imagen seleccionada y vuelve al activity inicial, agregando el desayuno seleccionado.
    */
    public void AgregarDesayuno(View view){

        switch (view.getId()){
            case R.id.imagen_desayuno_1:
                SeleccionarProducto(R.drawable.desayuno_1, GetStringResource(R.string.desayuno_1_nombre));
                break;
            case R.id.imagen_desayuno_2:
                SeleccionarProducto(R.drawable.avenafrutos, GetStringResource(R.string.desayuno_2_nombre));
                break;
            case R.id.imagen_desayuno_3:
                SeleccionarProducto(R.drawable.croissant, GetStringResource(R.string.desayuno_3_nombre));
                break;
            case R.id.imagen_desayuno_4:
                SeleccionarProducto(R.drawable.croquemadame, GetStringResource(R.string.desayuno_4_nombre));
                break;
            case R.id.imagen_desayuno_5:
                SeleccionarProducto(R.drawable.croque_madame_camote, GetStringResource(R.string.desayuno_5_nombre));
                break;
            case R.id.imagen_desayuno_6:
                SeleccionarProducto(R.drawable.huevos_benedictinos, GetStringResource(R.string.desayuno_6_nombre));
                break;
            case R.id.imagen_desayuno_7:
                SeleccionarProducto(R.drawable.huevos_en_cazuela, GetStringResource(R.string.desayuno_7_nombre));
                break;
            case R.id.imagen_desayuno_8:
                SeleccionarProducto(R.drawable.matcha_con_arandano, GetStringResource(R.string.desayuno_8_nombre));
                break;
            case R.id.imagen_desayuno_9:
                SeleccionarProducto(R.drawable.pan_frances_manzana, GetStringResource(R.string.desayuno_9_nombre));
                break;
            case R.id.imagen_desayuno_10:
                SeleccionarProducto(R.drawable.wafles_manzana, GetStringResource(R.string.desayuno_10_nombre));
                break;
            default:
                Log.d("ERROR", "Error al seleccionar desayuno.");
        }
    }

    /*
        Este metodo se inicia al darle click a una imagen de la lista de almuerzos.
        Crea el producto según la imagen seleccionada y vuelve al activity inicial, agregando el almuerzo seleccionado.
    */
    public void AgregarAlmuerzo(View view){

        switch (view.getId()){
            case R.id.imagen_almuerzo_1:
                SeleccionarProducto(R.drawable.carnealaparrillaservidaconpapasfritas,
                        GetStringResource(R.string.almuerzo_1_nombre));
                break;
            case R.id.imagen_almuerzo_2:
                SeleccionarProducto(R.drawable.carnetiernayalinoapunto, GetStringResource(R.string.almuerzo_2_nombre));
                break;
            case R.id.imagen_almuerzo_3:
                SeleccionarProducto(R.drawable.carpachiodecarne, GetStringResource(R.string.almuerzo_3_nombre));
                break;
            case R.id.imagen_almuerzo_4:
                SeleccionarProducto(R.drawable.cevicheperuano, GetStringResource(R.string.almuerzo_4_nombre));
                break;
            case R.id.imagen_almuerzo_5:
                SeleccionarProducto(R.drawable.chuletonahumadocasero, GetStringResource(R.string.almuerzo_5_nombre));
                break;
            case R.id.imagen_almuerzo_6:
                SeleccionarProducto(R.drawable.faisanalawalkirya, GetStringResource(R.string.almuerzo_6_nombre));
                break;
            case R.id.imagen_almuerzo_7:
                SeleccionarProducto(R.drawable.gambastigreaalaparrilla, GetStringResource(R.string.almuerzo_7_nombre));
                break;
            case R.id.imagen_almuerzo_8:
                SeleccionarProducto(R.drawable.nusryhamburguesa, GetStringResource(R.string.almuerzo_8_nombre));
                break;
            case R.id.imagen_almuerzo_9:
                SeleccionarProducto(R.drawable.pescadodeldia, GetStringResource(R.string.almuerzo_9_nombre));
                break;
            case R.id.imagen_almuerzo_10:
                SeleccionarProducto(R.drawable.tomahawk, GetStringResource(R.string.almuerzo_10_nombre));
                break;
            default:
                Log.d("ERROR", "Error al seleccionar almuerzo.");
        }
    }

    /*
        Este metodo se inicia al darle click a una imagen de la lista de postres.
        Crea el producto según la imagen seleccionada y vuelve al activity inicial, agregando el postre seleccionado.
    */
    public void AgregarPostre(View view){

        switch (view.getId()){
            case R.id.imagen_postre_1:
                SeleccionarProducto(R.drawable.brownie, GetStringResource(R.string.postre_1_nombre));
                break;
            case R.id.imagen_postre_2:
                SeleccionarProducto(R.drawable.bunuelo, GetStringResource(R.string.postre_2_nombre));
                break;
            case R.id.imagen_postre_3:
                SeleccionarProducto(R.drawable.cheesecake, GetStringResource(R.string.postre_3_nombre));
                break;
            case R.id.imagen_postre_4:
                SeleccionarProducto(R.drawable.cpulant, GetStringResource(R.string.postre_4_nombre));
                break;
            case R.id.imagen_postre_5:
                SeleccionarProducto(R.drawable.helado, GetStringResource(R.string.postre_5_nombre));
                break;
            case R.id.imagen_postre_6:
                SeleccionarProducto(R.drawable.pistacho, GetStringResource(R.string.postre_6_nombre));
                break;
            case R.id.imagen_postre_7:
                SeleccionarProducto(R.drawable.tiramisu, GetStringResource(R.string.postre_7_nombre));
                break;
            case R.id.imagen_postre_8:
                SeleccionarProducto(R.drawable.torta_hojaldre, GetStringResource(R.string.postre_8_nombre));
                break;
            case R.id.imagen_postre_9:
                SeleccionarProducto(R.drawable.torta_zanahoria, GetStringResource(R.string.postre_9_nombre));
                break;
            case R.id.imagen_postre_10:
                SeleccionarProducto(R.drawable.turca, GetStringResource(R.string.postre_10_nombre));
                break;
            default:
                Log.d("ERROR", "Error al seleccionar postre.");
        }
    }


    /*
        Obtener el valor del String por el identificador del recurso.
    */
    private String GetStringResource(int identificador){
        return getResources().getString(identificador);
    }

    /*
        Crea la instancia del objeto producto y termina la activity.
    */
    private void SeleccionarProducto(int ImagenProducto, String NombreProducto) {
        _easyFood.CrearProducto(NombreProducto, ImagenProducto);
        TerminarActivity();
    }

    /*
        Retorna a la activity inicial con un codigo de exito. (1)
    */
    private void TerminarActivity(){
        Intent replyIntent = new Intent();
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
