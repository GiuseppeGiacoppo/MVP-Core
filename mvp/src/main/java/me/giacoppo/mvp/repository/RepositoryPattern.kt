package me.giacoppo.mvp.repository

import io.reactivex.Observable

interface RepositoryPattern<T, S : Specification> {
    fun <X> add(item: T): Observable<X>
    fun <X> add(items: Iterable<T>): Observable<X>
    fun <X> update(item: T): Observable<X>
    fun <X> remove(item: T): Observable<X>
    fun <X> remove(specification: S): Observable<X>
    operator fun get(specification: S): Observable<List<T>>
}
