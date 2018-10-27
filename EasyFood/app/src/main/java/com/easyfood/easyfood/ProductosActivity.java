package com.easyfood.easyfood;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.easyfood.easyfood.Aplicacion.EasyFoodApp;
import com.easyfood.easyfood.Aplicacion.PagerAdapter;
import com.easyfood.easyfood.Logica.EasyFood;

public class ProductosActivity extends AppCompatActivity {


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

    private void InitToolBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void InitTabLayout(){
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void InitPageAdapter(){
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

    public void ProbandoBoton(View view){
        Intent replyIntent = new Intent();
        setResult(RESULT_OK, replyIntent);
        _easyFood.CrearPostre("Torta de chocolate", R.drawable.desayuno_1);
        finish();
    }
}
