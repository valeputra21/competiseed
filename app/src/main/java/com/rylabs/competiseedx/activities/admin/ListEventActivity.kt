package com.rylabs.competiseedx.activities.admin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.adapters.ForYouAdapter
import com.rylabs.competiseedx.adapters.YourEventAdapter
import com.rylabs.competiseedx.app.RyRouter
import com.rylabs.competiseedx.bottomsheet.ParticipantsBottomSheet
import com.rylabs.competiseedx.bottomsheet.PaymentMethodBottomSheet
import com.rylabs.competiseedx.models.EventModel


class ListEventActivity : AppCompatActivity(), YourEventAdapter.OnInteractionListener {

    private lateinit var router: RyRouter
    private lateinit var rvEvent: RecyclerView
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var listEvent: ArrayList<EventModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.admin_activity_list_event)

        rvEvent = findViewById(R.id.rv_event)

        router = RyRouter(this)


        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabaseReference = mFirebaseInstance.getReference("events")
        mDatabaseReference.child("data_event").addValueEventListener(object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@ListEventActivity,
                    error.details + " " + error.message, Toast.LENGTH_LONG
                ).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listEvent = ArrayList()
                for (mDataSnapshot in dataSnapshot.children) {
                    val event = mDataSnapshot.getValue(EventModel::class.java)
//                    event?.eventId = mDataSnapshot.key
                    event?.let { listEvent.add(it) }

                    // for you
                    val adapterYourEvent = YourEventAdapter(this@ListEventActivity, listEvent, this@ListEventActivity)
                    rvEvent.setHasFixedSize(true)
                    rvEvent.overScrollMode = View.OVER_SCROLL_NEVER
                    rvEvent.layoutManager = LinearLayoutManager(this@ListEventActivity, LinearLayoutManager.VERTICAL, false)
                    rvEvent.adapter = adapterYourEvent
                    adapterYourEvent.notifyDataSetChanged()
                }
            }
        })
    }

    override fun onSelected(position: Int) {
        val participantBottomSheet = ParticipantsBottomSheet()
        supportFragmentManager.let { participantBottomSheet.show(it, "") }
    }

}