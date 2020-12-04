package com.rylabs.competiseedx.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.app.RyRouter


class InvoiceActivity : AppCompatActivity() {

    private lateinit var btnBackToHome: Button
    private lateinit var router: RyRouter
    private lateinit var tvTotalPay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_invoice)

        tvTotalPay = findViewById(R.id.tv_total_pay)

        router = RyRouter(this)

        btnBackToHome = findViewById(R.id.btn_back_to_home)


        val mbundle = intent.extras

        tvTotalPay.text = mbundle?.getString("total_pay")

        btnBackToHome.setOnClickListener { router.openActivityAndClearAllPrevious(MainActivity::class.java) }

    }

}