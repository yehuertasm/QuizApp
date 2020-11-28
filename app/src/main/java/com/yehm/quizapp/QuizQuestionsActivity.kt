package com.yehm.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yehm.quizapp.data.Constants
import com.yehm.quizapp.data.Question
import com.yehm.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionsList = Constants.getQuestions()

        val currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]


        binding.progressBar.progress = currentPosition
        binding.textViewProgress.text = "$currentPosition/${binding.progressBar.max}"
        binding.textViewQuestion.text = question.question
        binding.progressBar.progress = currentPosition
        binding.imageViewFlag.setImageResource(question.image)
        binding.textViewFirstOption.text = question.optionOne
        binding.textViewSecondOption.text = question.optionTwo
        binding.textViewThirdOption.text = question.optionThree
        binding.textViewFourthOption.text = question.optionFour
    }
}