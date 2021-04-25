package com.lishuaihua.xbinding.databind.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lishuaihua.binding.databind
import com.lishuaihua.xbinding.R
import com.lishuaihua.xbinding.databinding.FragmentDataBindRecycleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DataBindRecycleFragment : Fragment(R.layout.fragment_data_bind_recycle) {

    private val listViewModel: ListViewModel by viewModel()

    private val binding: FragmentDataBindRecycleBinding by databind()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = listViewModel
            adapter = ProductAdapter()
        }
    }

}