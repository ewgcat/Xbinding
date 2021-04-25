package com.lishuaihua.xbinding.viewbind

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.lifecycle.Lifecycle
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.DialogAppBinding
import com.lishuaihua.binding.viewbind


class ViewBindDialog(context: Context, lifecycle: Lifecycle) : Dialog(context, R.style.AppDialog) {

    val binding: DialogAppBinding by viewbind(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding.apply {
            result.setText("ViewBindDialog")
            result.setOnClickListener {
                Log.e(TAG, "绑定 OnClickListener")
            }

            customView.onDialogClickListener = object : ViewBindCustomView.OnDialogClickListener {
                override fun onClick() {
                    Log.e(TAG, "绑定自定义的 OnDialogClickListener")
                }

            }
        }
    }

    companion object {
        private val TAG: String = "ViewBindDialog"
    }
}