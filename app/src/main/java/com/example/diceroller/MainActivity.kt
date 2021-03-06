package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diceImageView1 = findViewById<ImageView>(R.id.imageView)
        val diceImageView2 = findViewById<ImageView>(R.id.imageView2)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(diceImageView1)
            rollDice(diceImageView2)
        }

        // Do a dice roll when the app starts
        rollDice(diceImageView1)
        rollDice(diceImageView2)
    }

    private fun rollDice(diceImageView: ImageView) {
        val diceRoll = Dice(6).roll()

        val drawableResouce = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImageView.setImageResource(drawableResouce)
        diceImageView.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}