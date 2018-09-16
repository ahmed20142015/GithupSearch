package com.example.aelashry.githupsearch.di.module;

import com.example.aelashry.githupsearch.service.RestApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    RestApiService provideApi(Retrofit retrofit) {
        return retrofit.create(RestApiService.class);
    }

}