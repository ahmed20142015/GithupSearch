package com.example.aelashry.githupsearch.activity;

import com.example.aelashry.githupsearch.models.Item;
import com.example.aelashry.githupsearch.models.RepositoryResult;
import com.example.aelashry.githupsearch.service.RestApiBuilder;
import com.example.aelashry.githupsearch.service.RestApiService;

import java.util.ArrayList;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class RepositoryPresenterImp implements RepositoryPresenter {

    RepositoryActivity activity;
    @Override
    public void setView(RepositoryActivity view) {
     this.activity = view;
    }

    @Override
    public int RequestRepositories(String searchKey) {
        activity.showLoader();
        requestData("android");
        return 0;
    }

    private void requestData(String filter){
        RestApiService apiService = new RestApiBuilder().getService();
        Call<RepositoryResult> call = apiService.getrepositories(filter);
        call.enqueue(new Callback<RepositoryResult>() {
            @Override
            public void onResponse(Call<RepositoryResult> call, Response<RepositoryResult> response) {
                if (response.isSuccessful()){
                    activity.hideLoader();
                    ArrayList<Item> repositories = (ArrayList<Item>) response.body().getItems();
                    activity.setRepositories(repositories);
                }

                else{
                    activity.hideLoader();
                }
            }

            @Override
            public void onFailure(Call<RepositoryResult> call, Throwable t) {
                activity.hideLoader();
            }
        });


    }
}
