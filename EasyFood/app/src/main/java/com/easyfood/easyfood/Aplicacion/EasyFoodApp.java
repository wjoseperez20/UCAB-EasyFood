package com.easyfood.easyfood.Aplicacion;

import android.app.Application;

import com.easyfood.easyfood.Logica.EasyFood;

/*
    Clase que extiende de Aplication que permite obtener la instancia del objeto EasyFood en cualquier parte del código.
    Esta clase solo se instancia una vez al iniciar la aplicación.
*/

public class EasyFoodApp extends Application {

    private static EasyFood _easyFood;

    public EasyFoodApp() {
        _easyFood = new EasyFood();
    }

    public static EasyFood getEasyFood() {
        return _easyFood;
    }
}
