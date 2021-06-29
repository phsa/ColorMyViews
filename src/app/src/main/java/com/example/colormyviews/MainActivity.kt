package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(text_boxOne, text_boxTwo, text_boxThree, text_boxFour, text_boxFive)

        for (v in clickableViews) {
            v.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            // Boxes using Color class colors for background
            R.id.text_boxOne -> view.setBackgroundColor(Color.DKGRAY)
            R.id.text_boxTwo -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.text_boxThree -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.text_boxFour -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.text_boxFive -> view.setBackgroundResource(android.R.color.holo_green_light)
        }
    }
}