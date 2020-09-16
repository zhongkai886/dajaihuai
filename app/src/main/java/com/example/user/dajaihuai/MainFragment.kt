package com.example.user.dajaihuai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainFragment(private val index:Int,private val color:Int) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false)
//        val ivPhoto:ImageView = v.findViewById(R.id.photo)
//      v.text_view.text = "Fragment $index"
        Toast.makeText(this.context,"$index", Toast.LENGTH_SHORT).show()
        v.setBackgroundColor(resources.getColor(color))
        return v
    }
}

