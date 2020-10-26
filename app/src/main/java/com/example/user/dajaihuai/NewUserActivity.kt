package com.example.user.dajaihuai

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewUserActivity :AppCompatActivity(){
    private lateinit var editAccount: EditText
    private lateinit var editAppName: EditText
    private lateinit var editPassword: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        editAppName = findViewById(R.id.edit_app)
        editAccount = findViewById(R.id.edit_account)
        editPassword = findViewById(R.id.edit_password)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editAppName.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editAppName.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}