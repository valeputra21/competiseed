package com.rylabs.competiseedx.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.adapters.ForYouAdapter
import com.rylabs.competiseedx.adapters.TicketAdapter

class TicketFragment : Fragment(), TicketAdapter.OnInteractionListener {

    lateinit var rvTicket: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_ticket, container, false)

        rvTicket = root.findViewById(R.id.rv_ticket)

        // for you
        val ticketAdapter = context?.let { TicketAdapter(it, this@TicketFragment) }
        rvTicket.setHasFixedSize(true)
        rvTicket.overScrollMode = View.OVER_SCROLL_NEVER
        rvTicket.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvTicket.adapter = ticketAdapter
        ticketAdapter?.notifyDataSetChanged()


        return root
    }

    override fun onSelected(position: Int) {
        TODO("Not yet implemented")
    }
}