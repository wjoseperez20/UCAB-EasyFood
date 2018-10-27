package com.easyfood.easyfood.Modelo;

public enum Categoria
{
    DESAYUNO("Desayuno"),
    ALMUERZO("Almuerzo"),
    POSTRE("Postre");

    private final String nombre;

    Categoria(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return nombre;
    }
}
