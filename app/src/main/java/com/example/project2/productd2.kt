package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class productd2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productd2)


        val button = findViewById<ImageView>(R.id.imageView21)
        button.setOnClickListener {
            val intent = Intent(this, productd::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<ImageView>(R.id.imageView24)
        button2.setOnClickListener {
            val intent = Intent(this, productd3::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<ImageView>(R.id.imageView16)
        button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}