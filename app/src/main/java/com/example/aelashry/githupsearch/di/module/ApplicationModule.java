package com.example.aelashry.githupsearch.di.module;

import android.app.Application;
import android.content.Context;

import com.example.aelashry.githupsearch.adapter.RepositoryAdapter;
import com.example.aelashry.githupsearch.di.ApplicationContext;
import com.example.aelashry.githupsearch.models.Item;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;


@Module(includes = {ApiModule.class})
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
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

//    @Provides
//    @ApplicationContext
//    RepositoryAdapter getRepositoryAdapter(@ApplicationContext Context context, ArrayList<Item>items) {
//        return new RepositoryAdapter(context, items);
//
//    }

}