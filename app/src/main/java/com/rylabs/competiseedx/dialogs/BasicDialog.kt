package com.rylabs.competiseedx.dialogs

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.rylabs.competiseedx.R


class BasicDialog(private val mContext: Context?) {

    interface PopDialogListener {
        fun onClickButtonPopDialog(dialog: AlertDialog?)
    }

    @SuppressLint("InflateParams")
    fun popDialog(messageText: String?, headerText: String?, listener: PopDialogListener?) {
        val li = LayoutInflater.from(mContext)
        val v = li.inflate(R.layout.dialog_basic, null)
        val button: Button = v.findViewById(R.id.btn_close)
        val header: TextView = v.findViewById(R.id.dialog_txt_confirm_header)
        val message: TextView = v.findViewById(R.id.dialog_trx_confirm_message)

        header.text = headerText
        message.text = messageText

        val alert = AlertDialog.Builder(mContext!!)
        alert.setView(v)
        alert.setCancelable(false)
        val dialog = alert.create()
        button.setOnClickListener {
            listener?.onClickButtonPopDialog(dialog)
            dialog.dismiss()
        }
        dialog.show()
    }
}