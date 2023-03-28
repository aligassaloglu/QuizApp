package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val correctAns = intent.getStringExtra(Constants.CORRECT_ANS)
        val totalQ = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val user = intent.getStringExtra(Constants.USER_NAME)
        tv_score.text = "${correctAns}/${totalQ}"
        tv_username.text = "$user"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}