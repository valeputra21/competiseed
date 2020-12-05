package com.rylabs.competiseedx.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.activities.admin.CreateEventActivity
import com.rylabs.competiseedx.activities.admin.ListEventActivity
import com.rylabs.competiseedx.app.RyRouter

class AccountFragment : Fragment() {

    private lateinit var btnCreateEvent: Button
    private lateinit var btnListEvent: Button
    private lateinit var router: RyRouter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_account, container, false)

        btnCreateEvent = root.findViewById(R.id.btn_create_competition)
        btnListEvent = root.findViewById(R.id.btn_list_competition)

        router = RyRouter(context)

        btnCreateEvent.setOnClickListener { router.openActivity(CreateEventActivity::class.java) }
        btnListEvent.setOnClickListener { router.openActivity(ListEventActivity::class.java) }

        return root
    }
}