package com.mfp.test;

import android.app.Application;

import com.mfp.test.data.DataManager;
import com.mfp.test.di.component.ApplicationComponent;
import com.mfp.test.di.component.DaggerApplicationComponent;
import com.mfp.test.di.module.ApplicationModule;
import com.mfp.test.di.module.NetworkModule;

import javax.inject.Inject;


public class App extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).
                        networkModule(new NetworkModule(BuildConfig.BASE_URL)).
                        build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Required to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
