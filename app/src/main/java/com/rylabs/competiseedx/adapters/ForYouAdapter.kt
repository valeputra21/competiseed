package com.rylabs.competiseedx.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.models.EventModel
import com.rylabs.competiseedx.utils.CurrencyUtil

class ForYouAdapter(
    private val mContext: Context,
    private val listEvent: ArrayList<EventModel>,
    private val listener: OnInteractionListener
) : RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    interface OnInteractionListener {
        fun onSelectedForYou(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_for_you, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        Glide.with(mContext)
            .load(mContext.resources.getDrawable(R.drawable.banner_foryou))
            .placeholder(R.drawable.banner_foryou)
            .into(holder.ivBackground)

        holder.itemView.setOnClickListener { listener.onSelectedForYou(position) }

        holder.tvTitle.text = listEvent[position].title
        holder.tvDate.text = listEvent[position].dateDisplay
        holder.tvPrice.text = listEvent[position].price?.let { CurrencyUtil.format(it) }
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var ivBackground: ImageView = itemView.findViewById(R.id.iv_background)
        internal var tvTitle: TextView = itemView.findViewById(R.id.tv_for_you_title)
        internal var tvDate: TextView = itemView.findViewById(R.id.tv_for_you_date)
        internal var tvPrice: TextView = itemView.findViewById(R.id.tv_for_you_price)

    }

    private fun setMargins(
        v: View,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        if (v.layoutParams is MarginLayoutParams) {
            val p = v.layoutParams as MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            v.requestLayout()
        }
    }

}