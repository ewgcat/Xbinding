package com.lishuaihua.binding.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lishuaihua.binding.observerWhenCreated
import com.lishuaihua.binding.observerWhenDestroyed
import kotlin.properties.ReadOnlyProperty


abstract class FragmentDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    protected var viewBinding: T? = null

    init {

        /**
         * 感谢 architecture-components-samples 提供的思路
         *
         * 最原始的处理的方案 监听 Fragment 的生命周期，会存在 Fragment 和 Fragment 中的 View 生命周期不一致问题
         * 详情查看 [issue][https://github.com/hi-dhl/Binding/issues/15]
         */
        fragment.lifecycle.observerWhenCreated {
            fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewOwner ->
                viewOwner.lifecycle.observerWhenDestroyed {
                    destroyed()
                }
            }
        }

    }

    private fun destroyed() {
        viewBinding = null
    }
}