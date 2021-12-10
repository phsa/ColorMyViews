package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        listOf(
            binding.textBoxOne,
            binding.textBoxTwo,
            binding.textBoxThree,
            binding.textBoxFour,
            binding.textBoxFive,
            binding.containerMain,
            binding.buttonRed,
            binding.buttonYellow,
            binding.buttonGreen
        ).forEach { textBox ->
            textBox.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            // Boxes using Color class colors for background
            R.id.text_boxOne -> view.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
            R.id.text_boxTwo -> view.setBackgroundColor(Color.parseColor(ColorProvider.randomHexColor()))

            // Boxes using Android colors resources for background
            R.id.text_boxThree -> view.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
            R.id.text_boxFour -> view.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
            R.id.text_boxFive -> view.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))

            // Boxes using custom colors for background
            R.id.button_red ->  binding.textBoxThree.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
            R.id.button_yellow -> binding.textBoxFour.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
            R.id.button_green -> binding.textBoxFive.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))

            else -> view.setBackgroundColor(Color.LTGRAY)
        }


    }
}