package com.example.user.dajaihuai

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class MainFragment(private val index:Int,private val color:Int) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false)
//        val ivPhoto:ImageView = v.findViewById(R.id.photo)
//      v.text_view.text = "Fragment $index"
        var button:Button  = v.findViewById(R.id.button3)
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        val mimeType = "audio/*"
        val packageManager = activity!!.packageManager

        button.setOnClickListener(View.OnClickListener {

            intent.type = mimeType
            val list: List<ResolveInfo> = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            if (list.isNotEmpty()) { // 如果有可用的Activity
                val picker = Intent(Intent.ACTION_GET_CONTENT)
                picker.putExtra(Intent.EXTRA_LOCAL_ONLY, false)
                picker.type = mimeType
                // 使用Intent Chooser
                val destIntent = Intent.createChooser(picker, "選取MP3音樂")
                startActivityForResult(destIntent, 100)
            } else { // 沒有可用的Activity
                Toast.makeText(activity,"沒東西",Toast.LENGTH_SHORT).show()
            }

        })
        Toast.makeText(this.context,"$index", Toast.LENGTH_SHORT).show()
        v.setBackgroundColor(resources.getColor(color))
        return v
    }
}

