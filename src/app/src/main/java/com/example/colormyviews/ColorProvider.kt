package com.example.colormyviews

import kotlin.math.floor

class ColorProvider {

    companion object {
        private const val hexRange = "0123456789ABCDEF"
        fun hexColor(): String {
            var color = "#"
            for (i in 1..6) {
                color += hexRange[floor((Math.random() * 100) % hexRange.length).toInt()]
            }
            return color
        }
    }
}