package com.example.project2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_layout.view.*

class MainActivity : AppCompatActivity() {

    val adapter = GroupAdapter<ViewHolder>()
lateinit var activity : AppCompatActivity
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById<RecyclerView>(R.id.rv)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        for (i in 0..2) {
            adapter.add(InnerClass())
        }
        rv.adapter = adapter
        rv.adapter!!.notifyDataSetChanged()
        rv.scheduleLayoutAnimation()
    }

    inner class InnerClass() : Item<ViewHolder>() {
        override fun getLayout(): Int {
            return R.layout.custom_layout
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {

            if (position == 0) {
                viewHolder.itemView.iv.setImageResource(R.drawable.image1)
                viewHolder.itemView.tv.setText(R.string.t1)

                navigate(viewHolder.itemView.iv,"first")

            }

            if (position == 1) {
                viewHolder.itemView.iv.setImageResource(R.drawable.image2)
                viewHolder.itemView.tv.setText(R.string.t2)
                navigate(viewHolder.itemView.iv,"second")

            }
                if (position == 2) {
                    viewHolder.itemView.iv.setImageResource(R.drawable.image3)
                    viewHolder.itemView.tv.setText( R.string.t3)
                    navigate(viewHolder.itemView.iv,"third")
                }
            }
        }

    private fun navigate(iv: ImageView, s: String) {

        when(s ) {
            "first" -> activity =  productd()
            "second" -> activity =  productd2()
            else -> activity =  productd3()
        }

         iv.setOnClickListener {
             val animation = AnimationUtils.loadAnimation(this, R.anim.slide_right)
             imageView10.startAnimation(animation)

            var int = Intent( iv.context,
                activity::class.java)
            val bundle =
                ActivityOptionsCompat.makeCustomAnimation(
                    iv.context ,
                    R.anim.fade_in, R.anim.fade_out
                ).toBundle()

            startActivity(int,bundle)
        }
    }
}

