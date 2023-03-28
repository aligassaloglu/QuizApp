package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mcurrentPosition:Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAns : Int = 0
    private var mUsername : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
        setQuestion()
        setDefauultOptionView()

        question_option_one.setOnClickListener(this)
        question_option_two.setOnClickListener(this)
        question_option_three.setOnClickListener(this)
        question_option_four.setOnClickListener(this)
        submit_question.setOnClickListener(this)
    }
    private fun setQuestion(){

        val question: Question ? = mQuestionsList!![mcurrentPosition-1]

        setDefauultOptionView()

        if (mcurrentPosition == mQuestionsList!!.size){
            submit_question.text = "FINISH"
        }else{
            submit_question.text = "SUBMIT"
        }

        progressBar.progress = mcurrentPosition
        text_progress.text = "$mcurrentPosition/${progressBar.max}"
        tv_question.text = question!!.questionText
        img_question.setImageResource(question.image)
        question_option_one.text = question.optionOne
        question_option_two.text = question.optionTwo
        question_option_three.text = question.optionThree
        question_option_four.text = question.optionFour
    }

    private fun setDefauultOptionView(){
        val options = arrayListOf<TextView>()
        options.add(0,question_option_one)
        options.add(1,question_option_two)
        options.add(2,question_option_three)
        options.add(3,question_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.question_option_one->{
                selectedOptionView(question_option_one,1)
            }
            R.id.question_option_two->{
                selectedOptionView(question_option_two,2)
            }
            R.id.question_option_three->{
                selectedOptionView(question_option_three,3)
            }
            R.id.question_option_four->{
                selectedOptionView(question_option_four,4)
            }
            R.id.submit_question->{
                if(mSelectedOptionPosition == 0){
                    mcurrentPosition++
                    when{
                        mcurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else->{
//                            Toast.makeText(this,"Completed Sccuessfully",Toast.LENGTH_SHORT)
                            val intent = Intent(this,ActivityResult::class.java)
                            intent.putExtra(Constants.USER_NAME,mUsername)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size.toString())
                            intent.putExtra(Constants.CORRECT_ANS, mCorrectAns.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mcurrentPosition-1)
                    if(question!!.optionCorrect != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAns++
                    }
                    answerView(question.optionCorrect, R.drawable.correct_option_border_bg)

                    if (mcurrentPosition == mQuestionsList!!.size){
                        submit_question.text = "FINISH"
                    }else{
//                        mcurrentPosition++
                        submit_question.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(ans : Int, drawableView : Int){
        when(ans){
            1 -> {
                question_option_one.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                question_option_two.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                question_option_three.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                question_option_four.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv : TextView, selectedId:Int){
        setDefauultOptionView()

        mSelectedOptionPosition = selectedId

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }
}