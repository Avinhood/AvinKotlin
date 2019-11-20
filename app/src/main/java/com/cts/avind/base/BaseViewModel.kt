package com.cts.avind.base

import androidx.lifecycle.ViewModel
import com.cts.avind.di.component.DaggerViewModelInjector
import com.cts.avind.di.component.ViewModelInjector
import com.cts.avind.di.module.NetworkModule
import com.cts.avind.ui.main.AboutListViewModel
import com.cts.avind.ui.main.AboutItemViewModel

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is AboutListViewModel -> injector.inject(this)
            is AboutItemViewModel -> injector.inject(this)
        }
    }
}