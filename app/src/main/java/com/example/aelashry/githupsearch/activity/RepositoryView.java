package com.example.aelashry.githupsearch.activity;

import com.example.aelashry.githupsearch.models.Item;
import com.example.aelashry.githupsearch.models.RepositoryResult;

import java.util.ArrayList;

public interface RepositoryView {
    void showLoader();
    void hideLoader();
    void setRepositories(ArrayList<Item> repositories);
}
