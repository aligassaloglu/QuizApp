package com.example.quizapp

object Constants{
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,"Argentina",
            "Germany","Poland",
            "Australia",1
        )
        val que2 = Question(2,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,"Argentina",
            "Germany","Poland",
            "Australia",4
        )
        val que3 = Question(3,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,"Argentina",
            "Germany","Poland",
            "Australia",1
        )
        val que4 = Question(4,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,"Argentina",
            "India","Quwait",
            "New Zealand",2
        )
        val que5 = Question(5,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,"Denmark",
            "Germany","Belgium",
            "Australia",3
        )
        val que6 = Question(6,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,"Argentina",
            "Brazil","Poland",
            "Australia",2
        )
        val que7 = Question(7,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,"Argentina",
            "Germany","Poland",
            "Fiji",4
        )
        val que8 = Question(8,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,"Kuwait",
            "Germany","Poland",
            "Australia",1
        )
        val que9 = Question(9,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,"Argentina",
            "Germany","India",
            "Australia",3
        )
        val que10 = Question(10,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,"Poland",
            "Germany","Fiji",
            "Denmark",4
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList
    }
}