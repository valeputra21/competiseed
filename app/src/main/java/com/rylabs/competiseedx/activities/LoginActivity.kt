package com.rylabs.competiseedx.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.rylabs.competiseedx.R


class LoginActivity : AppCompatActivity() {

    private lateinit var mIntent: Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val loading = findViewById<ProgressBar>(R.id.loading)

        btnLogin.setOnClickListener {
            loading.visibility = View.VISIBLE
            Handler().postDelayed({
                try {
                    mIntent = Intent(applicationContext, MainActivity::class.java)
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    applicationContext.startActivity(mIntent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                loading.visibility = View.GONE
            }, 200)


        }

    }

}