package com.example.aelashry.githupsearch.activity;

public interface RepositoryPresenter {

    public void setView(RepositoryActivity view);

    public int RequestRepositories(String searchKey);

}
