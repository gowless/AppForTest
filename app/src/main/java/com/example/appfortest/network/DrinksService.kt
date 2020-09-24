package com.studio.quatro.cucktaleApp.network

import com.studio.quatro.cucktaleApp.entities.Drink
import com.studio.quatro.cucktaleApp.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {


    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks() : Call<DrinkList>

    @GET("lookup.php")
    fun lookupDrink(@Query("i") i : String = "11000") : Call<DrinkList>

    @GET("random.php")
    fun getRandomDrink() : Call<DrinkList>


}