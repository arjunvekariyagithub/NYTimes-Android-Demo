package com.mfp.test.di.component;


import com.mfp.test.di.PerActivity;
import com.mfp.test.di.module.ActivityModule;
import com.mfp.test.ui.details.DetailsActivity;
import com.mfp.test.ui.search.SearchActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SearchActivity activity);

    void inject(DetailsActivity activity);

}
