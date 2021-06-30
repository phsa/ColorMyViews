package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        val clickableViews: List<View> = listOf(
            binding.textBoxOne,
            binding.textBoxTwo,
            binding.textBoxThree,
            binding.textBoxFour,
            binding.textBoxFive,
            binding.containerMain,
            binding.buttonRed,
            binding.buttonYellow,
            binding.buttonGreen
        )

        for (v in clickableViews) {
            v.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            // Boxes using Color class colors for background
            R.id.text_boxOne -> view.setBackgroundColor(Color.DKGRAY)
            R.id.text_boxTwo -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android colors resources for background
            R.id.text_boxThree -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.text_boxFour -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.text_boxFive -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.button_red -> binding.textBoxThree.setBackgroundResource(R.color.red)
            R.id.button_yellow -> binding.textBoxFour.setBackgroundResource(R.color.yellow)
            R.id.button_green -> binding.textBoxFive.setBackgroundResource(R.color.green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}