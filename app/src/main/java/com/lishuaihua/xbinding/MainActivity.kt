package com.lishuaihua.xbinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.xbinding.databinding.ActivityMainBinding
import com.lishuaihua.binding.viewbind


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this)
        }

    }

    override fun onClick(v: View) {
        with(binding) {
            when (v) {
                btnDataBind -> com.lishuaihua.xbinding.databind.DataBindActivity.startActivity(this@MainActivity)
                btnViewBind -> com.lishuaihua.xbinding.viewbind.ViewBindActivity.startActivity(this@MainActivity)
            }
        }
    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnDataBind, btnViewBind)
    }

}