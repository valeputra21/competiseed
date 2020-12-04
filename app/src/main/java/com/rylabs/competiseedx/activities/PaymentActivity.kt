package com.rylabs.competiseedx.activities

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.adapters.PaymentMethodAdapter
import com.rylabs.competiseedx.app.RyRouter
import com.rylabs.competiseedx.bottomsheet.PaymentMethodBottomSheet


class PaymentActivity : AppCompatActivity(), PaymentMethodAdapter.OnInteractionListener {

    private lateinit var btnConfirm: Button
    private lateinit var router: RyRouter
    private lateinit var payMethodBottomSheet: PaymentMethodBottomSheet
    private lateinit var btnChangePayMethod: Button
    private lateinit var tvPayMethod: TextView
    private lateinit var ivPayMethod: ImageView
    private lateinit var tvTotalPay: TextView
    private lateinit var tvCountTicket: TextView
    private lateinit var tvTotalPayFinal: TextView
    private var selectedPayment = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_payment)
        btnChangePayMethod = findViewById(R.id.btn_change_pay_method)
        tvPayMethod = findViewById(R.id.tv_pay_method)
        ivPayMethod = findViewById(R.id.iv_pay_method)
        tvTotalPay = findViewById(R.id.tv_total_pay)
        tvCountTicket = findViewById(R.id.tv_count_ticket)
        tvTotalPayFinal = findViewById(R.id.tv_total_pay_final)

        router = RyRouter(this)

        btnConfirm = findViewById(R.id.btn_confirm)

        btnConfirm.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("total_pay", tvTotalPayFinal.text.toString())

            if (selectedPayment == 0) {
                router.openActivity(PaymentWaitingActivity::class.java, bundle)
            } else {
                router.openActivity(InvoiceActivity::class.java, bundle)
            }

        }

        btnChangePayMethod.setOnClickListener { dialogSelectPayMethod() }


        val mbundle = intent.extras
        tvTotalPay.text = mbundle?.getString("total_pay")
        tvCountTicket.text = mbundle?.getString("count_ticket") + " tickets"
        tvTotalPayFinal.text = mbundle?.getString("total_pay")
    }

    private fun dialogSelectPayMethod() {
        payMethodBottomSheet = PaymentMethodBottomSheet(this)
        supportFragmentManager.let { payMethodBottomSheet.show(it, "") }
    }

    override fun onSelectedPaymentMethod(position: Int) {
        payMethodBottomSheet.dismiss()

        if (position == 0) {
            selectedPayment = 0
            tvPayMethod.text = "Transfer VA Bank Jago"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Glide.with(this)
                    .load(resources.getDrawable(R.drawable.ic_pay_transfer, null))
                    .placeholder(R.drawable.ic_pay_transfer)
                    .into(ivPayMethod)
            }
        } else {
            selectedPayment = 1
            tvPayMethod.text = "Gopay"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Glide.with(this)
                    .load(resources.getDrawable(R.drawable.ic_gopay, null))
                    .placeholder(R.drawable.ic_gopay)
                    .into(ivPayMethod)
            }
        }

    }

}