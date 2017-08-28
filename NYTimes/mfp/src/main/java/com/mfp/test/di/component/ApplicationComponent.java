package com.mfp.test.di.component;

import android.app.Application;
import android.content.Context;

import com.mfp.test.App;
import com.mfp.test.data.DataManager;
import com.mfp.test.di.ApplicationContext;
import com.mfp.test.di.module.ApplicationModule;
import com.mfp.test.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class})
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}