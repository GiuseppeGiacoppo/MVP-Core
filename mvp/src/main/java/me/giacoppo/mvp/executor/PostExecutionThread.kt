package me.giacoppo.mvp.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler() : Scheduler
}
