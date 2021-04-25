package com.lishuaihua.xbinding.di

import com.lishuaihua.xbinding.MainViewModel
import com.lishuaihua.xbinding.databind.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelsModule = module {
    viewModel { MainViewModel() }
    viewModel { ListViewModel() }
}

val appModules = listOf(viewModelsModule)