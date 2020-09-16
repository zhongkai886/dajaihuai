package com.example.user.dajaihuai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import org.opencv.android.OpenCVLoader
class MainActivity : AppCompatActivity() {
    private lateinit var buttona:Button
    private lateinit var buttonb:Button
    private val firstFragment = MainFragment(1,R.color.colorAccent)
    private val secondFragment = MainFragment(2,R.color.colorPrimaryDark)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttona = findViewById<Button>(R.id.first_fragment)
        buttonb = findViewById<Button>(R.id.second_fragment)

        permission()

        addFragment(firstFragment)
        addFragment(secondFragment)
        buttona.setOnClickListener {
            replaceFragment(firstFragment)
        }
        buttonb.setOnClickListener {
            replaceFragment(secondFragment)
        }
    }

    private fun addFragment(f: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, f)
        transaction.commit()
    }

    private fun replaceFragment(f : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, f)
        transaction.commit()
    }
    fun permission(){
        ActivityCompat.requestPermissions(this, arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE), 0)
    }
}
