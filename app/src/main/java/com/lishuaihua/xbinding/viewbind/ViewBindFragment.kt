package com.lishuaihua.xbinding.viewbind

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.FragmentViewBindBinding
import com.lishuaihua.binding.viewbind


class ViewBindFragment : Fragment(R.layout.fragment_view_bind), View.OnClickListener {


    val binding: FragmentViewBindBinding by viewbind()
    var activity: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            activity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this)
        }

    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnDialog, btnRecycle,  btnDialog, btnStub, btnInclude)
    }

    override fun onClick(v: View) {

        val lifecycle = this.lifecycle
        with(binding) {
            when (v) {
                btnDialog -> {
                    this@ViewBindFragment.context?.let { ctx ->
                        ViewBindDialog(ctx, lifecycle).show()
                    }
                }
                btnRecycle -> com.lishuaihua.xbinding.databind.list.DataBindRecycleActivity.startActivity(requireActivity())
                btnStub -> com.lishuaihua.xbinding.databind.BindViewStubActivity.startActivtiy(requireActivity())
                btnInclude -> com.lishuaihua.xbinding.viewbind.ViewBindIncludeActivity.startActivtiy(
                    requireActivity()
                )
                else -> {
                }
            }
        }
    }
}