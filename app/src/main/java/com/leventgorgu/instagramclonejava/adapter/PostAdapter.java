package com.leventgorgu.instagramclonejava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leventgorgu.instagramclonejava.databinding.RecyclerRowBinding;
import com.leventgorgu.instagramclonejava.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.binding.recyclerViewCommentText.setText(postArrayList.get(position).comment);
        holder.binding.recyclerViewUserEmailText.setText(postArrayList.get(position).email);

        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.binding.recyclerViewImageView);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;
        public PostHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
