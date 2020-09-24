package com.example.appfortest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.appfortest.R
import com.example.appfortest.utils.GlideApp
import com.studio.quatro.cucktaleApp.entities.Drink
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.fragment_drink_detail.*
import java.lang.NullPointerException


class DrinkDetailFragment : Fragment() {

    companion object {

        private val ARG_DRINK = "arg_drink"

        fun newInstance(drink: Drink) =
            DrinkDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_DRINK, drink)
                }
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drink = getDrink()

        activity?.let { that ->
            GlideApp.with(that)
                .load(drink.strDrinkThumb)
                .fitCenter()
                .transform(RoundedCornersTransformation(24, 8))
                .into(drinkDetailImg)
        }


        //drinks declaration views
        drinkDetailedTitle.text = drink.strDrink
        drinkDetailedAlcoholic.text = drink.strAlcoholic
        drinkDetailedGlass.text = "Serve with ".plus(drink.strGlass)
        drinkDetailedCategory.text = "Category: ".plus(drink.strCategory)
        drinkDetailedInstructions.text = drink.strInstructions

        drinkDetailedIgr1.text = drink.strIngredient1
        drinkDetailedMsr1.text = drink.strMeasure1
        drinkDetailedIgr2.text = drink.strIngredient2
        drinkDetailedMsr2.text = drink.strMeasure2
        drinkDetailedIgr3.text = drink.strIngredient3
        drinkDetailedMsr3.text = drink.strMeasure3
        drinkDetailedIgr4.text = drink.strIngredient4
        drinkDetailedMsr4.text = drink.strMeasure4
        drinkDetailedIgr5.text = drink.strIngredient5
        drinkDetailedMsr5.text = drink.strMeasure5
        drinkDetailedIgr6.text = drink.strIngredient6
        drinkDetailedMsr6.text = drink.strMeasure6
        drinkDetailedIgr7.text = drink.strIngredient7
        drinkDetailedMsr7.text = drink.strMeasure7
        drinkDetailedIgr8.text = drink.strIngredient8
        drinkDetailedMsr8.text = drink.strMeasure8
        drinkDetailedIgr9.text = drink.strIngredient9
        drinkDetailedMsr9.text = drink.strMeasure9
        drinkDetailedIgr10.text = drink.strIngredient10
        drinkDetailedMsr10.text = drink.strMeasure10
        drinkDetailedIgr11.text = drink.strIngredient11
        drinkDetailedMsr11.text = drink.strMeasure11
        drinkDetailedIgr12.text = drink.strIngredient12
        drinkDetailedMsr12.text = drink.strMeasure12
        drinkDetailedIgr13.text = drink.strIngredient13
        drinkDetailedMsr13.text = drink.strMeasure13
        drinkDetailedIgr14.text = drink.strIngredient14
        drinkDetailedMsr14.text = drink.strMeasure14
        drinkDetailedIgr15.text = drink.strIngredient15
        drinkDetailedMsr15.text = drink.strMeasure15


        //checking for summary existing fields
        if(drinkDetailedIgr1.text == "") (drinkDetailedIgr1.parent as ViewGroup).removeView(drinkDetailedIgr1)
        if(drinkDetailedMsr1.text == "") (drinkDetailedMsr1.parent as ViewGroup).removeView(drinkDetailedMsr1)
        if(drinkDetailedIgr2.text == "") (drinkDetailedIgr2.parent as ViewGroup).removeView(drinkDetailedIgr2)
        if(drinkDetailedMsr2.text == "") (drinkDetailedMsr2.parent as ViewGroup).removeView(drinkDetailedMsr2)
        if(drinkDetailedIgr3.text == "") (drinkDetailedIgr3.parent as ViewGroup).removeView(drinkDetailedIgr3)
        if(drinkDetailedMsr3.text == "") (drinkDetailedMsr3.parent as ViewGroup).removeView(drinkDetailedMsr3)
        if(drinkDetailedIgr4.text == "") (drinkDetailedIgr4.parent as ViewGroup).removeView(drinkDetailedIgr4)
        if(drinkDetailedMsr4.text == "") (drinkDetailedMsr4.parent as ViewGroup).removeView(drinkDetailedMsr4)
        if(drinkDetailedIgr5.text == "") (drinkDetailedIgr5.parent as ViewGroup).removeView(drinkDetailedIgr5)
        if(drinkDetailedMsr5.text == "") (drinkDetailedMsr5.parent as ViewGroup).removeView(drinkDetailedMsr5)
        if(drinkDetailedIgr6.text == "") (drinkDetailedIgr6.parent as ViewGroup).removeView(drinkDetailedIgr6)
        if(drinkDetailedMsr6.text == "") (drinkDetailedMsr6.parent as ViewGroup).removeView(drinkDetailedMsr6)
        if(drinkDetailedIgr7.text == "") (drinkDetailedIgr7.parent as ViewGroup).removeView(drinkDetailedIgr7)
        if(drinkDetailedMsr7.text == "") (drinkDetailedMsr7.parent as ViewGroup).removeView(drinkDetailedMsr7)
        if(drinkDetailedIgr8.text == "") (drinkDetailedIgr8.parent as ViewGroup).removeView(drinkDetailedIgr8)
        if(drinkDetailedMsr8.text == "") (drinkDetailedMsr8.parent as ViewGroup).removeView(drinkDetailedMsr8)
        if(drinkDetailedIgr9.text == "") (drinkDetailedIgr9.parent as ViewGroup).removeView(drinkDetailedIgr9)
        if(drinkDetailedMsr9.text == "") (drinkDetailedMsr9.parent as ViewGroup).removeView(drinkDetailedMsr9)
        if(drinkDetailedIgr10.text == "") (drinkDetailedIgr10.parent as ViewGroup).removeView(drinkDetailedIgr10)
        if(drinkDetailedMsr10.text == "") (drinkDetailedMsr10.parent as ViewGroup).removeView(drinkDetailedMsr10)
        if(drinkDetailedIgr11.text == "") (drinkDetailedIgr11.parent as ViewGroup).removeView(drinkDetailedIgr11)
        if(drinkDetailedMsr11.text == "") (drinkDetailedMsr11.parent as ViewGroup).removeView(drinkDetailedMsr11)
        if(drinkDetailedIgr12.text == "") (drinkDetailedIgr12.parent as ViewGroup).removeView(drinkDetailedIgr12)
        if(drinkDetailedMsr12.text == "") (drinkDetailedMsr12.parent as ViewGroup).removeView(drinkDetailedMsr12)
        if(drinkDetailedIgr13.text == "") (drinkDetailedIgr13.parent as ViewGroup).removeView(drinkDetailedIgr13)
        if(drinkDetailedMsr13.text == "") (drinkDetailedMsr13.parent as ViewGroup).removeView(drinkDetailedMsr13)
        if(drinkDetailedIgr14.text == "") (drinkDetailedIgr14.parent as ViewGroup).removeView(drinkDetailedIgr14)
        if(drinkDetailedMsr14.text == "") (drinkDetailedMsr14.parent as ViewGroup).removeView(drinkDetailedMsr14)
        if(drinkDetailedIgr15.text == "") (drinkDetailedIgr15.parent as ViewGroup).removeView(drinkDetailedIgr15)
        if(drinkDetailedMsr15.text == "") (drinkDetailedMsr15.parent as ViewGroup).removeView(drinkDetailedMsr15)

    }


    //getting drinks
    fun getDrink(): Drink {
        val drink = arguments?.getSerializable(DrinkDetailFragment.ARG_DRINK) as Drink?
        if(drink == null){
            throw NullPointerException("Articles list can not be null")
        }

        return drink
    }


}