package com.racofix.aacmvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;

public class LogicImpl<V extends BaseVo> implements Logic<V>, LifecycleObserver {

    private Bundle stateBundle;
    private V vo;

    @Override
    public void attachLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    public void detachLifecycle(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    @Override
    public void attachVo(V vo) {
        LogicImpl.this.vo = vo;
    }

    @Override
    public void detachVo() {
        LogicImpl.this.vo = null;
    }

    @Override
    public V getVo() {
        return LogicImpl.this.vo;
    }


    @Override
    public boolean isVoAttached() {
        return LogicImpl.this.vo != null;
    }

    @Override
    public Bundle getStateBundle() {
        return stateBundle == null
                ? stateBundle = new Bundle()
                : stateBundle;
    }

    @Override
    public void onLogicCreated() {
        //LogicImpl create
    }

    @Override
    public void onLogicDestroy() {
        if (stateBundle != null && !stateBundle.isEmpty()) {
            stateBundle.clear();
        }
    }
}
