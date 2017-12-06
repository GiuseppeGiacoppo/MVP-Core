package me.giacoppo.mvp.executor;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class UIThread implements PostExecutionThread {
    private UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

    public static class SingletonHolder {
        private static final PostExecutionThread instance = new UIThread();

        private SingletonHolder(){}

        public static PostExecutionThread getInstance() {
            return instance;
        }
    }
}
