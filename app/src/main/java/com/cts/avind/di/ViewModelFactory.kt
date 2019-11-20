package com.cts.avind.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cts.avind.net.ApiInterface
import com.cts.avind.ui.main.AboutListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutListViewModel::class.java)) {
             return AboutListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}