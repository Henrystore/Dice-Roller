package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Disc Rolled!",Toast.LENGTH_LONG).show()
            rollDice()
        }

    }

    private fun rollDice() {
        val dice = Dice (6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val luckyTextView: TextView = findViewById(R.id.textView2)
        val luckyNumber = 6
        if (luckyNumber == diceRoll){
            luckyTextView.text = getString(R.string.luckynumber)
        }else{
            luckyTextView.text = ""
        }

        val diceImage = findViewById<ImageView>(R.id.imageView)
       /* if (diceRoll == 1) {
            diceImage.setImageResource(R.drawable.dice1)
        }else if (diceRoll == 2) {
            diceImage.setImageResource(R.drawable.dice2)
        }*/

        val drawableResource = when(diceRoll){
            1 ->(R.drawable.dice1)
            2 ->(R.drawable.dice2)
            3 ->(R.drawable.dice3)
            4 ->(R.drawable.dice4)
            5 ->(R.drawable.dice5)
            else ->(R.drawable.dice6)
            
        }
        diceImage.setImageResource(drawableResource)
    }
}

private class Dice(val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }

}
