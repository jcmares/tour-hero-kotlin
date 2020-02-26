package com.mares.testkotlin.mvp.presenter

import com.mares.testkotlin.mvp.view.IView
import com.mares.testkotlin.net.service.ApiService
import com.mares.testkotlin.net.RetrofitBuilder
import com.mares.testkotlin.net.response.HeroesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PresenterApi : PresenterBase<IView> {

    constructor(view : IView, compositeDisposable: CompositeDisposable) {
        this.view = view
        this.subscription = compositeDisposable
    }

    fun getHeroes(){
        var service  = RetrofitBuilder().createService(ApiService::class.java)
        this.subscription?.add(service.getHeroes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::desplegarHeroes, this::onError ))
    }

    private fun desplegarHeroes(response : HeroesResponse) {
        this.view?.desplegarHeroes(response.superheroes)
    }

    fun onError(error : Throwable){
        this.view?.mensajeError(error.message.toString())
    }

}