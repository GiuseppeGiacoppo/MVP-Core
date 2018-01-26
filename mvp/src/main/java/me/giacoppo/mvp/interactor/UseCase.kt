package me.giacoppo.mvp.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import me.giacoppo.mvp.executor.PostExecutionThread
import me.giacoppo.mvp.executor.ThreadExecutor
import java.util.*

/**
 * Default use case class
 */
abstract class UseCase<T, in Params>(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable by lazy {  CompositeDisposable() }

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
     abstract protected fun buildUseCaseObservable(params: Params): Observable<T>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observable build
     * by [.buildUseCaseObservable] ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>, params: Params) {
        Objects.requireNonNull(observer)
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
        addDisposable(observable.subscribeWith(observer))
    }

    /**
     * Clear current [CompositeDisposable].
     */
    fun clear() {
        disposables.clear()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        Objects.requireNonNull(disposable)
        Objects.requireNonNull(disposables)
        disposables.add(disposable)
    }
}
