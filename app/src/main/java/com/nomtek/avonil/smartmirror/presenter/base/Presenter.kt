package com.nomtek.avonil.smartmirror.presenter.base


import com.nomtek.avonil.smartmirror.view.BaseView
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Base presenter implementation.

 * @param <V> view.
</V> */
open class Presenter<V : BaseView>(open var schedulersProvider: SchedulersProvider? = null) :
        BasicPresenter<V> {

    private val subscriptionsToUnsubscribeOnUnbindView = CompositeSubscription()

    @Volatile var view: V? = null

    override fun attach() {
        //Implement in inheriting class if needed
    }

    override fun detach() {
        //Implement in inheriting class if needed
    }

    override fun bindView(view: V) {
        val previousView = this.view

        if (previousView != null) {
            throw IllegalStateException("Previous view is not unbounded! previousView = " + previousView)
        }

        this.view = view
    }

    override fun unbindView(view: V) {
        val previousView = this.view

        if (previousView === view) {
            this.view = null
        } else {
            throw IllegalStateException("Unexpected view! previousView = " + previousView +
                    ", view to unbind = " + view)
        }

        // Unsubscribe all subscriptions that need to be unsubscribed in this lifecycle state.
        subscriptionsToUnsubscribeOnUnbindView.clear()
    }


    internal fun unsubscribeOnUnbindView(subscription: Subscription, vararg subscriptions: Subscription) {
        subscriptionsToUnsubscribeOnUnbindView.add(subscription)

        for (s in subscriptions) {
            subscriptionsToUnsubscribeOnUnbindView.add(s)
        }
    }


    fun <M> subscribe(observable: Observable<M>, onNext: (M) -> Unit,
                      onError: ((Throwable) -> Unit) = { handleError(it) }, onComplete: (() -> Unit)? = null,
                      unsubscribeAutomatically: Boolean = false): Subscription {

        return subscribe(observable, object : Subscriber<M>() {
            override fun onNext(viewModel: M) {
                onNext(viewModel)
            }

            override fun onError(e: Throwable) {
                onError(e)
            }

            override fun onCompleted() {

            }

        }, unsubscribeAutomatically)
    }

    fun <M> subscribe(observable: Observable<M>, subscriber: Subscriber<M>,
                      unsubscribeAutomatically: Boolean = false, shouldSubscribeOnMainThread: Boolean = false): Subscription {

        val ioScheduler = schedulersProvider?.ioScheduler
        val mainThreadScheduler = schedulersProvider?.mainThreadScheduler

        val subscription: Subscription

        if (ioScheduler != null && mainThreadScheduler != null) {
            subscription = observable
                    .subscribeOn(if (shouldSubscribeOnMainThread) schedulersProvider?.mainThreadScheduler else schedulersProvider?.ioScheduler)
                    .observeOn(schedulersProvider?.mainThreadScheduler)
                    .subscribe(subscriber)
        } else {
            subscription = observable.subscribe(subscriber)
        }

        if (unsubscribeAutomatically) {
            unsubscribeOnUnbindView(subscription)
        }

        return subscription
    }

    private fun handleError(throwable: Throwable) {}

    val isViewAttached: Boolean
        get() = view != null
}