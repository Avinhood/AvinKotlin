package com.cts.avind.ui.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.cts.avind.data.main.ListData
import com.cts.avind.R
import com.cts.avind.base.BaseViewModel
import com.cts.avind.net.ApiInterface
import com.cts.avind.ui.post.AboutListAdapter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AboutListViewModel(): BaseViewModel(){
    @Inject
    lateinit var apiInterface: ApiInterface
    val aboutListAdapter: AboutListAdapter = AboutListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val refreshListListener = View.OnClickListener { loadAboutList() }
    val titleMessage:MutableLiveData<String> = MutableLiveData()

    private lateinit var subscription: CompositeDisposable

    init{
        loadAboutList()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onAboutListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
        titleMessage.value = ""
    }

    private fun onAboutListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveAboutListSuccess(aboutData:Single<ListData>){
        titleMessage.value = aboutData.blockingGet().title
        aboutListAdapter.updateAboutList(aboutData.blockingGet().rows)
    }

    private fun onAboutListError(){
        errorMessage.value = R.string.post_error
    }
// ================================
    private fun loadAboutList(){
    subscription.add(apiInterface.getAboutList().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { onAboutListStart() }
        .doOnTerminate { onAboutListFinish() }
        .subscribe(
            { result -> onRetrieveAboutListSuccess(result) },
            { onAboutListError() }
        ))
    }

}