package com.easyfood.easyfood.Aplicacion;

import android.app.Application;

import com.easyfood.easyfood.Logica.EasyFood;

public class EasyFoodApp extends Application {

    private static EasyFood _easyFood;

    public EasyFoodApp() {
        _easyFood = new EasyFood();
    }

    public static EasyFood getEasyFood() {
        return _easyFood;
    }
}
