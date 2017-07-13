package br.com.mawan.layouts

/**
 * Created by marcelo on 11/07/2017.
 */


internal fun getListaCar(qtd: Int): List<Car> {
    val modelos = arrayListOf<String>("Gallardo", "Vyron", "Corvette", "Pagani Zonda", "Porsche 911 Carrera", "BMW 720i", "DB77", "Mustang", "Camaro", "CT6")
    val marcas = arrayListOf<String>("Lamborghini", " bugatti", "Chevrolet", "Pagani", "Porsche", "BMW", "Aston Martin", "Ford", "Chevrolet", "Cadillac")
    val imagens = intArrayOf(R.drawable.car_gallardo, R.drawable.car_vyron, R.drawable.car_corvette, R.drawable.car_paganni_zonda, R.drawable.car_porsche_911, R.drawable.car_bmw_720, R.drawable.car_db77, R.drawable.car_mustang, R.drawable.car_camaro, R.drawable.car_ct6)
    val listaCars = ArrayList<Car>()

    for (i in 0..qtd) {
        var index = i % modelos.size
        listaCars.add(Car(modelos.get(index), marcas.get(index), imagens.get(index)))
    }
    return listaCars
}

//class Utils
