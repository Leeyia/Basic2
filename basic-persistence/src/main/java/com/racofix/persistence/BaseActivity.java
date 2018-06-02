package com.racofix.persistence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.racofix.persistence.annotation.ImplementHelper;


public abstract class BaseActivity<T extends Logic> extends FragmentActivity implements BaseVo {

    protected T mLogicImpl;

    private T getLogicIml() {
        return (T) ImplementHelper.init(getClass());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseViewModel<T> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        if (getLogicIml() != null) {
            if (viewModel.getLogicImpl() == null) {
                viewModel.setLogicImpl(getLogicIml());
                viewModel.getLogicImpl().onLogicCreated();
            }

            mLogicImpl = viewModel.getLogicImpl();
            mLogicImpl.attachLifecycle(BaseActivity.this.getLifecycle());
            mLogicImpl.attachVo(BaseActivity.this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLogicImpl!=null){
            mLogicImpl.detachLifecycle(getLifecycle());
            mLogicImpl.detachVo();
        }
    }
}
