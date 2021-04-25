package com.lishuaihua.xbinding.viewbind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.xbinding.databinding.ActivityIncludeViewBindBinding
import com.lishuaihua.xbinding.databinding.LayoutMergeItemBinding
import com.lishuaihua.binding.viewbind


class ViewBindIncludeActivity : AppCompatActivity() {

    val binding: ActivityIncludeViewBindBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            tvTitle.setText("直接使用布局中的控件")

            // include without merge
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")

            // include
            LayoutMergeItemBinding.bind(root)
                .mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")
        }
    }

    companion object {

        fun startActivtiy(activity: Activity) {
            activity.startActivity(Intent(activity, ViewBindIncludeActivity::class.java))
        }

    }
}