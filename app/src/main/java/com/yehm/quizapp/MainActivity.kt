package com.yehm.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yehm.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDecorFitSystem()
        initListeners()

    }

    private fun setDecorFitSystem() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    private fun initListeners() {
        binding.buttonStart.setOnClickListener {
            if (binding.editTextName.text.toString().isEmpty()) {
                Toast.makeText(this, resources.getString(R.string.on_boarding_enter_name_text), Toast.LENGTH_SHORT).show()
            } else {
                startQuiz()
            }
        }
    }

    private fun startQuiz() {
        val intent = Intent(this, QuizQuestionsActivity::class.java)
        startActivity(intent)
        finish()
    }
}