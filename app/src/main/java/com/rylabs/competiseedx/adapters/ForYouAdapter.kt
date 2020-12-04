package com.rylabs.competiseedx.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rylabs.competiseedx.R

class ForYouAdapter(
    private val mContext: Context,
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
//        if (position == 0) {
//            setMargins(holder.itemView, 40, 16, 20, 0);
//        }
        Glide.with(mContext)
            .load(mContext.resources.getDrawable(R.drawable.banner_foryou))
            .placeholder(R.drawable.banner_foryou)
            .into(holder.ivBackground)

        holder.itemView.setOnClickListener { listener.onSelectedForYou(position) }
    }

    override fun getItemCount(): Int {
        return 6
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivBackground: ImageView = itemView.findViewById(R.id.iv_background)

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