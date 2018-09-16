package com.example.aelashry.githupsearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aelashry.githupsearch.R;
import com.example.aelashry.githupsearch.models.Item;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.hdodenhof.circleimageview.CircleImageView;
@Singleton
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    Context context;
    ArrayList<Item> items;
    LayoutInflater inflater;
    @Inject
    public RepositoryAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.repository_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.ViewHolder holder, int position) {

        holder.repositoryName.setText(items.get(position).getFullName());
        Glide.with(context).load(items.get(position).getOwner().getAvatarUrl()).into(holder.ownerImage);    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView repositoryName;
        CircleImageView ownerImage;

        public ViewHolder(View itemView) {

            super(itemView);
            repositoryName = itemView.findViewById(R.id.repository_name);
            ownerImage =  itemView.findViewById(R.id.owner_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }
    }


}

