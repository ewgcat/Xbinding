package com.lishuaihua.xbinding.databind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewStubProxy
import com.lishuaihua.binding.databind
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.ActivityViewStubBinding
import com.lishuaihua.xbinding.databinding.ViewStubBinding
import com.lishuaihua.xbinding.databinding.ViewStubDataBinding


class BindViewStubActivity : AppCompatActivity() {

    val binding: ActivityViewStubBinding by databind(R.layout.activity_view_stub)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewStub.setOnInflateListener { stub, inflated ->

            // ViewBinding
            val viewStub: ViewStubBinding = ViewStubBinding.bind(inflated)
            viewStub.tvTitle.setText("使用 ViewStub 加载 ViewBinding 布局")

        }

        binding.viewStubData.setOnInflateListener { stub, inflated ->

            // DataBinding
            val dataViewStub: ViewStubDataBinding = DataBindingUtil.bind(inflated)!!
            dataViewStub.tvTitle.setText("使用 ViewStub 加载 DataBinding 布局")
        }

        inflateLayout(binding.viewStub)
        inflateLayout(binding.viewStubData)
    }

    private fun inflateLayout(viewStubProxy: ViewStubProxy) {
        if (!viewStubProxy.isInflated) {
            viewStubProxy.viewStub!!.inflate()
        }
    }

    companion object {

        fun startActivtiy(activity: Activity) {
            activity.startActivity(Intent(activity, BindViewStubActivity::class.java))
        }

    }

}