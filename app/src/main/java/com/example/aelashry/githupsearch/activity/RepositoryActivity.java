package com.example.aelashry.githupsearch.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.aelashry.githupsearch.DemoApplication;
import com.example.aelashry.githupsearch.R;
import com.example.aelashry.githupsearch.adapter.RepositoryAdapter;
import com.example.aelashry.githupsearch.di.component.ActivityComponent;
import com.example.aelashry.githupsearch.di.component.DaggerActivityComponent;
import com.example.aelashry.githupsearch.di.module.ActivityModule;
import com.example.aelashry.githupsearch.models.Item;
import com.example.aelashry.githupsearch.models.RepositoryResult;

import java.util.ArrayList;

import javax.inject.Inject;

public class RepositoryActivity extends AppCompatActivity implements RepositoryView {

    ProgressDialog dialog;
    RecyclerView repositoriesList;
    @Inject
    RepositoryPresenterImp presenterImp ;
    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        repositoriesList = (RecyclerView) findViewById(R.id.repositories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        repositoriesList.setHasFixedSize(true);
        repositoriesList.setLayoutManager(layoutManager);

  //      presenterImp = new RepositoryPresenterImp();
        presenterImp.setView(this);
        presenterImp.RequestRepositories("android");
    }

    @Override
    public void showLoader() {
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void hideLoader() {
        if(dialog.isShowing() && dialog != null ){
            dialog.dismiss();
        }
    }

    @Override
    public void setRepositories(ArrayList<Item> repositories) {
        RepositoryAdapter adapter =  new RepositoryAdapter(RepositoryActivity.this ,repositories);
        repositoriesList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
