package me.giacoppo.mvp.repository;

import java.util.List;

import io.reactivex.Observable;

public interface RepositoryPattern<T> {
    Observable<Void> add(T item);
    Observable<Void> add(Iterable<T> items);
    Observable<Void> update(T item);
    Observable<Void> remove(T item);
    Observable<Void> remove(Specification specification);
    Observable<List<T>> query(Specification specification);
}
