package com.example.aelashry.githupsearch.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.aelashry.githupsearch.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class LayoutModule {

    @Provides
    LinearLayoutManager provideLinearLayoutManager(@ApplicationContext Context context) {
        return new LinearLayoutManager(context) ;
    }
}
