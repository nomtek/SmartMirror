package com.nomtek.avonil.smartmirror.presenter.base;

import rx.Scheduler;

public interface SchedulersProvider {

    Scheduler getIOScheduler();

    Scheduler getMainThreadScheduler();

}