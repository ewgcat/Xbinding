package com.lishuaihua.xbinding.viewbind

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.lishuaihua.xbinding.databinding.LayoutViewCustomBinding
import com.lishuaihua.binding.viewbind


class ViewBindCustomView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attr, defStyleAttr) {

    lateinit var onDialogClickListener: OnDialogClickListener

    val binding: LayoutViewCustomBinding by viewbind()

    init {
        with(binding) {
            result.setText("这是 ViewGroup 通过 ViewBinding 绑定")
            result.setOnClickListener {
                if (::onDialogClickListener.isInitialized) {
                    onDialogClickListener.onClick()
                }
            }
        }
    }

    fun setDialogClickListener(onDialogClickListener: OnDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener
    }

    interface OnDialogClickListener {
        fun onClick()
    }
}