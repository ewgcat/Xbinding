package com.lishuaihua.xbinding.viewbind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.ActivityViewBindBinding
import com.lishuaihua.binding.viewbind


class ViewBindActivity : AppCompatActivity() {
    val binding: ActivityViewBindBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            addFragment()
        }
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ViewBindFragment())
            .commit()
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ViewBindActivity::class.java))
        }
    }
}