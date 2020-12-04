package com.rylabs.competiseedx.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rylabs.competiseedx.R
import org.w3c.dom.Text

class PaymentMethodAdapter(
    private val mContext: Context,
    private val listener: OnInteractionListener
) : RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {

    interface OnInteractionListener {
        fun onSelectedPaymentMethod(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_payment_method2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        if (position == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Glide.with(mContext)
                .load(mContext.resources.getDrawable(R.drawable.ic_pay_transfer, null))
                .placeholder(R.drawable.ic_pay_transfer)
                .into(holder.ivPayMethod)
            }
            holder.tvPayMethod.text = "Transfer VA Bank Jago"
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Glide.with(mContext)
                    .load(mContext.resources.getDrawable(R.drawable.ic_gopay, null))
                    .placeholder(R.drawable.ic_gopay)
                    .into(holder.ivPayMethod)
            }
            holder.tvPayMethod.text = "Gopay"
        }

        holder.itemView.setOnClickListener { listener.onSelectedPaymentMethod(position) }
    }

    override fun getItemCount(): Int {
        return 2
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var ivPayMethod: ImageView = itemView.findViewById(R.id.iv_pay_method)
        internal var tvPayMethod: TextView = itemView.findViewById(R.id.tv_pay_method)
    }

}