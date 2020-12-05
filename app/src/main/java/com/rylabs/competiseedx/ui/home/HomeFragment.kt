package com.rylabs.competiseedx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.activities.ChartActivity
import com.rylabs.competiseedx.activities.DetailEventActivity
import com.rylabs.competiseedx.adapters.CollectionsAdapter
import com.rylabs.competiseedx.adapters.DiscoverAdapter
import com.rylabs.competiseedx.adapters.ForYouAdapter
import com.rylabs.competiseedx.adapters.UpcomingOnlineAdapter
import com.rylabs.competiseedx.app.RyRouter
import com.rylabs.competiseedx.models.EventModel

class HomeFragment : Fragment(), ForYouAdapter.OnInteractionListener,
    CollectionsAdapter.OnInteractionListener, DiscoverAdapter.OnInteractionListener,
    UpcomingOnlineAdapter.OnInteractionListener {


    private lateinit var rvForYou: RecyclerView
    private lateinit var rvCollections: RecyclerView
    private lateinit var rvDiscovers: RecyclerView
    private lateinit var rvUpcomingOnline: RecyclerView
    private lateinit var router: RyRouter
    private lateinit var ivChart: ImageView

    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var listEvent: ArrayList<EventModel>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        router = RyRouter(context)

        ivChart = root.findViewById(R.id.iv_chart)
        rvForYou = root.findViewById(R.id.rv_for_you)
        rvCollections = root.findViewById(R.id.rv_collection)
        rvDiscovers = root.findViewById(R.id.rv_discover)
        rvUpcomingOnline = root.findViewById(R.id.rv_upcoming_online)

        ivChart.setOnClickListener { router.openActivity(ChartActivity::class.java) }


        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabaseReference = mFirebaseInstance.getReference("events")
//        val eventId = mDatabaseReference.push().key
        mDatabaseReference.child("data_event").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listEvent = ArrayList()
                for (mDataSnapshot in dataSnapshot.children) {
                    val event = mDataSnapshot.getValue(EventModel::class.java)
//                    event?.eventId = mDataSnapshot.key
                    event?.let { listEvent.add(it) }

                    // for you
                    val forYouAdapter = context?.let { ForYouAdapter(it, listEvent, this@HomeFragment) }
                    rvForYou.setHasFixedSize(true)
                    rvForYou.overScrollMode = View.OVER_SCROLL_NEVER
                    rvForYou.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rvForYou.adapter = forYouAdapter
                    forYouAdapter?.notifyDataSetChanged()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    context,
                    databaseError.details + " " + databaseError.message, Toast.LENGTH_LONG
                ).show()
            }
        })

        // collections
        val collectionAdapter = context?.let { CollectionsAdapter(it, this@HomeFragment) }
        rvCollections.setHasFixedSize(true)
        rvCollections.overScrollMode = View.OVER_SCROLL_NEVER
        rvCollections.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCollections.adapter = collectionAdapter
        collectionAdapter?.notifyDataSetChanged()

        // dicover
        val discoverAdapter = context?.let { DiscoverAdapter(it, this@HomeFragment) }
        rvDiscovers.setHasFixedSize(true)
        rvDiscovers.overScrollMode = View.OVER_SCROLL_NEVER
        rvDiscovers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvDiscovers.adapter = discoverAdapter
        discoverAdapter?.notifyDataSetChanged()

        // upcoming online
        val uoAdapter = UpcomingOnlineAdapter(context, this@HomeFragment)
        rvUpcomingOnline.setHasFixedSize(true)
        rvUpcomingOnline.overScrollMode = View.OVER_SCROLL_NEVER
        rvUpcomingOnline.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvUpcomingOnline.adapter = uoAdapter
        uoAdapter.notifyDataSetChanged()
        return root
    }

    override fun onSelected(position: Int) {

    }

    override fun onSelectedForYou(position: Int) {
        router.openActivity(DetailEventActivity::class.java)
    }
}