package me.giacoppo.mvp.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread private constructor() : PostExecutionThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    private object Holder {
        val instance = UIThread()
    }

    companion object {
        val instance: PostExecutionThread by lazy { Holder.instance }
    }
}
