package com.studio.quatro.cucktaleApp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetInicializer {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun createDrinkService() : DrinksService = retrofit.create(DrinksService::class.java)
}