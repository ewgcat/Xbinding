package com.lishuaihua.xbinding.databind

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.lishuaihua.binding.databind
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.LayoutViewCustomDataBinding


class DataBindCustomView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attr, defStyleAttr) {

    val binding: LayoutViewCustomDataBinding by databind(R.layout.layout_view_custom_data)

    init {
        with(binding) {
            result.setText("这是 ViewGroup 通过 DataBinding 绑定")
        }
    }
}