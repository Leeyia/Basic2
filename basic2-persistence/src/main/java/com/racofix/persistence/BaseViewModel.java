package com.racofix.persistence;

import android.arch.lifecycle.ViewModel;

public final class BaseViewModel<T extends Logic> extends ViewModel {

    private T mLogic;

    void setLogicImpl(T mLogicImpl) {
        if (BaseViewModel.this.mLogic == null)
            BaseViewModel.this.mLogic = mLogicImpl;
    }

    T getLogicImpl() {
        return BaseViewModel.this.mLogic;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        BaseViewModel.this.mLogic.onLogicDestroy();
        BaseViewModel.this.mLogic = null;
    }
}
