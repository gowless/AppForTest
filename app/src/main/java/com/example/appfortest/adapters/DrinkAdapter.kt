package com.example.appfortest.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.appfortest.R
import com.example.appfortest.utils.GlideApp
import com.studio.quatro.cucktaleApp.entities.Drink
import kotlinx.android.synthetic.main.item_drink.view.*

class DrinkAdapter(val context: Context, var drinks: ArrayList<Drink>) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(click: ((index: Int) -> Unit)){
        this.itemClickListener = click
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return ViewHolder(view)


    }

    override fun getItemCount() = drinks.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(context, drinks[position], itemClickListener)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.drinkName.text = drink.strDrink


            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 6f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.setColorSchemeColors(Color.parseColor("#FF6333"))
            circularProgressDrawable.start()

            GlideApp.with(context)
                .load(drink.strDrinkThumb)
                .centerCrop()
                .placeholder(circularProgressDrawable)
                .into(itemView.drinkImg)

            if (itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }


    }
}
