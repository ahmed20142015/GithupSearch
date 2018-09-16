package com.example.aelashry.githupsearch.di.component;

import android.app.Application;
import android.content.Context;

import com.example.aelashry.githupsearch.DemoApplication;
import com.example.aelashry.githupsearch.activity.RepositoryPresenterImp;
import com.example.aelashry.githupsearch.adapter.RepositoryAdapter;
import com.example.aelashry.githupsearch.di.ApplicationContext;
import com.example.aelashry.githupsearch.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    RepositoryPresenterImp getRepositoryPresenterImp();
    RepositoryAdapter getRepositoryAdapter();

}