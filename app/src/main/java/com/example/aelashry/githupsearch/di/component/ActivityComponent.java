package com.example.aelashry.githupsearch.di.component;

import com.example.aelashry.githupsearch.activity.RepositoryActivity;
import com.example.aelashry.githupsearch.di.PerActivity;
import com.example.aelashry.githupsearch.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(RepositoryActivity repositoryActivity);

}