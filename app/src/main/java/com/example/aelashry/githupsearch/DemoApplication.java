package com.example.aelashry.githupsearch;

import android.app.Application;
import android.content.Context;

import com.example.aelashry.githupsearch.di.component.ApplicationComponent;
import com.example.aelashry.githupsearch.di.component.DaggerApplicationComponent;
import com.example.aelashry.githupsearch.di.module.ApplicationModule;
import com.example.aelashry.githupsearch.di.module.NetworkModule;

import javax.inject.Inject;

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;



    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule(this,"https://api.github.com/search/"))
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }



    public ApplicationComponent getComponent() {

        return applicationComponent;
    }


}