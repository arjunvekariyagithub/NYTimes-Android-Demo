package com.mfp.test.di.module;

import android.app.Application;
import android.content.Context;

import com.mfp.test.BuildConfig;
import com.mfp.test.data.AppDataManager;
import com.mfp.test.data.DataManager;
import com.mfp.test.data.preferences.AppPreferencesHelper;
import com.mfp.test.data.preferences.PreferencesHelper;
import com.mfp.test.di.ApiInfo;
import com.mfp.test.di.ApplicationContext;
import com.mfp.test.di.PreferenceInfo;
import com.mfp.test.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}
