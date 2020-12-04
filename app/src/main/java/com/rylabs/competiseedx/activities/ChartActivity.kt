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
import androidx.cardview.widget.CardView
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.app.RyRouter
import com.rylabs.competiseedx.utils.CurrencyUtil


class ChartActivity : AppCompatActivity() {

    private lateinit var btnPayNow: Button
    private lateinit var router: RyRouter
    private lateinit var btnAdd: CardView
    private lateinit var btnMin: CardView
    private lateinit var tvItemCount: TextView
    private var itemCount = 1

    private lateinit var tvTotalPay: TextView
    private var priceDefault = 50500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chart)
        btnAdd = findViewById(R.id.btn_add)
        btnMin = findViewById(R.id.btn_min)
        tvItemCount = findViewById(R.id.tv_item_count)
        tvTotalPay = findViewById(R.id.tv_total_pay_amount)

        router = RyRouter(this)

        btnPayNow = findViewById(R.id.btn_pay_now)


        btnPayNow.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("total_pay", tvTotalPay.text.toString())
            bundle.putString("count_ticket", itemCount.toString())
            router.openActivity(PaymentActivity::class.java, bundle)
        }

        btnAdd.setOnClickListener {
            itemCount++
            tvItemCount.text = itemCount.toString()

            tvTotalPay.text = updateTotalPayment(itemCount * priceDefault)
        }

        btnMin.setOnClickListener {
            itemCount--

            if (itemCount < 0) {
                itemCount = 0
            }
            tvItemCount.text = itemCount.toString()

            tvTotalPay.text = updateTotalPayment(itemCount * priceDefault)
        }

    }

    private fun updateTotalPayment(totalPay: Int) : String{
        return CurrencyUtil.format(totalPay)
    }

}