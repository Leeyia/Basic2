package com.racofix.persistence;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.racofix.persistence.annotation.ImplementHelper;

public class BaseFragment<T extends Logic> extends Fragment implements BaseVo {

    protected T mLogicImpl;

    private T getLogicIml() {
        return (T) ImplementHelper.init(getClass());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BaseViewModel<T> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        if (getLogicIml() != null) {
            if (viewModel.getLogicImpl() == null) {
                viewModel.setLogicImpl(getLogicIml());
                viewModel.getLogicImpl().onLogicCreated();
            }

            mLogicImpl = viewModel.getLogicImpl();
            mLogicImpl.attachLifecycle(BaseFragment.this.getLifecycle());
            mLogicImpl.attachVo(BaseFragment.this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mLogicImpl != null) {
            mLogicImpl.detachLifecycle(getLifecycle());
            mLogicImpl.detachVo();
        }
    }
}
