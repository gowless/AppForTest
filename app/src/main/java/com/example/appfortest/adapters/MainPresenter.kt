package com.example.appfortest.adapters

import com.studio.quatro.cucktaleApp.entities.DrinkList
import com.studio.quatro.cucktaleApp.network.RetInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    //loading list of drinks
    override fun onLoadList() {
        view.showLoading()
        val drinkService = RetInicializer().createDrinkService()
        val call = drinkService.getAlcoholicDrinks()
        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Connection failed.")
            }
            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null) {
                    view.showList(response.body()!!.drinks)
                } else {
                    view.showMessage("No drinks found")
                }
            }
        })
    }


    //loading clicked drink item
    override fun onLoadDrink(index: String) {
        view.showLoading()
        val drinkService = RetInicializer().createDrinkService()
        val call = drinkService.lookupDrink(index)
        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Connection failed.")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null) {
                    view.showDetail(response.body()!!.drinks)
                } else {
                    view.showMessage("No drinks found")
                }
            }
        })
    }

    //random drink function
    //clicked on snackbar
    override fun onRandomDrink() {

        view.showLoading()

        val drinkService = RetInicializer().createDrinkService()

        val call = drinkService.getRandomDrink()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Connection failed.")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null) {
                    view.showDetail(response.body()!!.drinks)
                } else {
                    view.showMessage("No drinks found")
                }
            }
        })

    }



}