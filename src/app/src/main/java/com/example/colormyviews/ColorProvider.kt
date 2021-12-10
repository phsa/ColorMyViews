package com.example.colormyviews

import kotlin.math.abs
import kotlin.math.floor

class ColorProvider {

    companion object {
        private const val hexRange = "0123456789ABCDEF"
        fun randomHexColor(): String {
            var color = "#"
            for (i in 1..6) {
                color += hexRange[floor((Math.random() * 100) % hexRange.length).toInt()]
            }
            return color
        }

        fun aestheticallyRandomHexColor(): String {
            val hue = getDistributedHue()
            val rgb = hsvToRgb(hue)

            val hexRed = format(Integer.toHexString(rgb.first))
            val hexGreen = format(Integer.toHexString(rgb.second))
            val hexBlue = format(Integer.toHexString(rgb.third))

            return "#$hexRed$hexGreen$hexBlue"
        }

        private fun getDistributedHue(): Double {
            var hue = Math.random()
            hue += 0.618033988749895 //Golden Ratio Conjugate
            hue %= 1
            return hue * 359
        }

        private fun hsvToRgb(hue: Double, saturation: Double = 0.5, value: Double = 0.95): Triple<Int, Int, Int> {
            if (isValidHsv(hue, saturation, value)) {
                val chroma = saturation * value
                val hLine = hue / 60.0
                val aux = chroma * (1 - abs(hLine % 2 - 1))
                val redValue: Double
                val greenValue: Double
                val blueValue: Double
                val m = value - chroma
                when {
                    hLine.toInt() == 1 -> {
                        redValue = chroma + m
                        greenValue = aux + m
                        blueValue = m
                    }
                    hLine.toInt() == 2 -> {
                        redValue = aux + m
                        greenValue = chroma + m
                        blueValue = m
                    }
                    hLine.toInt() == 3 -> {
                        redValue = m
                        greenValue = chroma + m
                        blueValue = aux + m
                    }
                    hLine.toInt() == 4 -> {
                        redValue = m
                        greenValue = aux + m
                        blueValue = chroma + m
                    }
                    hLine.toInt() == 5 -> {
                        redValue = aux + m
                        greenValue = m
                        blueValue = chroma + m
                    }
                    else -> {
                        redValue = chroma + m
                        greenValue = m
                        blueValue = aux + m
                    }
                }

                return Triple(
                    (redValue * 255).toInt(),
                    (greenValue * 255).toInt(),
                    (blueValue * 255).toInt()
                )
            } else {

                throw Exception("Invalid input for HSV color.")
            }
        }

        private fun isValidHsv(hue: Double, saturation: Double, value: Double): Boolean {
            return (0.0 <= hue && hue < 360.0)
                    && (0.0 <= saturation && saturation < 1.0)
                    && (0.0 <= value && value < 1.0)
        }

        private fun format(hexStr: String): String {
            if (hexStr.isEmpty()) return "00"
            if (hexStr.length == 1) return "0$hexStr"
            return hexStr
        }
    }
}