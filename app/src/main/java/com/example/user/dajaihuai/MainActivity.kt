package com.example.user.dajaihuai

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.stetho.Stetho
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private lateinit var buttona:Button
    private lateinit var buttonb:Button
    private val firstFragment = MainFragment(1,R.color.colorAccent)
    private val secondFragment = MainFragment(2,R.color.colorPrimaryDark)
    private var job:Job?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this);

//        val userData:UserData? = null
        var userData:ArrayList<UserData> = ArrayList()

//        userData.add(UserData(12,"facebook","account","password"))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = UserListAdapter(this)
        adapter.setUsers(userData)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val db = Appdatabase(this)

        job = GlobalScope.launch(Dispatchers.IO) {
//            db.getNotesDao().getAll()
//            db.getUsersDao().insertAll(userData)
//            db.getNotesDao().delete(userData)
        }



//        db.getNotesDao().insertAll(UserData(1,"aaa","aaa","vvvv"))

//        buttona = findViewById<Button>(R.id.first_fragment)
//        buttonb = findViewById<Button>(R.id.second_fragment)

        println("============")
        permission()

//        addFragment(firstFragment)
//        addFragment(secondFragment)
//        buttona.setOnClickListener {
//            replaceFragment(firstFragment)
//        }
//        buttonb.setOnClickListener {
//            replaceFragment(secondFragment)
//        }
    }

//    private fun addFragment(f: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_container, f)
//        transaction.commit()
//    }
//
//    private fun replaceFragment(f : Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragment_container, f)
//        transaction.commit()
//
//    }
    fun permission(){
        ActivityCompat.requestPermissions(this, arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE), 0)
    }


}
