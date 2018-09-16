package com.example.aelashry.githupsearch.di.module;

import android.content.Context;

import com.example.aelashry.githupsearch.adapter.RepositoryAdapter;
import com.example.aelashry.githupsearch.models.Item;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    RepositoryAdapter provideRepositoryAdapter(Context context , ArrayList<Item> items){
        return new RepositoryAdapter(context,items);
    }
}
