package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_layout.view.*

class MainActivity : AppCompatActivity() {

    val adapter = GroupAdapter<ViewHolder>()

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
                viewHolder.itemView.iv.setOnClickListener {
                    val intent = Intent(viewHolder.itemView.iv.context, productd::class.java)
                    startActivity(intent)
                }
            }

            if (position == 1) {
                viewHolder.itemView.iv.setImageResource(R.drawable.image2)
                viewHolder.itemView.tv.setText(R.string.t2)
                viewHolder.itemView.iv.setOnClickListener {
                    val intent = Intent(viewHolder.itemView.iv.context, productd2::class.java)
                    startActivity(intent)
                }

            }
                if (position == 2) {
                    viewHolder.itemView.iv.setImageResource(R.drawable.image3)
                    viewHolder.itemView.tv.setText( R.string.t3)
                    viewHolder.itemView.iv.setOnClickListener {
                        val intent = Intent(viewHolder.itemView.iv.context, productd3::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

