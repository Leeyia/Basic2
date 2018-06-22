package com.racofix.logic;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

public interface Logic<V extends BaseVo> {

    Bundle getStateBundle();

    void attachLifecycle(Lifecycle lifecycle);

    void detachLifecycle(Lifecycle lifecycle);

    void attachVo(V vo);

    void detachVo();

    V getVo();

    boolean isVoAttached();

    void onLogicCreated();

    void onLogicDestroy();
}
