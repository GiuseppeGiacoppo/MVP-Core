package me.giacoppo.mvp.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Default observer with empty methods
 */
open class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onNext(value: T) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {

    }
}
