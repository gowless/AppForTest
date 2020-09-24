package com.example.appfortest.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appfortest.R
import com.example.appfortest.adapters.DrinkAdapter
import com.example.appfortest.utils.Utils
import com.studio.quatro.cucktaleApp.entities.Drink
import kotlinx.android.synthetic.main.fragment_drink_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException


class DrinkListFragment : Fragment() {

    companion object {

        private val ARG_LIST = "arg_list"
        public val GET_DETAIL = "detail"
        public val GET_RANDOM = "random"

        //creating the new instance
        fun newInstance(drinks: ArrayList<Drink>) =
            DrinkListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, drinks)
                }
            }
    }


    var listener : OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drinks = getDrinkList()

        activity?.let { context ->
            val adapter = DrinkAdapter(context, drinks)
            adapter.setOnItemClickListener { position ->
                listener?.onFragmentInteraction(GET_DETAIL, drinks[position].idDrink)
            }

            recyclerView.layoutManager = GridLayoutManager(context, Utils.calculateNoOfColumns(context))
            recyclerView.adapter = adapter

            //random drink button
            btnRandomDrink.setOnClickListener {
                listener?.onFragmentInteraction(GET_RANDOM)
            }
        }




    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is DrinkListFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implement DrinkListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()

        listener = null
    }

    private fun getDrinkList(): ArrayList<Drink> {
        return arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>? ?: throw NullPointerException("Articles list can not be null")
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(query: String? = GET_DETAIL, index: Int? = null)
    }


}
