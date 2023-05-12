package com.example.mathgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var txt_1: TextView
    lateinit var edt: EditText
    lateinit var score: TextView
    lateinit var ofScore: TextView
    lateinit var totalScore: TextView

    var count = 0
    var correct = 0
    var total = 0


    var number1 = 0
    var number2 = 0
    var operator = 0
    var answer = 0

    var userEnterAnswer = 0



    fun screenToast() {
        when (operator) {
            0 -> {
                answer = number1 + number2
                txt_1.text = "$number1 + $number2"
            }
            1 -> {
                if (number1 > number2) {
                    answer = number1 - number2
                    txt_1.text = "$number1 - $number2"
                } else {
                    random()
                    screenToast()
                }
            }
            2 -> {
                answer = number1 * number2
                txt_1.text = "$number1 * $number2"
            }
            3 -> {
                try {
                    if (number1 >= number2) {
                        answer = number1 / number2
                        txt_1.text = "$number1 / $number2"
                    }
                } catch (e: Exception) {
                    random()
                    screenToast()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_1 = findViewById(R.id.txt_1)
        score = findViewById(R.id.score)
        ofScore = findViewById(R.id.ofScore)
        totalScore = findViewById(R.id.totalScore)

        random()
        screenToast()


    }


    fun random() {
        operator = Random.nextInt(4)
        when (operator) {
            0 -> {
                number1 = Random.nextInt(35)
                number2 = Random.nextInt(35)
            }
            1 -> {
                number1 = Random.nextInt(35)
                number2 = Random.nextInt(number1)
            }
            2 -> {
                number1 = Random.nextInt(10)
                number2 = Random.nextInt(10)
            }
            3 -> {
                number2 = Random.nextInt(9) + 1 // Avoid division by zero
                number1 = number2 * Random.nextInt(10)
            }
        }
    }


}
