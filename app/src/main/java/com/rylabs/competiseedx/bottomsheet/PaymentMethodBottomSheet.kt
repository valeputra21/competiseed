package com.rylabs.competiseedx.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rylabs.competiseedx.R
import com.rylabs.competiseedx.adapters.ForYouAdapter
import com.rylabs.competiseedx.adapters.PaymentMethodAdapter

class PaymentMethodBottomSheet(var listener: PaymentMethodAdapter.OnInteractionListener): BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppBottomSheetDialogTheme)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        bottomSheetDialog.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            val behavior = BottomSheetBehavior.from(bottomSheet!!)
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        return bottomSheetDialog
    }

    private lateinit var rvPayMethod: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dialog = inflater.inflate(R.layout.bottom_sheet_select_pay_method, null)

        rvPayMethod = dialog.findViewById(R.id.rv_payment_method)

        // for you
        val payMethodAdapter = context?.let { PaymentMethodAdapter(it, listener) }
        rvPayMethod.setHasFixedSize(true)
        rvPayMethod.overScrollMode = View.OVER_SCROLL_NEVER
        rvPayMethod.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPayMethod.adapter = payMethodAdapter
        payMethodAdapter?.notifyDataSetChanged()

        return dialog
    }
}