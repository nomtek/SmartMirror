package com.nomtek.avonil.smartmirror.presenter.base;

import com.nomtek.avonil.smartmirror.view.BaseView;

/**
 * Created by Krzysztof Krol on 08/03/2017.
 */
//TODO rename to Presenter on develop
public interface BasicPresenter<V extends BaseView> {

    void attach();

    void detach();

    void bindView(V view);

    void unbindView(V view);
}
