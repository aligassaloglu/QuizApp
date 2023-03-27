package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        var questionsAll = Constants.getQuestions()
        Log.i("Questions", "${questionsAll.size}")

        val currentPosition = 1
        val question: Question ? = questionsAll[currentPosition-1]

        progressBar.progress = currentPosition
        text_progress.text = "$currentPosition/${progressBar.max}"

        tv_question.text = question!!.questionText
        img_question.setImageResource(question.image)
        question_option_one.text = question.optionOne
        question_option_two.text = question.optionTwo
        question_option_three.text = question.optionThree
        question_option_four.text = question.optionFour
    }
}