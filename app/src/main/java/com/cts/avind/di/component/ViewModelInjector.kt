package com.cts.avind.di.component

import com.cts.avind.di.module.NetworkModule
import com.cts.avind.ui.main.AboutListViewModel
import com.cts.avind.ui.main.AboutItemViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified AboutListViewModel.
     * @param aboutListViewModel AboutListViewModel in which to inject the dependencies
     */
    fun inject(aboutListViewModel: AboutListViewModel)
    /**
     * Injects required dependencies into the specified AboutItemViewModel.
     * @param aboutItemViewModel AboutItemViewModel in which to inject the dependencies
     */
    fun inject(aboutItemViewModel: AboutItemViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}