package com.lishuaihua.xbinding.databind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.binding.databind
import com.lishuaihua.xbinding.MainViewModel
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.User
import com.lishuaihua.xbinding.databinding.ActivityIncludeBinding
import com.lishuaihua.xbinding.databinding.LayoutMergeItemBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DataBindIncludeActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    private val binding: ActivityIncludeBinding by databind(R.layout.activity_include)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            user = User(name = "数据绑定：dhl", account = "数据绑定：公众号：ByteCode")

            // 布局是 ViewBdining
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")

            // 布局是 ViewBdining
            LayoutMergeItemBinding.bind(binding.root)
                .mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")

            // 布局是 DataBidning 使用 include 布局中的控件, 不包含 merge
            includeData.includeTvTitle.setText("通过代码设置 include layout 的控件")
            // 布局是 DataBidning，使用 include 布局中的控件, 包含 merge
            includeDataMerge.mergeTvTitle.setText("通过代码设置 merge layout 的控件")
        }
    }

    companion object {

        fun startActivtiy(activity: Activity) {
            activity.startActivity(Intent(activity, DataBindIncludeActivity::class.java))
        }

    }
}