package com.example.appfortest.utils

import android.content.Context


class Utils {

    companion object {

        fun calculateNoOfColumns(context: Context): Int {
            val displayMetrics = context.resources.displayMetrics
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density
            return 1
        }

    }



}