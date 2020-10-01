package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat

class productd2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productd2)

        val imageView16 = findViewById<ImageView>(R.id.imageView16)
        val parent = findViewById<ConstraintLayout>(R.id.parent2)

        imageView16.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.fade_out)
            parent.startAnimation(anim)
            onBackPressed()
        }


        val button = findViewById<ImageView>(R.id.imageView21)
        button.setOnClickListener {
            val intent = Intent(this, productd::class.java)
            val bundle =
                ActivityOptionsCompat.makeCustomAnimation(
                    this ,
                    R.anim.fade_in, R.anim.fade_out
                ).toBundle()

            startActivity(intent,bundle)
        }

        val button2 = findViewById<ImageView>(R.id.imageView24)
        button2.setOnClickListener {
            val intent = Intent(this, productd3::class.java)
            val bundle =
                ActivityOptionsCompat.makeCustomAnimation(
                    this ,
                    R.anim.fade_in, R.anim.fade_out
                ).toBundle()

            startActivity(intent,bundle)
        }

        val button3 = findViewById<ImageView>(R.id.imageView16)
        button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle =
                ActivityOptionsCompat.makeCustomAnimation(
                    this ,
                    R.anim.fade_in, R.anim.fade_out
                ).toBundle()

            startActivity(intent,bundle)
        }
    }
}