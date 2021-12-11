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
            binding.textBoxSix,
            binding.textBoxSeven,
            binding.textBoxEight,
            binding.textBoxNine,
            binding.textBoxTen,
            binding.textBoxEleven,
            binding.textBoxTwelve,
            binding.containerMain,
        ).forEach { textBox ->
            textBox.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            R.id.container_main -> view.setBackgroundColor(Color.LTGRAY)
            else -> view.setBackgroundColor(Color.parseColor(ColorProvider.aestheticallyRandomHexColor()))
        }


    }
}