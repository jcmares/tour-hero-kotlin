package com.mares.testkotlin.mvp.presenter

import io.reactivex.disposables.CompositeDisposable

abstract class PresenterBase <T> {

    protected var subscription : CompositeDisposable? = null
    protected var view : T? = null

    init {
        this.subscription = subscription
        this.view = view
    }

}