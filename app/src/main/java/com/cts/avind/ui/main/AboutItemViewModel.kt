package com.cts.avind.ui.main

import androidx.lifecycle.MutableLiveData
import com.cts.avind.base.BaseViewModel
import com.cts.avind.data.main.Rows

class AboutItemViewModel: BaseViewModel() {
    private val title = MutableLiveData<String>()
    private val desc = MutableLiveData<String>()
    private val image = MutableLiveData<String>()

    fun bind(item: Rows){
        title.value = item.title
        desc.value = item.description
        image.value = item.imageHref
    }

    fun getItemTitle():MutableLiveData<String>{
        return title
    }

    fun getItemDesc():MutableLiveData<String>{
        return desc
    }
    fun getItemImage():MutableLiveData<String>{
        return image
    }
}