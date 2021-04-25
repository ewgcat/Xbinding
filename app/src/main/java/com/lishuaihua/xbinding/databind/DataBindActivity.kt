package com.lishuaihua.xbinding.databind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.binding.databind
import com.lishuaihua.xbinding.MainViewModel
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.ActivityDataBindBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DataBindActivity : AppCompatActivity(), View.OnClickListener {

    val viewModel: MainViewModel by viewModel()

    val binding: ActivityDataBindBinding by databind(R.layout.activity_data_bind)

    // 第二种用法 或者通过下列方式绑定数据， 所有使用 DataBinding 绑定的地方都可以使用这种方式
//    val binding: ActivityDataBindBinding by databind(R.layout.activity_data_bind) {
//        val account = Account()
//        account.name = "test"
//        this.account = account
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            account = viewModel.bindAccount()
            mainViewModel = viewModel
        }

        getViews().forEach {
            it.setOnClickListener(this)
        }
    }


    override fun onClick(v: View) {
        val lifecycle = this.lifecycle
        with(binding) {
            when (v) {
                btnBindRandom -> viewModel.generateTimber()
                btnBindAdapter -> viewModel.bindUser()
                btnDialog -> DataBindDialog(this@DataBindActivity, lifecycle).show()
                btnRecycle -> com.lishuaihua.xbinding.databind.list.DataBindRecycleActivity.startActivity(this@DataBindActivity)
                btnStub -> com.lishuaihua.xbinding.databind.BindViewStubActivity.startActivtiy(
                    this@DataBindActivity
                )
                btnInclude -> com.lishuaihua.xbinding.databind.DataBindIncludeActivity.startActivtiy(
                    this@DataBindActivity
                )
            }
        }
    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(
            btnBindRandom,
            btnBindAdapter,
            btnDialog,
            btnRecycle,
            btnStub,
            btnInclude
        )
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, DataBindActivity::class.java))
        }
    }

}