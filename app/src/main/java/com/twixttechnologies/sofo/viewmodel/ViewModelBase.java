package com.twixttechnologies.sofo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

/**
 * @author Sony Raj on 8/12/17.
 */

class ViewModelBase extends AndroidViewModel {

    final MutableLiveData<String> mErrorData;

    public MutableLiveData<String> getErrorData() {
        return mErrorData;
    }

    //Constructor
    ViewModelBase(@NonNull Application application) {
        super(application);
        mErrorData = new MutableLiveData<>();
    }
}
