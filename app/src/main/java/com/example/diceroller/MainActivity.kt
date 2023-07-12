package com.example.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnRoll: Button
    private lateinit var ivDice: ImageView


    // Instead calling main(), Android system calls the onCreate() in MainActivity when app is opened
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logging()

        // Setting layout to activity_main.xml
        setContentView(R.layout.activity_main)

        btnRoll = findViewById(R.id.btn_roll)

        // Click Listener
        btnRoll.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }

        // do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the text view with result
     */
    private fun rollDice() {
        ivDice = findViewById(R.id.iv_dice)
        val imageResource = when(Dice(6).roll()) {
            // Set image using setImageResource
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        ivDice.setImageResource(imageResource)
    }
}

fun logging() {
    Log.v("Main Activity", "Hello, Bug!")
}