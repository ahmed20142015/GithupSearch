package com.example.aelashry.githupsearch.service;

import com.example.aelashry.githupsearch.models.RepositoryResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nsikak  Thompson on 3/11/2017.
 */

public interface RestApiService {

    @GET("repositories")
    Call<RepositoryResult> getrepositories(@Query("q") String filter);

}
