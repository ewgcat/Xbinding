package com.lishuaihua.xbinding.databind.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.binding.viewbind
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.ActivityDataBindRecycleBinding


class DataBindRecycleActivity : AppCompatActivity() {

    private val binding: ActivityDataBindRecycleBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { }
        // databinding 在 Fragment 中使用
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DataBindRecycleFragment())
            .commit()
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, DataBindRecycleActivity::class.java))
        }
    }
}