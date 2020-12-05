package com.rylabs.competiseedx.activities.admin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.dialogs.BasicDialog
import com.rylabs.competiseedx.models.EventModel
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by VALERIAN ARISSAPUTRA on 05/12/20
 * Copyright (c) 2020
 */

class CreateEventActivity: AppCompatActivity() {

    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var listEvent: ArrayList<EventModel>

    private lateinit var edtTitleEvent: EditText
    private lateinit var edtDescEvent: EditText
    private lateinit var edtOrgEvent: EditText
    private lateinit var edtPriceEvent: EditText
    private lateinit var btnPostEvent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_create_event)

        edtTitleEvent = findViewById(R.id.et_event_title)
        edtDescEvent = findViewById(R.id.et_event_desc)
        edtOrgEvent = findViewById(R.id.et_event_org)
        edtPriceEvent = findViewById(R.id.et_event_price)
        btnPostEvent = findViewById(R.id.btn_post_event)

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
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    this@CreateEventActivity,
                    databaseError.details + " " + databaseError.message, Toast.LENGTH_LONG
                ).show()
            }
        })

        btnPostEvent.setOnClickListener {

            val title = edtTitleEvent.text.trim().toString()
            val desc = edtDescEvent.text.trim().toString()
            val org = edtOrgEvent.text.trim().toString()
            val price =  edtPriceEvent.text.trim().toString().toInt()

            val date = Date()
            val datePost = date.time

            doPostEvent(
                EventModel(
                    title = title,
                    date = datePost,
                    dateDisplay = "Sabtu, 5 Desember 2020",
                    startTime = "10.00",
                    endTime = "14.30",
                    organizer = org,
                    location = "Jakarta Selatan",
                    isCertificate = true,
                    isFree = false,
                    price = price,
                    detail = desc
                )
            )
        }
    }

    private fun doPostEvent(event: EventModel) {
        mDatabaseReference.child("data_event").push()
            .setValue(event)
            .addOnSuccessListener(this) {
                BasicDialog(this).popDialog("Your Event have been added !", "Success",
                object : BasicDialog.PopDialogListener {
                    override fun onClickButtonPopDialog(dialog: AlertDialog?) {
                        dialog?.dismiss()
                    }
                })


                edtTitleEvent.setText("")
                edtDescEvent.setText("")
                edtOrgEvent.setText("")
                edtPriceEvent.setText("")

            }
            .addOnFailureListener { exception ->  Log.e("Errorni", exception.toString())}
    }


}