package com.example.taskthreeweeklyfour

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    val faker = Faker.instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChtoEtoTakoe()
    }

    private fun ChtoEtoTakoe(){

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        val scrollView: ScrollView = findViewById(R.id.scrollView)
        for (i in 1..100) {
            val username = TextView(this)
            val message = TextView(this)
            if (username.parent != null) {
                (username.parent as ViewGroup).removeView(username)
            }
            if (message.parent != null) {
                (message.parent as ViewGroup).removeView(message)
            }
            username.text = faker.name().name()
            username.typeface = Typeface.SERIF
            username.gravity = Gravity.CENTER
            username.textSize = 24F
            username.setTextColor(Color.BLACK)
            username.setBackgroundColor(Color.BLUE)

            message.text = faker.company().name()
            message.typeface = Typeface.SERIF
            message.gravity = Gravity.CENTER
            message.textSize = 24F
            message.setTextColor(Color.BLACK)
            message.setBackgroundColor(Color.BLUE)
            linearLayout.addView(username)
            linearLayout.addView(message)
        }
        scrollView.addView(linearLayout)
    }
}