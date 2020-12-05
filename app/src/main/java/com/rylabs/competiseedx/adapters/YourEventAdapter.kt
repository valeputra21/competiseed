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

class YourEventAdapter(
    private val mContext: Context,
    private val listEvent: ArrayList<EventModel>,
    private val listener: OnInteractionListener
) : RecyclerView.Adapter<YourEventAdapter.ViewHolder>() {

    interface OnInteractionListener {
        fun onSelected(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.item_your_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

//        Glide.with(mContext)
//            .load(mContext.resources.getDrawable(R.drawable.banner_foryou))
//            .placeholder(R.drawable.banner_foryou)
//            .into(holder.ivBackground)

        holder.tvTitle.text = listEvent[position].title
        holder.tvDate.text = listEvent[position].dateDisplay
        holder.tvOrganzation.text = listEvent[position].organizer

        holder.itemView.setOnClickListener { listener.onSelected(position) }
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var ivBackground: ImageView = itemView.findViewById(R.id.iv_event)
        internal var tvOrganzation: TextView = itemView.findViewById(R.id.tv_organization)
        internal var tvTitle: TextView = itemView.findViewById(R.id.tv_event_title)
        internal var tvDate: TextView = itemView.findViewById(R.id.tv_event_date)
    }



}