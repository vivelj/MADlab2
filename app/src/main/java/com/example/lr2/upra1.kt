package com.example.lr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class upra1 : AppCompatActivity(), View.OnClickListener {

    private lateinit var questionView : TextView
    private lateinit var answerInput: EditText
    private lateinit var resultView: TextView
    private lateinit var submitButton: Button

    private var questionCount = 0
    private var correctAnswerCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upra1)

        questionView= findViewById(R.id.uslovie1)
        answerInput = findViewById(R.id.otvet1)
        resultView = findViewById(R.id.trueorfalse1)
        submitButton = findViewById(R.id.reshit1)

        submitButton.setOnClickListener(this)
        showNextQuestion()

        val back: Button = findViewById(R.id.back1)
        back.setOnClickListener {
            val nextpage = Intent(this, SecondActivity::class.java)
            startActivity(nextpage)
            finish()
        }
    }

    private fun showNextQuestion() {
        if (questionCount < 20) {
            val number1 = Random.nextInt(1, 11)
            val number2 = Random.nextInt(1, 11)
            val question = "$number1 x $number2 = "

            questionView.text = question
            answerInput.text.clear()

            questionCount++
        } else {
            val percentage = (correctAnswerCount.toFloat() / 20) * 100
            resultView.text = "Результат: $correctAnswerCount правильных ответов из 20 (${percentage.toInt()}%)"
            answerInput.isEnabled = false
            submitButton.isEnabled = false
        }
    }

    override fun onClick(view: View?) {
        val answer = answerInput.text.toString().toIntOrNull()

        if (answer != null) {
            val numbers = questionView.text.split(" x ")
            val number1 = numbers[0].trim().toIntOrNull()
            val number2 = numbers[1].replace(" =", "").trim().toIntOrNull()

            if (number1 != null && number2 != null) {
                val correctAnswer = number1 * number2

                if (answer == correctAnswer) {
                    resultView.text = "Правильный ответ!"
                    correctAnswerCount++
                } else {
                    resultView.text = "Неверный ответ."
                }

                showNextQuestion()
            } else {
                resultView.text = "Произошла ошибка при получении вопроса."
            }
        } else {
            resultView.text = "Пожалуйста, введите число в поле ответа."
        }
    }
}