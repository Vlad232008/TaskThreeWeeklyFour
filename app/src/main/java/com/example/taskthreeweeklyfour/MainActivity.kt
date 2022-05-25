package com.example.taskthreeweeklyfour

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.marginEnd
import com.bumptech.glide.Glide
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    val faker = Faker.instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChtoEtoTakoe()
    }

    private fun ChtoEtoTakoe() {
        val linearLayoutHor = LinearLayout(this)
        linearLayoutHor.orientation = LinearLayout.VERTICAL

        val layoutManager: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        layoutManager.setMargins(10, 10, 10, 0)
        layoutManager.weight = 1F
        val linearlayoutManager: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        linearlayoutManager.setMargins(10, 0, 10, 10)
        linearlayoutManager.weight = 1F
        val scrollView: ScrollView = findViewById(R.id.scrollView)
        for (i in 1..100) {
            val cardView = CardView(this)
            cardView.radius = 15f
            cardView.setCardBackgroundColor(Color.parseColor("#FF7145"))
            cardView.setContentPadding(10,10,10,10)
            cardView.layoutParams = layoutManager
            cardView.cardElevation = 30f
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.VERTICAL
            /*val image = ImageView(this)*/
            val username = TextView(this)
            val message = TextView(this)
            username.text = faker.name().name()
            username.layoutParams = layoutManager
            username.typeface = Typeface.SERIF
            username.gravity = Gravity.START
            username.textSize = 16F
            username.setPadding(5, 5, 5, 5)
            username.setTextColor(Color.BLACK)
            username.setBackgroundColor(Color.parseColor("#FF7145"))

            message.text = faker.company().name()

            message.typeface = Typeface.SERIF
            message.gravity = Gravity.START
            message.textSize = 12F
            message.setTextColor(Color.GRAY)
            message.setBackgroundColor(Color.parseColor("#FF7145"))
            message.layoutParams = linearlayoutManager
            message.setPadding(5, 5, 5, 5)
            linearLayout.addView(username)
            linearLayout.addView(message)
            cardView.addView(linearLayout)
            linearLayoutHor.addView(cardView)
            //linearLayoutHor.addView(linearLayout)
        }
        scrollView.addView(linearLayoutHor)
    }
}